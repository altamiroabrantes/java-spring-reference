package com.devsuperior.integrations.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String fromEmail;
	private String fromName;
	private String replyTo;
	private String to;
	private String subject;
	private String body;
	private String contentType;
	
	public EmailDTO() {}

	public EmailDTO(String fromEmail, String fromName, String replyTo, String to, String subject, String body,
			String contentType) {
		this.fromEmail = fromEmail;
		this.fromName = fromName;
		this.replyTo = replyTo;
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.contentType = contentType;
	}
	
}
