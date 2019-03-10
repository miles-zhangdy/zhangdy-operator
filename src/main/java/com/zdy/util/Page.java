package com.zdy.util;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Page {
	   // 当前页码
    private Integer page;
    // 最大页码数
    private Integer maxPage;
    // 总记录数
    private Integer totalCount;
    // 查询开始条数,翻页的开始条数位置
    private Integer beginIndex;
    // 每页的条数
    private Integer pageSize;
    // 传给前台的数据列表数据
    private List<?> data;
    // 传给前台的数据单个数据
    private Object info;
    // 从前台传入后台的查询参数
    private Map<String, Object> parm = new HashMap<String, Object>();
    // 返回码
    private boolean success;
    // 返回错误或成功的消息
    private String msg;
    
    private String sortName;
    
    private String order;
    
    public Page(){}
    
    public Page(int count, int pagesize){
    	this.maxPage = count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
    }

    
}
