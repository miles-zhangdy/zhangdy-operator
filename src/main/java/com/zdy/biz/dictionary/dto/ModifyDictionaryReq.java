package com.zdy.biz.dictionary.dto;

import java.util.Date;

import com.zdy.biz.dictionary.model.Dictionary;
import lombok.Data;

@Data
public class ModifyDictionaryReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String dictionaryKey;
	private String dictionartDesc;
	private Date createTime;
	private Long createUser;
	private Date operTime;

	public ModifyDictionaryReq() {

	}

	public ModifyDictionaryReq(Dictionary dictionary) {
		if (dictionary != null) {
			this.setId(dictionary.getId());
			this.setDictionaryKey(dictionary.getDictionaryKey());
			this.setDictionartDesc(dictionary.getDictionartDesc());
			this.setCreateTime(dictionary.getCreateTime());
			this.setCreateUser(dictionary.getCreateUser());
			this.setOperTime(dictionary.getOperTime());
		}
	}

	public Dictionary toDictionary() {
		Dictionary dictionary = new Dictionary();
		dictionary.setId(this.id);
		dictionary.setDictionaryKey(this.dictionaryKey);
		dictionary.setDictionartDesc(this.dictionartDesc);
		dictionary.setCreateTime(this.createTime);
		dictionary.setCreateUser(this.createUser);
		dictionary.setOperTime(this.operTime);
		return dictionary;
	}

}
