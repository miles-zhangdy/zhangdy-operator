package com.zdy.biz.resource.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysResourceListResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysResourceResp[] list;
	

}

