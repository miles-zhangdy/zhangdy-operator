package com.zdy.biz.siteparameter.dto;

import java.util.Date;

import com.zdy.biz.siteparameter.model.SiteParameter;
import lombok.Data;

@Data
public class ModifySiteParameterReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String paramName;
	private String paramValue;
	private String paramComment;
	private String remark;
	private Date createTime;
	private Date operTime;
	private Long createUser;
	private String rsrvStr1;
	private String rsrvStr2;
	private String rsrvStr3;
	private String rsrvStr4;
	private String rsrvStr5;
	private String rsrvStr6;


	public String getRsrvStr6() {
		return this.rsrvStr6;
	}

	public ModifySiteParameterReq() {

	}

	public ModifySiteParameterReq(SiteParameter siteParameter) {
		if (siteParameter != null) {
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

	public SiteParameter toSiteParameter() {
		SiteParameter siteParameter = new SiteParameter();
		siteParameter.setId(this.id);
		siteParameter.setParamName(this.paramName);
		siteParameter.setParamValue(this.paramValue);
		siteParameter.setParamComment(this.paramComment);
		siteParameter.setRemark(this.remark);
		siteParameter.setCreateTime(this.createTime);
		siteParameter.setOperTime(this.operTime);
		siteParameter.setCreateUser(this.createUser);
		siteParameter.setRsrvStr1(this.rsrvStr1);
		siteParameter.setRsrvStr2(this.rsrvStr2);
		siteParameter.setRsrvStr3(this.rsrvStr3);
		siteParameter.setRsrvStr4(this.rsrvStr4);
		siteParameter.setRsrvStr5(this.rsrvStr5);
		siteParameter.setRsrvStr6(this.rsrvStr6);
		return siteParameter;
	}

}
