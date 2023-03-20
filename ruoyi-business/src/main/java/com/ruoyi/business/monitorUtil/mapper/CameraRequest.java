package com.ruoyi.business.monitorUtil.mapper;

public class CameraRequest {
	private String regionIndexCode;
	private Integer pageNo;
	private Integer pageSize;

	public String getRegionIndexCode() {
		return regionIndexCode;
	}

	public void setRegionIndexCode(String regionIndexCode) {
		this.regionIndexCode = regionIndexCode;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
