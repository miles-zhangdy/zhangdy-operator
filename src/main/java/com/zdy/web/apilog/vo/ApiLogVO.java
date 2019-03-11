package com.zdy.web.apilog.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.biz.apilog.model.ApiLog;
import com.zdy.util.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiLogVO extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键       db_column: id 
     */	
	private Long id;
    /**
     * 用户id       db_column: user_id 
     */	
	private Long userId;
    /**
     * 用户名       db_column: user_name 
     */	
	private String userName;
    /**
     * 模块       db_column: module 
     */	
	private String module;
    /**
     * ip       db_column: ip 
     */	
	private String ip;
    /**
     * 请求参数       db_column: req_params 
     */	
	private String reqParams;
    /**
     * api描述       db_column: api_desc 
     */	
	private String apiDesc;
    /**
     * 类+方法名       db_column: method_path 
     */	
	private String methodPath;
    /**
     * 开始时间       db_column: start_time 
     */	
	private Date startTime;
    /**
     * 结束时间       db_column: end_time 
     */	
	private Date endTime;
    /**
     * 异常信息       db_column: error_msg 
     */	
	private String errorMsg;
    /**
     * 0-成功 1-失败       db_column: status 
     */	
	private Integer status;
	
	private Long[] ids;


	public ApiLogVO(){
		
	}

	private ApiLogVO(Long userId, String userName, String module,  String ip, String reqParams, String apiDesc, String methodPath, Date startTime, Date endTime, String errorMsg, Integer status){
		this.userId = userId;
		this.userName = userName;
		this.module = module;
		this.ip = ip;
		this.reqParams = reqParams;
		this.apiDesc = apiDesc;
		this.methodPath = methodPath;
		this.startTime = startTime;
		this.endTime = endTime;
		this.errorMsg = errorMsg;
		this.status = status;
	}


	public static ApiLogVO create(Long userId, String userName, String module,  String ip, String reqParams, String apiDesc, String methodPath, Date startTime, Date endTime, String errorMsg, Integer status){
		return new ApiLogVO(userId, userName, module, ip, reqParams, apiDesc, methodPath, startTime, endTime, errorMsg, status);
	}
	
	public ApiLogVO(ApiLogVO apiLogVO){
		if(null != apiLogVO){
				this.setId(apiLogVO.getId());
				this.setUserId(apiLogVO.getUserId());
				this.setUserName(apiLogVO.getUserName());
				this.setModule(apiLogVO.getModule());
				this.setIp(apiLogVO.getIp());
				this.setReqParams(apiLogVO.getReqParams());
				this.setApiDesc(apiLogVO.getApiDesc());
				this.setMethodPath(apiLogVO.getMethodPath());
				this.setStartTime(apiLogVO.getStartTime());
				this.setEndTime(apiLogVO.getEndTime());
				this.setErrorMsg(apiLogVO.getErrorMsg());
				this.setStatus(apiLogVO.getStatus());
		}
	}
	
	public ApiLogVO(ApiLog apiLog){
		if(null != apiLog){
				this.id = apiLog.getId();
				this.userId = apiLog.getUserId();
				this.userName = apiLog.getUserName();
				this.module = apiLog.getModule();
				this.ip = apiLog.getIp();
				this.reqParams = apiLog.getReqParams();
				this.apiDesc = apiLog.getApiDesc();
				this.methodPath = apiLog.getMethodPath();
				this.startTime = apiLog.getStartTime();
				this.endTime = apiLog.getEndTime();
				this.errorMsg = apiLog.getErrorMsg();
				this.status = apiLog.getStatus();
		}
	}
	
	public ApiLog toApiLog(){
		ApiLog  apiLog = new ApiLog();
		apiLog.setId(this.id);
		apiLog.setUserId(this.userId);
		apiLog.setUserName(this.userName);
		apiLog.setModule(this.module);
		apiLog.setIp(this.ip);
		apiLog.setReqParams(this.reqParams);
		apiLog.setApiDesc(this.apiDesc);
		apiLog.setMethodPath(this.methodPath);
		apiLog.setStartTime(this.startTime);
		apiLog.setEndTime(this.endTime);
		apiLog.setErrorMsg(this.errorMsg);
		apiLog.setStatus(this.status);
		return apiLog;
	}
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("userId",this.userId);
		map.put("userName",this.userName);
		map.put("module",this.module);
		map.put("ip",this.ip);
		map.put("reqParams",this.reqParams);
		map.put("apiDesc",this.apiDesc);
		map.put("methodPath",this.methodPath);
		map.put("startTime",this.startTime);
		map.put("endTime",this.endTime);
		map.put("errorMsg",this.errorMsg);
		map.put("status",this.status);
		return map;
	}
	


}

