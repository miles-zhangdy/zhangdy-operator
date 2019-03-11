package com.zdy.web.resource.ctrl;

import com.zdy.biz.resource.dto.CreateSysResourceReq;
import com.zdy.biz.resource.dto.ModifySysResourceReq;
import com.zdy.biz.resource.dto.SysResourceReq;
import com.zdy.biz.resource.dto.SysResourceResp;
import com.zdy.biz.resource.service.ISysResourceService;
import com.zdy.common.exception.MyException;
import com.zdy.util.BaseController;
import com.zdy.util.BaseList;
import com.zdy.util.Result;
import com.zdy.util.ServiceResult;
import com.zdy.web.resource.vo.SysResourceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sysresource/*")
public class SysResourceController extends BaseController {
	
	@Resource
	private ISysResourceService sysresourceService;

	@RequestMapping(value = "/tosysresourcepage")
	public ModelAndView toSysResourcePage() {
		ModelAndView mv = new ModelAndView("sysResource/sysResourceList");

		return mv;
	}
	
	@RequestMapping(value = "/findsysresourcelist")
	@ResponseBody
	public Result findSysResourceList(SysResourceVO vo) throws MyException {
		Result res = null;
		try {
			SysResourceReq d = new SysResourceReq(vo.toSysResource());
			d.setBeginIndex((vo.getPage() - 1) * vo.getPageSize());
			d.setPage(vo.getPage());
			d.setPageSize(vo.getPageSize());
			ServiceResult<BaseList<SysResourceResp>> serviceResult = sysresourceService.findSysResourceListByPageNo(d);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getBusinessObject());
			} else {
				return new Result(false, "获取数据错误");
			}
		} catch (Exception e) {
			throw new MyException("获取列表错误", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/addsysresource")
	@ResponseBody
	public Result addSysResource(SysResourceVO vo) throws MyException {
		Result res = null;
		try {
			HttpSession session = getSession();
			ServiceResult<SysResourceResp> serviceResult = sysresourceService
					.save(new CreateSysResourceReq(vo.toSysResource()));
			if (serviceResult != null && serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				res = new Result(false, "添加失败");
			}
		} catch (Exception e) {
			throw new MyException("添加信息异常", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/deletesysresource")
	@ResponseBody
	public Result deleteSysResource(String id) throws MyException {
		Result res = null;
		try {
			SysResourceReq req = new SysResourceReq();
			String[] array = id.split(",");
			Long[] a = new Long[array.length];
			int i = 0;
			for (String str : array) {
				a[i++] = Long.parseLong(str);
			}
			req.setIds(a);
			ServiceResult<SysResourceResp> serviceResult = sysresourceService.delete(req);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("删除数据异常", e);
		}
		return res;
	}

	@RequestMapping(value = "/modifysysresource")
	@ResponseBody
	public Result modifySysResource(SysResourceVO vo) throws MyException {
		Result res = null;
		try {
			ServiceResult<SysResourceResp> serviceResult = sysresourceService.update(new ModifySysResourceReq(vo.toSysResource()));
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("修改数据异常", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/getsysresource")
	@ResponseBody
	public Result getUser(Long id) throws MyException {
		Result res = null;
		try {
			SysResourceReq req = new SysResourceReq();
			req.setId(id);
			ServiceResult<SysResourceResp> serviceResult = sysresourceService.getById(req);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getBusinessObject());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("获取数据异常", e);
		}
		return res;
	}

	@RequestMapping(value = "/reloanresource")
	@ResponseBody
	public Result reloadResoure(){

		return null;
	}

		
}
