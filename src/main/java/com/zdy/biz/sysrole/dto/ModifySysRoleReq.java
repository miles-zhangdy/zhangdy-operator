package com.zdy.biz.sysrole.dto;

import com.zdy.biz.sysrole.model.SysRole;
import lombok.Data;

@Data
public class ModifySysRoleReq  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String available;
	private Long custId;

	public ModifySysRoleReq(){
		
	}
	
	public ModifySysRoleReq(SysRole sysRole){
		if(sysRole != null){
			this.setId(sysRole.getId());
			this.setName(sysRole.getName());
			this.setAvailable(sysRole.getAvailable());
			this.setCustId(sysRole.getCustId());
		}
	}
	public SysRole toSysRole(){
		SysRole  sysRole = new SysRole();
		sysRole.setId(this.id);
		sysRole.setName(this.name);
		sysRole.setAvailable(this.available);
		sysRole.setCustId(this.custId);
		return sysRole;
	}

}
