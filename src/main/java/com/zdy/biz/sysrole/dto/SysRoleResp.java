package com.zdy.biz.sysrole.dto;

import com.zdy.biz.sysrole.model.SysRole;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class SysRoleResp {

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

	private Long custId;
	
	private String checked;
	
	public SysRoleResp(){
		
	}
	
	public SysRoleResp(SysRoleResp sysRoleResp){
		if(null != sysRoleResp){
				this.setId(sysRoleResp.getId());
				this.setName(sysRoleResp.getName());
				this.setAvailable(sysRoleResp.getAvailable());
				this.setCustId(sysRoleResp.getCustId());
		}
	}
	
	public SysRoleResp(SysRole sysRole){
		if(null != sysRole){
				this.id = sysRole.getId();
				this.name = sysRole.getName();
				this.available = sysRole.getAvailable();
				this.setChecked(sysRole.getChecked());
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
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("name",this.name);
		map.put("available",this.available);
		map.put("custId", this.custId);
		return map;
	}

}

