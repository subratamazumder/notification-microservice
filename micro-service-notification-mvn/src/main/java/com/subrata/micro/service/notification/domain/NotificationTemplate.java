package com.subrata.micro.service.notification.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notification")
public class NotificationTemplate {
@Id
private String id;
private String type;
private String body;
private String header;
public NotificationTemplate(){}
public NotificationTemplate(String type, String body,String header) {
    this.type = type;
    this.body = body;
    this.header=header;
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
public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}
@Override
public String toString() {
    return String.format(
            "NotificationTemplate[id=%s, type='%s', body='%s', header='%s']",
            id, type,body,header);
}
}
