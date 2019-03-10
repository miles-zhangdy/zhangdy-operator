package com.zdy.biz.siteparameter.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class SiteParameter extends Page implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id db_column: id
	 */
	private Long id;
	/**
	 * paramName db_column: PARAM_NAME
	 */
	private String paramName;
	/**
	 * paramValue db_column: PARAM_VALUE
	 */
	private String paramValue;
	/**
	 * paramComment db_column: PARAM_COMMENT
	 */
	private String paramComment;
	/**
	 * remark db_column: REMARK
	 */
	private String remark;
	/**
	 * createTime db_column: create_time
	 */
	private Date createTime;
	/**
	 * operTime db_column: oper_time
	 */
	private Date operTime;
	/**
	 * createUser db_column: create_user
	 */
	private Long createUser;
	/**
	 * rsrvStr1 db_column: RSRV_STR1
	 */
	private String rsrvStr1;
	/**
	 * rsrvStr2 db_column: RSRV_STR2
	 */
	private String rsrvStr2;
	/**
	 * rsrvStr3 db_column: RSRV_STR3
	 */
	private String rsrvStr3;
	/**
	 * rsrvStr4 db_column: RSRV_STR4
	 */
	private String rsrvStr4;
	/**
	 * rsrvStr5 db_column: RSRV_STR5
	 */
	private String rsrvStr5;
	/**
	 * rsrvStr6 db_column: RSRV_STR6
	 */
	private String rsrvStr6;

	private Long[] ids;

	public SiteParameter() {
	}

	public SiteParameter(Long id) {
		this.id = id;
	}

	public SiteParameter(SiteParameter siteParameter) {
		if (null != siteParameter) {
			this.setId(siteParameter.getId());
			this.setParamName(siteParameter.getParamName());
			this.setParamValue(siteParameter.getParamValue());
			this.setParamComment(siteParameter.getParamComment());
			this.setRemark(siteParameter.getRemark());
			this.setCreateTime(siteParameter.getCreateTime());
			this.setOperTime(siteParameter.getOperTime());
			this.setCreateUser(siteParameter.getCreateUser());
			this.setRsrvStr1(siteParameter.getRsrvStr1());
			this.setRsrvStr2(siteParameter.getRsrvStr2());
			this.setRsrvStr3(siteParameter.getRsrvStr3());
			this.setRsrvStr4(siteParameter.getRsrvStr4());
			this.setRsrvStr5(siteParameter.getRsrvStr5());
			this.setRsrvStr6(siteParameter.getRsrvStr6());
		}
	}

	public Map<String, Object> toMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("paramName", this.paramName);
		map.put("paramValue", this.paramValue);
		map.put("paramComment", this.paramComment);
		map.put("remark", this.remark);
		map.put("createTime", this.createTime);
		map.put("operTime", this.operTime);
		map.put("createUser", this.createUser);
		map.put("rsrvStr1", this.rsrvStr1);
		map.put("rsrvStr2", this.rsrvStr2);
		map.put("rsrvStr3", this.rsrvStr3);
		map.put("rsrvStr4", this.rsrvStr4);
		map.put("rsrvStr5", this.rsrvStr5);
		map.put("rsrvStr6", this.rsrvStr6);
		return map;
	}

}
