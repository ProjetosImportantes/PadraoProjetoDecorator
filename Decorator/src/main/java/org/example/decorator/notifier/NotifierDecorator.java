package org.example.decorator.notifier;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;


    protected NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }


    @Override
    public String send(String message) {
// Por padrão, apenas delega. Concretos adicionam comportamento antes/depois.
        return wrappee.send(message);
    }
}