package com.devsuperior.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.integrations.dto.EmailDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {

	private static Logger LOG = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private SendGrid sendGrid;

	public void sendEmail(EmailDTO dto) {

		var from = new Email(dto.getFromEmail(), dto.getFromName());
		var to = new Email(dto.getTo());
		var content = new Content(dto.getContentType(), dto.getBody());
		var mail = new Mail(from, dto.getSubject(), to, content);
		var request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			LOG.info("Sending email to:" + dto.getTo());
			var response = sendGrid.api(request);
			if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
				LOG.error("Error sending email:" + response.getBody());
			} else {
				LOG.info("Email send status:" + response.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
