package me.ialext.gui.test.service;

public interface Service {

    void setup();

    default void shutdown() {

    }
}
