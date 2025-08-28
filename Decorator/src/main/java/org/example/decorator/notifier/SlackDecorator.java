package org.example.decorator.notifier;

import org.example.decorator.util.TextUtils;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;


    public SlackDecorator(Notifier wrappee, String channel) {
        super(wrappee);
        this.channel = TextUtils.sanitize(channel);
    }


    @Override
    public String send(String message) {
        String msg = TextUtils.sanitize(message);
        String head = String.format("[Slack] Canal: %s | Mensagem: %s", channel, msg);
        return head + System.lineSeparator() + super.send(message);
    }
}