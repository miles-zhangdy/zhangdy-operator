package com.zdy.biz.dictionary.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class DictionaryParam extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * id       db_column: id 
     */	
	private Long id;
    /**
     * dictionaryId       db_column: dictionary_id 
     */	
	private Long dictionaryId;
    /**
     * paramKey       db_column: param_key 
     */	
	private String paramKey;
    /**
     * paramDesc       db_column: param_desc 
     */	
	private String paramDesc;
    /**
     * remark       db_column: remark 
     */	
	private String remark;
    /**
     * createTime       db_column: create_time 
     */	
	private Date createTime;
    /**
     * createUser       db_column: create_user 
     */	
	private Long createUser;
    /**
     * operTime       db_column: oper_time 
     */	
	private Date operTime;
	
	private Long[] ids;
	
	public DictionaryParam(){
	}

	public DictionaryParam(Long id){
		this.id = id;
	}


	public DictionaryParam(DictionaryParam dictionaryParam){
		if(null != dictionaryParam){
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
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("dictionaryId",this.dictionaryId);
		map.put("paramKey",this.paramKey);
		map.put("paramDesc",this.paramDesc);
		map.put("remark",this.remark);
		map.put("createTime",this.createTime);
		map.put("createUser",this.createUser);
		map.put("operTime",this.operTime);
		return map;
	}


}

