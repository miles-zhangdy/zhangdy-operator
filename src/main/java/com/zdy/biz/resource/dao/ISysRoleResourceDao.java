package com.zdy.biz.resource.dao;

import com.zdy.biz.resource.model.SysRoleResource;
import com.zdy.util.ISuperDao;
public interface ISysRoleResourceDao  extends ISuperDao<SysRoleResource> {

   int batchSaving(SysRoleResource roleResource);

}
