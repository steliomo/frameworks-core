/**
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.sms;

import mz.co.mozview.frameworks.core.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public interface SmsSenderService {

	String NAME = "mz_co_mozview_frameworks_core_sms_SmsSenderService";

	public String send(String toNumber, String message) throws BusinessException;
}
