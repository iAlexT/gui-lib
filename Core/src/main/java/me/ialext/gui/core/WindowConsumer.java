package me.ialext.gui.core;

@FunctionalInterface
public interface WindowConsumer<T> {

    boolean accept(T t);

}
