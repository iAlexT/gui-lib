package me.ialext.gui.test.service;

import me.ialext.gui.test.service.loader.CommandService;
import me.ialext.gui.test.service.loader.ListenerService;

import javax.inject.Inject;

public class MainService implements Service {

    @Inject
    private CommandService commandService;

    @Inject
    private ListenerService listenerService;

    @Override
    public void setup() {
        commandService.setup();
        listenerService.setup();
    }
}
