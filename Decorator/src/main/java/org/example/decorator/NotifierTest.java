package org.example.decorator;

import org.example.decorator.notifier.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotifierTest {

    @Test
    void chainOrderShouldBeDecoratorToBase() {
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

        String res = notifier.send("Hello");
        String[] lines = res.split(System.lineSeparator());

        assertEquals(4, lines.length);
        assertTrue(lines[0].startsWith("[Email]"));
        assertTrue(lines[1].startsWith("[SMS]"));
        assertTrue(lines[2].startsWith("[Slack]"));
        assertTrue(lines[3].startsWith("[Base]"));
    }

    @Test
    void baseOnlyShouldWork() {
        Notifier base = new BasicNotifier("Bob");
        String res = base.send("Oi");
        assertTrue(res.contains("Bob"));
        assertTrue(res.contains("Oi"));
    }
}

