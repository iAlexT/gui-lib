package me.ialext.gui.window.action;

@FunctionalInterface
public interface WindowConsumer<T> {

    boolean apply(T t);

}
