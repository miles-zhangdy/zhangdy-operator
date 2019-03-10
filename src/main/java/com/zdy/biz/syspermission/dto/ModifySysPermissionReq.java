package com.zdy.biz.syspermission.dto;

import com.zdy.biz.syspermission.model.SysPermission;
import lombok.Data;

@Data
public class ModifySysPermissionReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String type;
	private String url;
	private String percode;
	private Long parentid;
	private String sortstring;
	private String available;
	private String className;
	private String isShow;

	public ModifySysPermissionReq() {

	}

	public ModifySysPermissionReq(SysPermission sysPermission) {
		if (sysPermission != null) {
			this.setId(sysPermission.getId());
			this.setName(sysPermission.getName());
			this.setType(sysPermission.getType());
			this.setUrl(sysPermission.getUrl());
			this.setPercode(sysPermission.getPercode());
			this.setParentid(sysPermission.getParentid());
			this.setSortstring(sysPermission.getSortstring());
			this.setAvailable(sysPermission.getAvailable());
			this.setClassName(sysPermission.getClassName());
			this.setIsShow(sysPermission.getIsShow());
		}
	}

	public SysPermission toSysPermission() {
		SysPermission sysPermission = new SysPermission();
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

}
