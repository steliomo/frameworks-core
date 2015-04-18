/**
 * MozView Technologies, Lda. 2010 - 2015
 */
package mz.co.mozview.frameworks.core.sms;

import java.util.ArrayList;
import java.util.List;

import mz.co.mozview.frameworks.core.exception.BusinessException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

/**
 * @author Stélio Moiane
 *
 */
@Service(SmsSenderService.NAME)
public class SmsSenderServiceImp implements SmsSenderService {

	public static final String ACCOUNT_SID = "AC2d819526db958dfd7174d6df54cdfa67";
	public static final String AUTH_TOKEN = "5f33f14b41bd6d2721a5760ff7a19de2";
	public static final String FROM_NUMBER = "+18025461002";

	@Override
	public String send(final String toNumber, final String message) throws BusinessException {

		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("Body", message));
		params.add(new BasicNameValuePair("To", toNumber));
		params.add(new BasicNameValuePair("From", FROM_NUMBER));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message msg = null;
		try {
			msg = messageFactory.create(params);
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}

		return msg.getBody();
	}
}
