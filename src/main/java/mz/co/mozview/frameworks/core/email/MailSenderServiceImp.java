/**
 * MozView technologies, lda - 2010 - 2015
 */
package mz.co.mozview.frameworks.core.email;

import java.util.Map;

import javax.inject.Inject;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author Stélio Moiane
 *
 */
@Service(MailSenderService.NAME)
public class MailSenderServiceImp implements MailSenderService {

	@Inject
	private JavaMailSender mailSender;

	@Inject
	private SimpleMailMessage simpleMailMessage;

	@Inject
	private VelocityEngine velocityengine;

	private String templateName;

	@Override
	public void to(final String... contacts) throws BusinessException {
		this.simpleMailMessage.setTo(contacts);
	}

	@Override
	public void subject(final String subject) throws BusinessException {
		this.simpleMailMessage.setSubject(subject);
	}

	@Override
	public void content(final String content) throws BusinessException {
		this.simpleMailMessage.setText(content);
	}

	@Override
	public void cC(final String... contacts) throws BusinessException {
		this.simpleMailMessage.setCc(contacts);
	}

	@Override
	public void bCc(final String... contacts) throws BusinessException {
		this.simpleMailMessage.setBcc(contacts);
	}

	@Override
	public String send() throws BusinessException {
		this.mailSender.send(this.simpleMailMessage);
		return this.simpleMailMessage.getText();
	}

	@Override
	public void templateName(final String templateName) throws BusinessException {
		this.templateName = templateName;
	}

	@Override
	public String send(final Map<String, Object> params) throws BusinessException {

		this.mailSender.send(mimeMessage -> {
			final String ENCODING = "UTF-8";

			MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			message.setTo(MailSenderServiceImp.this.simpleMailMessage.getTo());
			message.setSubject(MailSenderServiceImp.this.simpleMailMessage.getSubject());

			String body = VelocityEngineUtils.mergeTemplateIntoString(MailSenderServiceImp.this.velocityengine,
					MailSenderServiceImp.this.templateName, ENCODING, params);

			message.setText(body, true);
		});

		return this.simpleMailMessage.getText();
	}
}
