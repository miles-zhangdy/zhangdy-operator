package com.zdy.biz.resource.dao;

import com.zdy.biz.resource.model.SysResource;
import com.zdy.util.ISuperDao;

import java.util.List;

public interface ISysResourceDao  extends ISuperDao<SysResource> {

    List<SysResource> findRoleResourceByRoleIds(SysResource resource);

	
}
