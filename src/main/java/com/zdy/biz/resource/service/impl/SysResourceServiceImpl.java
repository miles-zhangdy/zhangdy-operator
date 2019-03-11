package com.zdy.biz.resource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdy.biz.resource.dao.ISysResourceDao;
import com.zdy.biz.resource.dao.ISysRoleResourceDao;
import com.zdy.biz.resource.dto.*;
import com.zdy.biz.resource.model.SysResource;
import com.zdy.biz.resource.model.SysRoleResource;
import com.zdy.biz.resource.service.ISysResourceService;
import com.zdy.common.annotation.ReadDataSource;
import com.zdy.common.annotation.WriteDataSource;
import com.zdy.util.BaseList;
import com.zdy.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysResourceServiceImpl implements ISysResourceService {

	@Resource
	private ISysResourceDao sysResourceDao;

	@Resource
	private ISysRoleResourceDao roleResourceDao;

	@ReadDataSource
	@Override
	public ServiceResult<BaseList<SysResourceResp>> findSysResourceListByPageNo(SysResourceReq req) {
		ServiceResult<BaseList<SysResourceResp>> result = new ServiceResult<BaseList<SysResourceResp>>();
		if (req == null) {
			return result.error("查询条件不能为空");
		}
		PageHelper.startPage(req.getPage(), req.getPageSize());

		List<SysResource> baseList = sysResourceDao.findList(req.toSysResource());
		PageInfo<SysResource> pageInfo = new PageInfo<>(baseList);


		List<SysResourceResp> list = new ArrayList<SysResourceResp>();
		if (!CollectionUtils.isEmpty(pageInfo.getList())) {
			for (SysResource temp : pageInfo.getList()) {
				if (temp == null) {
					continue;
				}
				list.add(new SysResourceResp(temp));
			}
		}

		BaseList<SysResourceResp> sysResourceList = new BaseList<SysResourceResp>();
		sysResourceList.setList(list);
		sysResourceList.setCurPage(req.getPage());
		sysResourceList.setPageSize(req.getPageSize());
		sysResourceList.setTotalPage(pageInfo.getPages());
		sysResourceList.setTotalRows(pageInfo.getTotal());
		return result.success(sysResourceList);
	}
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<SysResourceResp> save(CreateSysResourceReq req) {
		ServiceResult<SysResourceResp> result = new ServiceResult<SysResourceResp>();
		if (req == null) {
			return result.error("保存对象不能为空");
		}
		SysResource d = req.toSysResource();

		int count = sysResourceDao.save(d);
		if (count == 0) {
			return result.error("保存失败");
		}
		return result.success();
	}
	
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<SysResourceResp> delete(SysResourceReq req) {
		ServiceResult<SysResourceResp> result = new ServiceResult<SysResourceResp>();
		if (req == null || ObjectUtils.isEmpty(req.getIds())) {
			return result.error("删除条件不能为空");
		}

		int count = sysResourceDao.delete(req.toSysResource());
		if (count == 0) {
			return result.error("删除失败");
		}
		return result.success();
	}
	
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<SysResourceResp> update(ModifySysResourceReq req) {

		ServiceResult<SysResourceResp> result = new ServiceResult<SysResourceResp>();
		if (req == null) {
			return result.error("修改条件不能为空");
		}
		int count = sysResourceDao.update(req.toSysResource());
		if (count == 0) {
			return result.error("修改失败");
		}
		return result.success();
	}

	@Override
	public ServiceResult<SysResourceResp> deleteById(SysResourceReq req) {

		return null;
	}

	@ReadDataSource
	@Override
	public ServiceResult<SysResourceResp> getById(SysResourceReq req) {
		ServiceResult<SysResourceResp> result = new ServiceResult<SysResourceResp>();
		if (req == null || req.getId() == null) {
			return result.error("查询条件不能为空");
		}
		SysResource SysResource = sysResourceDao.getById(req.getId());
		if(SysResource == null || SysResource.getId() == null){
			return result.error("获取失败");
		}
		return result.success(new SysResourceResp(SysResource));
	}

	@ReadDataSource
	@Override
	public ServiceResult<BaseList<SysResourceResp>> findSysResourceList(SysResourceReq req) {
		ServiceResult<BaseList<SysResourceResp>> result = new ServiceResult<>();
		if (req == null) {
			return result.error("查询条件不能为空");
		}
		List<SysResource> baseList = sysResourceDao.findRoleResourceByRoleIds(req.toSysResource());

		List<SysResourceResp> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(baseList)) {
			for (SysResource temp : baseList) {
				if (temp == null) {
					continue;
				}
				list.add(new SysResourceResp(temp));
			}
		}

		BaseList<SysResourceResp> sysResourceRespList = new BaseList<>();
		sysResourceRespList.setList(list);
		return result.success(sysResourceRespList);
	}

	@WriteDataSource
	@Override
	@Transactional
	public ServiceResult<Boolean> saveRoleResource(CreateSysRoleResourceReq req) {
		ServiceResult<Boolean> result = new ServiceResult<>();
		if (req == null) {
			return result.error("保存对象不能为空");
		}
		SysRoleResource sysRoleResource = req.toSysRoleResource();
		int count = roleResourceDao.batchSaving(sysRoleResource);
		if (count == 0) {
			return result.error("保存失败");
		}
		return result.success();
	}

	@Override
	@WriteDataSource
	public ServiceResult<Boolean> reloanResouce() {


		return null;
	}
}
