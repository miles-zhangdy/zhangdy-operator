package com.zdy.test;


import com.alibaba.fastjson.JSON;
import com.zdy.biz.resource.dto.SysResourceReq;
import com.zdy.biz.resource.dto.SysResourceResp;
import com.zdy.biz.resource.service.ISysResourceService;
import com.zdy.util.BaseList;
import com.zdy.util.ServiceResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestResource {

    @Autowired
    ISysResourceService resourceService;

    @Test
    public void testResource(){
        SysResourceReq req = new SysResourceReq();
        req.setRoleId(0L);
        req.setParentId(0L);

        ServiceResult<BaseList<SysResourceResp>> sysResourceList = resourceService.findSysResourceList(req);


        System.out.println(JSON.toJSONString(sysResourceList));
    }


}
