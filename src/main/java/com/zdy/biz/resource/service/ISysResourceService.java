package com.zdy.biz.resource.service;

import com.zdy.biz.resource.dto.*;
import com.zdy.biz.resource.model.SysResource;
import com.zdy.biz.syspermission.dto.SysPermissionReq;
import com.zdy.biz.syspermission.dto.SysPermissionResp;
import com.zdy.util.BaseList;
import com.zdy.util.ServiceResult;

public interface ISysResourceService {
	
	ServiceResult<BaseList<SysResourceResp>> findSysResourceListByPageNo(SysResourceReq req);
	
	ServiceResult<SysResourceResp> save(CreateSysResourceReq req);
	
	ServiceResult<SysResourceResp> delete(SysResourceReq req);
	
	ServiceResult<SysResourceResp> update(ModifySysResourceReq req);
	
	ServiceResult<SysResourceResp> deleteById(SysResourceReq req);
	
	ServiceResult<SysResourceResp> getById(SysResourceReq req);

	ServiceResult<BaseList<SysResourceResp>> findSysResourceList(SysResourceReq req);

	ServiceResult<Boolean> saveRoleResource(CreateSysRoleResourceReq req);

}
