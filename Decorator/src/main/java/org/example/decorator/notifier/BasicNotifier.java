package org.example.decorator.notifier;
import org.example.decorator.util.TextUtils;

public class BasicNotifier implements Notifier {
    private final String recipientName;


    public BasicNotifier(String recipientName) {
        this.recipientName = TextUtils.sanitize(recipientName);
    }


    @Override
    public String send(String message) {
        String msg = TextUtils.sanitize(message);
        return String.format("[Base] Entregue a destinatário \"%s\" a mensagem: %s", recipientName, msg);
    }
}