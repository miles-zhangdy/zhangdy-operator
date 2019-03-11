package com.zdy.biz.resource.dto;

import java.util.Date;
import com.zdy.biz.resource.model.SysRoleResource;
import lombok.Data;

@Data
public class CreateSysRoleResourceReq{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long sysRoleId;
	
	private Long sysResourceId;
	private Long[] sysResourceIds;

	private Long custId;

	
	public CreateSysRoleResourceReq(){
		
	}
	
	public CreateSysRoleResourceReq(SysRoleResource sysRoleResource){
		if(sysRoleResource != null){
				this.setSysRoleId(sysRoleResource.getSysRoleId());
				this.setSysResourceId(sysRoleResource.getSysResourceId());
				this.setCustId(sysRoleResource.getCustId());
		}
	}
	public SysRoleResource toSysRoleResource(){
		SysRoleResource  sysRoleResource = new SysRoleResource();
		sysRoleResource.setSysRoleId(this.sysRoleId);
		sysRoleResource.setSysResourceId(this.sysResourceId);
		sysRoleResource.setSysResourceIds(this.sysResourceIds);
		sysRoleResource.setCustId(this.custId);
		return sysRoleResource;
	}
}
