package com.mk.tracrat.dto;

import java.io.Serializable;

public class UserOrganizationDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String org_id;
	private String status;
	private String created_date;
	private String created_by;
	private String modified_date;
	private String modified_by;
	
	
	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserOrganizationVo [org_id=" + org_id + ", status=" + status + ", created_date=" + created_date + ", created_by="
				+ created_by + ", modified_date=" + modified_date + ", modified_by=" + modified_by + "]";
	}

	

	

}
