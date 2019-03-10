package com.zdy.biz.sysuserrole.dto;

import com.zdy.biz.sysuserrole.model.SysUserRole;
import lombok.Data;

@Data
public class ModifySysUserRoleReq  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long sysUserId;
	private Long sysRoleId;
	private Long custId;

	
	public Long getSysRoleId() {
		return this.sysRoleId;
	}

	public ModifySysUserRoleReq(){
		
	}
	
	public ModifySysUserRoleReq(SysUserRole sysUserRole){
		if(sysUserRole != null){
			this.setId(sysUserRole.getId());
			this.setSysUserId(sysUserRole.getSysUserId());
			this.setSysRoleId(sysUserRole.getSysRoleId());
			this.setCustId(sysUserRole.getCustId());
		}
	}
	public SysUserRole toSysUserRole(){
		SysUserRole  sysUserRole = new SysUserRole();
		sysUserRole.setId(this.id);
		sysUserRole.setSysUserId(this.sysUserId);
		sysUserRole.setSysRoleId(this.sysRoleId);
		sysUserRole.setCustId(this.custId);
		return sysUserRole;
	}

	
}
