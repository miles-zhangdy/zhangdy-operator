package com.zdy.biz.siteparameter.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SiteParameterListResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SiteParameterResp[] list;
}

