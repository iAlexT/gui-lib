package me.ialext.gui.guilib.window.action;

@FunctionalInterface
public interface WindowConsumer<T> {

    void apply(T t);

}
