package com.zdy.biz.resource.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class SysRoleResource extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * id       db_column: id 
     */	
	private Long id;
    /**
     * sysRoleId       db_column: sys_role_id 
     */	
	private Long sysRoleId;
    /**
     * sysResourceId       db_column: sys_resource_id 
     */	
	private Long sysResourceId;

	private Long[] sysResourceIds;
    /**
     * custId       db_column: cust_id 
     */	
	private Long custId;
	
	private Long[] ids;
	
	public SysRoleResource(){
	}

	public SysRoleResource(Long id){
		this.id = id;
	}


	public SysRoleResource(SysRoleResource sysRoleResource){
		if(null != sysRoleResource){
				this.setId(sysRoleResource.getId());
				this.setSysRoleId(sysRoleResource.getSysRoleId());
				this.setSysResourceId(sysRoleResource.getSysResourceId());
				this.setCustId(sysRoleResource.getCustId());
		}
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("sysRoleId",this.sysRoleId);
		map.put("sysResourceId",this.sysResourceId);
		map.put("custId",this.custId);
		return map;
	}


}







