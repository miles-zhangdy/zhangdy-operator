package com.zdy.biz.dictionary.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class DictionaryListResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DictionaryResp[] list;
}

