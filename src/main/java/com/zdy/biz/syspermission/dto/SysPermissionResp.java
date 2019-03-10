package com.zdy.biz.syspermission.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zdy.biz.syspermission.model.SysPermission;
import lombok.Data;

@Data
public class SysPermissionResp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * 主键       db_column: id 
     */	
	private Long id;
    /**
     * 资源名称       db_column: name 
     */	
	private String name;
    /**
     * 资源类型：menu,button,       db_column: type 
     */	
	private String type;
    /**
     * 访问url地址       db_column: url 
     */	
	private String url;
    /**
     * 权限代码字符串       db_column: percode 
     */	
	private String percode;
    /**
     * 父结点id       db_column: parentid 
     */	
	private Long parentid;
    /**
     * 排序号       db_column: sortstring 
     */	
	private String sortstring;
	
    /**
     * 是否可用,1：可用，0不可用       db_column: available 
     */	
	private String available;

	private String isShow;
	
	private String checked;
	
	private List<SysPermission> childList;
	
	private String className;
	
	public SysPermissionResp(){
		
	}
	
	public SysPermissionResp(SysPermissionResp sysPermissionResp){
		if(null != sysPermissionResp){
				this.setId(sysPermissionResp.getId());
				this.setName(sysPermissionResp.getName());
				this.setType(sysPermissionResp.getType());
				this.setUrl(sysPermissionResp.getUrl());
				this.setPercode(sysPermissionResp.getPercode());
				this.setParentid(sysPermissionResp.getParentid());
				this.setSortstring(sysPermissionResp.getSortstring());
				this.setAvailable(sysPermissionResp.getAvailable());
				this.setClassName(sysPermissionResp.getClassName());
				this.setIsShow(sysPermissionResp.getIsShow());
		}
	}
	
	public SysPermissionResp(SysPermission sysPermission){
		if(null != sysPermission){
				this.id = sysPermission.getId();
				this.name = sysPermission.getName();
				this.type = sysPermission.getType();
				this.url = sysPermission.getUrl();
				this.percode = sysPermission.getPercode();
				this.parentid = sysPermission.getParentid();
				this.sortstring = sysPermission.getSortstring();
				this.available = sysPermission.getAvailable();
				this.className = sysPermission.getClassName();
				this.checked = sysPermission.getChecked();
				this.childList = sysPermission.getChildList();
				this.isShow = sysPermission.getIsShow();
		}
	}
	
	public SysPermission toSysPermission(){
		SysPermission  sysPermission = new SysPermission();
		sysPermission.setId(this.id);
		sysPermission.setName(this.name);
		sysPermission.setType(this.type);
		sysPermission.setUrl(this.url);
		sysPermission.setPercode(this.percode);
		sysPermission.setParentid(this.parentid);
		sysPermission.setSortstring(this.sortstring);
		sysPermission.setAvailable(this.available);
		sysPermission.setClassName(this.className);
		sysPermission.setIsShow(this.isShow);
		return sysPermission;
	}
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("name",this.name);
		map.put("type",this.type);
		map.put("url",this.url);
		map.put("percode",this.percode);
		map.put("parentid",this.parentid);
		map.put("sortstring",this.sortstring);
		map.put("available",this.available);
		map.put("className", this.className);
		map.put("isShow", this.isShow);
		return map;
	}
	

}

