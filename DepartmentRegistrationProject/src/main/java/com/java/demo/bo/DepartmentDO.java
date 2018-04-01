package com.java.demo.bo;

import java.io.Serializable;

public class DepartmentDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1359365580321863973L;
	private Integer deptId;
	private String deptName;
	private Integer mgrId;
	private Integer locId;

	public DepartmentDO() {
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public Integer getLocId() {
		return locId;
	}

	public void setLocId(Integer locId) {
		this.locId = locId;
	}
	
	
	public DepartmentDO(String deptName, Integer mgrId,
			Integer locId) {
		this.deptName = deptName;
		this.mgrId = mgrId;
		this.locId = locId;
	}

	@Override
	public String toString() {
		return "DepartmentDO [deptId=" + deptId + ", deptName=" + deptName
				+ ", mgrId=" + mgrId + ", locId=" + locId + "]";
	}

}
