package com.zdy.biz.sysuserrole.dto;

import com.zdy.biz.sysuserrole.model.SysUserRole;
import lombok.Data;

@Data
public class CreateSysUserRoleReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long sysUserId;

	private Long sysRoleId;
	
	private Long custId;
	
	private Long[] sysRoleIds;

	public CreateSysUserRoleReq() {

	}

	public CreateSysUserRoleReq(SysUserRole sysUserRole) {
		if (sysUserRole != null) {
			this.setSysUserId(sysUserRole.getSysUserId());
			this.setSysRoleId(sysUserRole.getSysRoleId());
			this.setCustId(sysUserRole.getCustId());
		}
	}

	public SysUserRole toSysUserRole() {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUserId(this.sysUserId);
		sysUserRole.setSysRoleId(this.sysRoleId);
		sysUserRole.setSysRoleIds(this.sysRoleIds);
		sysUserRole.setCustId(this.custId);
		return sysUserRole;
	}

}
