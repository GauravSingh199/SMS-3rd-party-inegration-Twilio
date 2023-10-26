package com.sms.integration.sms.integration.service;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sms.integration.sms.integration.SmsPayload.SmsRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String twilioAccountSid;

    @Value("${twilio.authToken}")
    private String twilioAuthToken;

    public void sendSms(SmsRequest smsRequest) {
        Twilio.init(twilioAccountSid, twilioAuthToken);
        String to = smsRequest.getTo();
        String from = "twilio mobile number";
        String message = smsRequest.getMessage();
        Message.creator(new PhoneNumber(to), new PhoneNumber(from), message).create();
    }
}


