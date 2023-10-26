package com.sms.integration.sms.integration.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.integration.sms.integration.SmsPayload.SmsRequest;
import com.sms.integration.sms.integration.SmsPayload.SmsResponse;
import com.sms.integration.sms.integration.service.SmsService;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public SmsResponse sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
        return new SmsResponse("Sent", "Message sent successfully.");
    }
}


