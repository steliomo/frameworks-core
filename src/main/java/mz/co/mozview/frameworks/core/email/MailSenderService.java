/**
 *
 */
package mz.co.mozview.frameworks.core.email;

import java.util.Map;

import mz.co.mozview.frameworks.core.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public interface MailSenderService {

	String NAME = "mz_co_mozview_frameworks_core_email_MailSenderService";

	public void to(final String... contacts) throws BusinessException;

	public void subject(final String subject) throws BusinessException;

	public void content(final String content) throws BusinessException;

	public void cC(final String... contacts) throws BusinessException;

	public void bCc(final String... contacts) throws BusinessException;

	public String send() throws BusinessException;

	public String send(final Map<String, Object> params) throws BusinessException;

	public void templateName(final String templateName) throws BusinessException;

	public void addAttachment(final String fileName, final String filePath) throws BusinessException;
}
