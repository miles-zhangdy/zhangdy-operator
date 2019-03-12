package com.zdy.common.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zdy.util.Result;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result defaultErrorHandler(Exception exception) throws IOException {
		Result res = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();


		if(isAjax(request)){
			if (exception instanceof MyException) {
				return new Result(false, exception.getMessage());
			}

			return new Result(false, exception.getMessage());
		}

//
////		String language = this.getLanguage(request);
////		HashMap errorMsgMap = getErrorMessageCacheService().getLanguage(language);
//		Map<String, String> errorMsgMap = Maps.newConcurrentMap();
//		String language =null;
//		if(language==null){
//			language="zh-cn";
//		}
//		if (exception instanceof AuthenticationTokenException) {
//			JSONObject json = JSON.parseObject(exception.getMessage());
//			Integer status = json.getInteger("status");
//			String code = json.getString("code");
//			if (!CollectionUtils.isEmpty(errorMsgMap) && errorMsgMap.containsKey(code)) {
//				return new Result(status, errorMsgMap.get(code));
//			} else {
//				return new Result(status, json.get("message").toString());
//			}
//		}
//		if (exception instanceof ValidationException) {
//			List<String> list = JSON.parseArray(exception.getMessage(), String.class);
//			List<String> errorList = Lists.newArrayList();
//			for (String code : list) {
//				if (!CollectionUtils.isEmpty(errorMsgMap) && errorMsgMap.containsKey(code)) {
//					errorList.add(errorMsgMap.get(code).toString());
//				}
//			}
//			return new Result(400, errorList.toString());
//		}
//
//		if (exception instanceof IllegalArgumentException) {
//			JSONObject json = JSON.parseObject(exception.getMessage());
//			String code = json.getString("code");
//			String errorMsg = code;
//			if (!CollectionUtils.isEmpty(errorMsgMap) && errorMsgMap.containsKey(code)) {
//				errorMsg = errorMsgMap.get(code).toString();
//			}
//			return new Result(500, errorMsg);
//		}

		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		OutputStream out = (OutputStream) response.getOutputStream();
		response.setContentType("text/html; charset=UTF-8");
		out.write(exception.getMessage().getBytes());
		return res;
	}

	boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
	}
}
