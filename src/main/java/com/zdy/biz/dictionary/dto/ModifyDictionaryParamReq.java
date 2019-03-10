package com.zdy.biz.dictionary.dto;

import java.util.Date;

import com.zdy.biz.dictionary.model.DictionaryParam;
import lombok.Data;

@Data
public class ModifyDictionaryParamReq  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long dictionaryId;
	private String paramKey;
	private String paramDesc;
	private String remark;
	private Date createTime;
	private Long createUser;
	private Date operTime;

	public ModifyDictionaryParamReq(){
		
	}
	
	public ModifyDictionaryParamReq(DictionaryParam dictionaryParam){
		if(dictionaryParam != null){
			this.setId(dictionaryParam.getId());
			this.setDictionaryId(dictionaryParam.getDictionaryId());
			this.setParamKey(dictionaryParam.getParamKey());
			this.setParamDesc(dictionaryParam.getParamDesc());
			this.setRemark(dictionaryParam.getRemark());
			this.setCreateTime(dictionaryParam.getCreateTime());
			this.setCreateUser(dictionaryParam.getCreateUser());
			this.setOperTime(dictionaryParam.getOperTime());
		}
	}
	public DictionaryParam toDictionaryParam(){
		DictionaryParam  dictionaryParam = new DictionaryParam();
		dictionaryParam.setId(this.id);
		dictionaryParam.setDictionaryId(this.dictionaryId);
		dictionaryParam.setParamKey(this.paramKey);
		dictionaryParam.setParamDesc(this.paramDesc);
		dictionaryParam.setRemark(this.remark);
		dictionaryParam.setCreateTime(this.createTime);
		dictionaryParam.setCreateUser(this.createUser);
		dictionaryParam.setOperTime(this.operTime);
		return dictionaryParam;
	}
	
}
