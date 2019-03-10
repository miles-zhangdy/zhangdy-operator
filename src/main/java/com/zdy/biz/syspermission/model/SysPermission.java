package com.zdy.biz.syspermission.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;


@Data
public class SysPermission extends Page implements java.io.Serializable {
	
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
	
	private Long[] ids;
	
	private Long roleId;
	
	private String checked;
	
	private Long[] roleIds;
	
	private List<SysPermission> childList;
	
	private String className;
	
	private Long custId;
	
	private Long[] sysRoleIds;
	
	public SysPermission(){
	}

	public SysPermission(Long id){
		this.id = id;
	}


	public SysPermission(SysPermission sysPermission){
		if(null != sysPermission){
				this.setId(sysPermission.getId());
				this.setName(sysPermission.getName());
				this.setType(sysPermission.getType());
				this.setUrl(sysPermission.getUrl());
				this.setPercode(sysPermission.getPercode());
				this.setParentid(sysPermission.getParentid());
				this.setSortstring(sysPermission.getSortstring());
				this.setAvailable(sysPermission.getAvailable());
				this.setClassName(sysPermission.getClassName());
		}
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
		return map;
	}

}

