package com.zdy.biz.resource.dto;

import com.zdy.biz.resource.model.SysResource;
import lombok.Data;

@Data
public class ModifySysResourceReq  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String module;
	private String url;
	private Long parentId;
	private String msg;
	


	public ModifySysResourceReq(){
		
	}
	
	public ModifySysResourceReq(SysResource sysResource){
		if(sysResource != null){
			this.setId(sysResource.getId());
			this.setName(sysResource.getName());
			this.setModule(sysResource.getModule());
			this.setUrl(sysResource.getUrl());
			this.setParentId(sysResource.getParentId());
			this.setMsg(sysResource.getMsg());
		}
	}
	public SysResource toSysResource(){
		SysResource  sysResource = new SysResource();
		sysResource.setId(this.id);
		sysResource.setName(this.name);
		sysResource.setModule(this.module);
		sysResource.setUrl(this.url);
		sysResource.setParentId(this.parentId);
		sysResource.setMsg(this.msg);
		return sysResource;
	}
	
}
