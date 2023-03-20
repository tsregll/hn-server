package com.ruoyi.business.monitorUtil.mapper;

public class PreviewURLsRequest {
	private String cameraIndexCode;
	private Integer streamType;
	private String protocol;
	private Integer transmode;
	private String expand;
	private String streamform;

	public String getCameraIndexCode() {
		return cameraIndexCode;
	}

	public void setCameraIndexCode(String cameraIndexCode) {
		this.cameraIndexCode = cameraIndexCode;
	}

	public Integer getStreamType() {
		return streamType;
	}

	public void setStreamType(Integer streamType) {
		this.streamType = streamType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Integer getTransmode() {
		return transmode;
	}

	public void setTransmode(Integer transmode) {
		this.transmode = transmode;
	}

	public String getExpand() {
		return expand;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	public String getStreamform() {
		return streamform;
	}

	public void setStreamform(String streamform) {
		this.streamform = streamform;
	}
}
