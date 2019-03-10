package com.zdy.biz.user.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.common.enums.Status;
import com.zdy.util.Page;
import lombok.Data;

@Data
public class User extends Page implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id db_column: id
	 */
	private Long id;

	/**
	 * userName db_column: user_name
	 */
	private String userName;
	/**
	 * password db_column: password
	 */
	private String password;
	/**
	 * 父级id 0：主账户 非0子账户 db_column: parent_id
	 */
	private Long parentId;
	/**
	 * 真实姓名 db_column: user_compellation
	 */
	private String userCompellation;
	/**
	 * userAge db_column: user_age
	 */
	private Integer userAge;
	/**
	 * 0女1男 db_column: user_sex
	 */
	private Status userSex;
	/**
	 * userPhone db_column: user_phone
	 */
	private String userPhone;
	/**
	 * 0不冻结1冻结 db_column: user_freeze
	 */
	private Integer userFreeze;
	/**
	 * 0未审核1审核 db_column: user_validate
	 */
	private Integer userValidate;
	/**
	 * createTime db_column: create_time
	 */
	private Date createTime;
	/**
	 * createUser db_column: create_user
	 */
	private String createUser;
	/**
	 * modifyTime db_column: modify_time
	 */
	private Date modifyTime;

	private Long[] ids;


	private Date minCreateTime;
	private Date maxCreateTime;


	private Date minModifyTime;
	private Date maxModifyTime;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public User(User user) {
		if (null != user) {
			this.setId(user.getId());
			this.setUserName(user.getUserName());
			this.setPassword(user.getPassword());
			this.setParentId(user.getParentId());
			this.setUserCompellation(user.getUserCompellation());
			this.setUserAge(user.getUserAge());
			this.setUserSex(user.getUserSex());
			this.setUserPhone(user.getUserPhone());
			this.setUserFreeze(user.getUserFreeze());
			this.setUserValidate(user.getUserValidate());
			this.setCreateTime(user.getCreateTime());
			this.setCreateUser(user.getCreateUser());
			this.setModifyTime(user.getModifyTime());
		}
	}

	public Map<String, Object> toMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("userName", this.userName);
		map.put("password", this.password);
		map.put("parentId", this.parentId);
		map.put("userCompellation", this.userCompellation);
		map.put("userAge", this.userAge);
		map.put("userSex", this.userSex);
		map.put("userPhone", this.userPhone);
		map.put("userFreeze", this.userFreeze);
		map.put("userValidate", this.userValidate);
		map.put("createTime", this.createTime);
		map.put("createUser", this.createUser);
		map.put("modifyTime", this.modifyTime);
		return map;
	}





}
