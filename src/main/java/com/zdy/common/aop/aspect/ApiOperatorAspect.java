package com.zdy.common.aop.aspect;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.zdy.common.Constant;
import com.zdy.common.annotation.ApiOperator;
import com.zdy.common.model.SessionUser;
import com.zdy.util.IPUtils;
import com.zdy.web.apilog.vo.ApiLogVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Aspect
@Component
@Slf4j
public class ApiOperatorAspect {

    private static final String CONNECTOR = "-";

    @Around("@annotation(com.zdy.common.annotation.ApiOperator)")
    public Object webLog(ProceedingJoinPoint joinPoint) throws Throwable{
        Long startTime = System.currentTimeMillis();
        Long endTime = null;
        try {
            final Object result = joinPoint.proceed();
            endTime = System.currentTimeMillis();
            this.log(joinPoint, startTime, endTime, null, 0);
            return result;
        } catch (Exception e) {
            endTime = System.currentTimeMillis();
            this.log(joinPoint, startTime, endTime, e.getMessage(), 1);
            throw e;
        }
    }

    private void log(ProceedingJoinPoint joinPoint, Long startTime, Long endTime, String errorMsg, Integer status){
        try{
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (request == null ) {
                return;
            }
            ApiOperator ctrlDesc = this.getCtrlMethodDescription(joinPoint);
            ApiOperator methodDesc = this.getMethodDescription(joinPoint);
            SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(Constant.ENVIRONMENT_USER);
            Long userId = sessionUser.getId();
            String userName = sessionUser.getUserCompellation();
            String module = ctrlDesc.module();
            String ip = IPUtils.getRemoteIpAddr(request);
            Object reqParams = null;
            try {
                reqParams = JSON.toJSONString(this.getFieldsName(joinPoint));
            } catch (Exception e) {
                reqParams = joinPoint.getArgs();
            }
            String apiDesc = ctrlDesc.moduledesc().concat(CONNECTOR).concat(methodDesc.method());
            String clazzName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String methdPath = clazzName.concat(".").concat(methodName);
            ApiLogVO apiLogVO = ApiLogVO.create(userId, userName, module, ip, JSON.toJSONString(reqParams), apiDesc, methdPath, new Date(startTime), new Date(endTime), errorMsg, status);
            log.info("操作日志:{}", JSON.toJSONString(apiLogVO));
            // TODO 操作日志入库
        }catch (Exception e){
            log.error("处理日志异常：", e);
        }
    }



    @SuppressWarnings("all")
    public ApiOperator getMethodDescription(ProceedingJoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = joinPoint.getTarget().getClass();
        Method[] methods = targetClass.getMethods();
        Object[] arguments = joinPoint.getArgs();
        ApiOperator systemOperatorLog = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    systemOperatorLog = method.getAnnotation(ApiOperator.class);
                    break;
                }
            }
        }
        return systemOperatorLog;
    }

    @SuppressWarnings("all")
    public ApiOperator getCtrlMethodDescription(ProceedingJoinPoint joinPoint) throws Exception {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        ApiOperator systemOperatorLog= targetClass.getAnnotation(ApiOperator.class);
        return systemOperatorLog;
    }


    /**
     * 获取被切参数名以及参数值
     * @return
     */
    private Map<String, Object> getFieldsName(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Map<String, Object> map = Maps.newConcurrentMap();
        //此处joinPoint的实现类是MethodInvocationProceedingJoinPoint
        Signature signature = joinPoint.getSignature();
        //获取参数名
        MethodSignature methodSignature = (MethodSignature) signature;
        for(int i=0;i<methodSignature.getParameterNames().length;i++){
            String paramName = methodSignature.getParameterNames()[i];
            if (paramName.toLowerCase().indexOf("password") > -1
                    ||paramName.toLowerCase().indexOf("pwd") >-1 ) {
                continue;
            }
            map.put(paramName, args[i]);
        }
        return map;
    }


}
