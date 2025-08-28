package org.example.decorator.notifier;
import org.example.decorator.util.TextUtils;
public class EmailDecorator extends NotifierDecorator {
    private final String to;


    public EmailDecorator(Notifier wrappee, String to) {
        super(wrappee);
        this.to = TextUtils.sanitize(to);
    }


    @Override
    public String send(String message) {
        String msg = TextUtils.sanitize(message);
        String head = String.format("[Email] Para: %s | Mensagem: %s", to, msg);
        return head + System.lineSeparator() + super.send(message);
    }
}