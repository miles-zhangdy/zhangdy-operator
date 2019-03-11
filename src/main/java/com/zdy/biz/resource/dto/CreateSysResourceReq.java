package com.zdy.biz.resource.dto;

import com.zdy.biz.resource.model.SysResource;
import lombok.Data;

@Data
public class CreateSysResourceReq{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String name;
	
	private String module;
	
	private String url;
	
	private Long parentId;
	
	private String msg;

	
	public CreateSysResourceReq(){
		
	}
	
	public CreateSysResourceReq(SysResource sysResource){
		if(sysResource != null){
				this.setName(sysResource.getName());
				this.setModule(sysResource.getModule());
				this.setUrl(sysResource.getUrl());
				this.setParentId(sysResource.getParentId());
				this.setMsg(sysResource.getMsg());
		}
	}
	public SysResource toSysResource(){
		SysResource  sysResource = new SysResource();
		sysResource.setName(this.name);
		sysResource.setModule(this.module);
		sysResource.setUrl(this.url);
		sysResource.setParentId(this.parentId);
		sysResource.setMsg(this.msg);
		return sysResource;
	}
}
