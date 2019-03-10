package com.zdy.biz.sysrole.dto;

import java.util.HashMap;
import java.util.Map;

import com.zdy.biz.sysrole.model.SysRole;
import com.zdy.util.Page;
import lombok.Data;

@Data
public class SysRoleReq extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    /**
     * id       db_column: id 
     */	
	private Long id;
    /**
     * name       db_column: name 
     */	
	private String name;
    /**
     * 是否可用,1：可用，0不可用       db_column: available 
     */	
	private String available;
	
	private Long userId;
	
	private Long custId;
	
	private Long[] ids;
	
	public void setIds(Long[] ids){
		this.ids = ids;
	}
	
	public Long[] getIds(){
		return this.ids;
	}
	
	public SysRoleReq(){
		
	}
	
	public SysRoleReq(SysRoleReq sysRoleReq){
		if(null != sysRoleReq){
				this.setId(sysRoleReq.getId());
				this.setName(sysRoleReq.getName());
				this.setAvailable(sysRoleReq.getAvailable());
				this.setCustId(sysRoleReq.getCustId());
		}
	}
	
	public SysRoleReq(SysRole sysRole){
		if(null != sysRole){
				this.id = sysRole.getId();
				this.name = sysRole.getName();
				this.available = sysRole.getAvailable();
				this.custId = sysRole.getCustId();
		}
	}
	
	public SysRole toSysRole(){
		SysRole  sysRole = new SysRole();
		sysRole.setId(this.id);
		sysRole.setName(this.name);
		sysRole.setAvailable(this.available);
		sysRole.setIds(this.ids);
		sysRole.setUserId(this.userId);
		sysRole.setCustId(this.custId);
		sysRole.setPage(this.getPage());
		sysRole.setBeginIndex(this.getBeginIndex());
		sysRole.setPageSize(this.getPageSize());
		return sysRole;
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("name",this.name);
		map.put("available",this.available);
		map.put("custId", this.custId);
		return map;
	}
	

}

