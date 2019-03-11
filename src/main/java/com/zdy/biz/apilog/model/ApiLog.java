package com.zdy.biz.apilog.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class ApiLog extends Page implements java.io.Serializable {
	
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
	
	public ApiLog(){
	}

	public ApiLog(Long id){
		this.id = id;
	}


	public ApiLog(ApiLog apiLog){
		if(null != apiLog){
				this.setId(apiLog.getId());
				this.setUserId(apiLog.getUserId());
				this.setUserName(apiLog.getUserName());
				this.setModule(apiLog.getModule());
				this.setIp(apiLog.getIp());
				this.setReqParams(apiLog.getReqParams());
				this.setApiDesc(apiLog.getApiDesc());
				this.setMethodPath(apiLog.getMethodPath());
				this.setStartTime(apiLog.getStartTime());
				this.setEndTime(apiLog.getEndTime());
				this.setErrorMsg(apiLog.getErrorMsg());
				this.setStatus(apiLog.getStatus());
		}
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







