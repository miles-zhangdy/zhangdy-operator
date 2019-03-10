package com.zdy.biz.sysrole.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class SysRole extends Page implements java.io.Serializable {
	
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
	
	private Long[] ids;
	
	private String checked;
	
	private Long custId;
	
	public SysRole(){
	}

	public SysRole(Long id){
		this.id = id;
	}


	public SysRole(SysRole sysRole){
		if(null != sysRole){
				this.setId(sysRole.getId());
				this.setName(sysRole.getName());
				this.setAvailable(sysRole.getAvailable());
				this.setCustId(sysRole.getCustId());
		}
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

