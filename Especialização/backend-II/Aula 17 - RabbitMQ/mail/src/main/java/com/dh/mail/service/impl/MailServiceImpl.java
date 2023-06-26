package com.dh.mail.service.impl;

import com.dh.mail.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Override
    public void sendEmail(String user) {
        System.out.println("Enviado para o usuário: "+ user);
    }
}
