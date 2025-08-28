package org.example.decorator.notifier;

public interface Notifier {
    /**
     * Envia a mensagem e retorna um log textual do envio.
     */
    String send(String message);
}
