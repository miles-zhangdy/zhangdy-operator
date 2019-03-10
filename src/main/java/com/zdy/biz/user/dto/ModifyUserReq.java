package com.zdy.biz.user.dto;

import com.zdy.biz.user.model.User;
import com.zdy.common.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class ModifyUserReq {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String password;
	private Long parentId;
	private String userCompellation;
	private Integer userAge;
	private Status userSex;
	private String userPhone;
	private Integer userFreeze;
	private Integer userValidate;
	private Date createTime;
	private String createUser;
	private Date modifyTime;

	public ModifyUserReq() {

	}

	public ModifyUserReq(User user) {
		if (null != user) {
			this.id = user.getId();
			this.userName = user.getUserName();
			this.password = user.getPassword();
			this.parentId = user.getParentId();
			this.userCompellation = user.getUserCompellation();
			this.userAge = user.getUserAge();
			this.userSex = user.getUserSex();
			this.userPhone = user.getUserPhone();
			this.userFreeze = user.getUserFreeze();
			this.userValidate = user.getUserValidate();
			this.createTime = user.getCreateTime();
			this.createUser = user.getCreateUser();
			this.modifyTime = user.getModifyTime();
		}
	}

	public User toUser() {
		User user = new User();
		user.setId(this.id);
		user.setUserName(this.userName);
		user.setPassword(this.password);
		user.setParentId(this.parentId);
		user.setUserCompellation(this.userCompellation);
		user.setUserAge(this.userAge);
		user.setUserSex(this.userSex);
		user.setUserPhone(this.userPhone);
		user.setUserFreeze(this.userFreeze);
		user.setUserValidate(this.userValidate);
		user.setCreateTime(this.createTime);
		user.setCreateUser(this.createUser);
		user.setModifyTime(this.modifyTime);
		return user;
	}
}
