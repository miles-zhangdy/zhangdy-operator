package com.zdy.biz.resource.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class SysResource extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键       db_column: id 
     */	
	private Long id;
    /**
     * 资源名       db_column: name 
     */	
	private String name;
    /**
     * 模块       db_column: module 
     */	
	private String module;
    /**
     * url       db_column: url 
     */	
	private String url;
    /**
     * 父节点       db_column: parent_id 
     */	
	private Long parentId;
    /**
     * 提示信息       db_column: msg 
     */	
	private String msg;
	
	private Long[] ids;

	private Long roleId;

	private Long[] roleIds;
	
	public SysResource(){
	}

	public SysResource(Long id){
		this.id = id;
	}


	public SysResource(SysResource sysResource){
		if(null != sysResource){
				this.setId(sysResource.getId());
				this.setName(sysResource.getName());
				this.setModule(sysResource.getModule());
				this.setUrl(sysResource.getUrl());
				this.setParentId(sysResource.getParentId());
				this.setMsg(sysResource.getMsg());
		}
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("name",this.name);
		map.put("module",this.module);
		map.put("url",this.url);
		map.put("parentId",this.parentId);
		map.put("msg",this.msg);
		return map;
	}


}







