package com.subrata.micro.service.notification.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notification")
public class NotificationTemplate {
	@Id
	private String id;
	private String type;
	private String body;
	private String subject;
	private String communicationType;

	public NotificationTemplate() {
	}

	public NotificationTemplate(String type, String body, String communicationType, String subject) {
		this.type = type;
		this.body = body;
		this.communicationType = communicationType;
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	@Override
	public String toString() {
		return String.format("NotificationTemplate[id=%s, type='%s', body='%s', communicationType='%s']", id, type,
				body, communicationType);
	}
}
