package me.ialext.gui.test.service.loader;

import me.ialext.gui.core.WindowListeners;
import me.ialext.gui.test.service.Service;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;

public class ListenerService implements Service {

    @Inject
    private Plugin plugin;

    @Inject
    private WindowListeners windowListeners;

    @Override
    public void setup() {
        registerListeners(
                windowListeners
        );
    }

    private void registerListeners(Listener... listeners) {
        for(Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
