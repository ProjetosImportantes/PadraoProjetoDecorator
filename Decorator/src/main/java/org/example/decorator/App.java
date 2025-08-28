package org.example.decorator;

import org.example.decorator.notifier.*;

public class App {
    public static void main(String[] args) {
// Composição flexível de decorators
        Notifier notifier = new EmailDecorator(
                new SMSDecorator(
                        new SlackDecorator(
                                new BasicNotifier("Alice"),
                                "#geral"
                        ),
                        "+55 11 99999-0000"
                ),
                "alice@example.com"
        );


        String result = notifier.send("Bem-vinda!");
        System.out.println(result);
    }
}