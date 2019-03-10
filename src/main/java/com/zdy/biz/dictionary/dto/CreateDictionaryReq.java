package com.zdy.biz.dictionary.dto;

import java.util.Date;

import com.zdy.biz.dictionary.model.Dictionary;
import lombok.Data;

@Data
public class CreateDictionaryReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dictionaryKey;

	private String dictionartDesc;

	private Date createTime;

	private Long createUser;

	private Date operTime;


	public CreateDictionaryReq() {

	}

	public CreateDictionaryReq(Dictionary dictionary) {
		if (dictionary != null) {
			this.setDictionaryKey(dictionary.getDictionaryKey());
			this.setDictionartDesc(dictionary.getDictionartDesc());
			this.setCreateTime(dictionary.getCreateTime());
			this.setCreateUser(dictionary.getCreateUser());
			this.setOperTime(dictionary.getOperTime());
		}
	}

	public Dictionary toDictionary() {
		Dictionary dictionary = new Dictionary();
		dictionary.setDictionaryKey(this.dictionaryKey);
		dictionary.setDictionartDesc(this.dictionartDesc);
		dictionary.setCreateTime(this.createTime);
		dictionary.setCreateUser(this.createUser);
		dictionary.setOperTime(this.operTime);
		return dictionary;
	}
}
