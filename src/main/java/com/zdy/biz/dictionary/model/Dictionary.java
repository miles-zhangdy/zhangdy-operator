package com.zdy.biz.dictionary.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class Dictionary extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * id       db_column: id 
     */	
	private Long id;
    /**
     * dictionaryKey       db_column: dictionary_key 
     */	
	private String dictionaryKey;
    /**
     * dictionartDesc       db_column: dictionart_desc 
     */	
	private String dictionartDesc;
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
	
	public Dictionary(){
	}

	public Dictionary(Long id){
		this.id = id;
	}


	public Dictionary(Dictionary dictionary){
		if(null != dictionary){
				this.setId(dictionary.getId());
				this.setDictionaryKey(dictionary.getDictionaryKey());
				this.setDictionartDesc(dictionary.getDictionartDesc());
				this.setCreateTime(dictionary.getCreateTime());
				this.setCreateUser(dictionary.getCreateUser());
				this.setOperTime(dictionary.getOperTime());
		}
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("id",this.id);
		map.put("dictionaryKey",this.dictionaryKey);
		map.put("dictionartDesc",this.dictionartDesc);
		map.put("createTime",this.createTime);
		map.put("createUser",this.createUser);
		map.put("operTime",this.operTime);
		return map;
	}


}

