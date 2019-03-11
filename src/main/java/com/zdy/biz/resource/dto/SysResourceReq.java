package com.zdy.biz.resource.dto;

import com.zdy.biz.resource.model.SysResource;
import com.zdy.util.Page;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SysResourceReq extends Page {
	/**
	 * 
	 */
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
	
	public Long[] getIds(){
		return this.ids;
	}
	
	public SysResourceReq(){
		
	}
	
	public SysResourceReq(SysResourceReq sysResourceReq){
		if(null != sysResourceReq){
				this.setId(sysResourceReq.getId());
				this.setName(sysResourceReq.getName());
				this.setModule(sysResourceReq.getModule());
				this.setUrl(sysResourceReq.getUrl());
				this.setParentId(sysResourceReq.getParentId());
				this.setMsg(sysResourceReq.getMsg());
			this.setSortName(sysResourceReq.getSortName());
			this.setOrder(sysResourceReq.getOrder());
		}
	}
	
	public SysResourceReq(SysResource sysResource){
		if(null != sysResource){
				this.id = sysResource.getId();
				this.name = sysResource.getName();
				this.module = sysResource.getModule();
				this.url = sysResource.getUrl();
				this.parentId = sysResource.getParentId();
				this.msg = sysResource.getMsg();
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
		sysResource.setIds(this.ids);
		sysResource.setRoleId(this.roleId);
		sysResource.setRoleIds(this.roleIds);
		return sysResource;
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
