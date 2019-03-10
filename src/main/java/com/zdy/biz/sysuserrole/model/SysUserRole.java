package com.zdy.biz.sysuserrole.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class SysUserRole extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * id       db_column: id 
     */	
	private Long id;
    /**
     * sysUserId       db_column: sys_user_id 
     */	
	private Long sysUserId;
    /**
     * sysRoleId       db_column: sys_role_id 
     */	
	private Long sysRoleId;
	
	private Long[] sysRoleIds;
	
	private Long custId;

	public SysUserRole(){
	}

	public SysUserRole(Long id){
		this.id = id;
	}


	public SysUserRole(SysUserRole sysUserRole){
		if(null != sysUserRole){
				this.setId(sysUserRole.getId());
				this.setSysUserId(sysUserRole.getSysUserId());
				this.setSysRoleId(sysUserRole.getSysRoleId());
				this.setCustId(sysUserRole.getCustId());
		}
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("sysUserId",this.sysUserId);
		map.put("sysRoleId",this.sysRoleId);
		map.put("custId", this.custId);
		return map;
	}


 
}

