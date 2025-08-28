package org.example.decorator.notifier;

import org.example.decorator.util.TextUtils;

public class SMSDecorator extends NotifierDecorator {
    private final String phone;


    public SMSDecorator(Notifier wrappee, String phone) {
        super(wrappee);
        this.phone = TextUtils.sanitize(phone);
    }


    @Override
    public String send(String message) {
        String msg = TextUtils.sanitize(message);
        String head = String.format("[SMS] Para: %s | Mensagem: %s", phone, msg);
        return head + System.lineSeparator() + super.send(message);
    }
}