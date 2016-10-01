package com.subrata.micro.service.notification.domain;

public class Notification {
	private String recipientName;
	private String recipientEmail;
	private String communicationType;
	private String applicationNo;
	public Notification(){}
	public Notification(String recipientName,String recipientEmail,String communicationType,String applicationNo){
		this.applicationNo = applicationNo;
		this.recipientEmail = recipientEmail;
		this.recipientName = recipientName;
		this.communicationType = communicationType;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getCommunicationType() {
		return communicationType;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
}

