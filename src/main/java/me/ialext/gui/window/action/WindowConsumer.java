package me.ialext.gui.window.action;

@FunctionalInterface
public interface WindowConsumer<T> {

    void apply(T t);

}
