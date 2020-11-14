package me.ialext.gui.test.module;

import me.ialext.gui.test.Test;
import me.yushust.inject.Binder;
import me.yushust.inject.Module;
import org.bukkit.plugin.Plugin;

public class MainModule implements Module {

    private final Test plugin;

    public MainModule(Test plugin) {
        this.plugin = plugin;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(Plugin.class).to(Test.class);
        binder.bind(Test.class).toInstance(plugin);

        binder.install(new WindowsModule());
    }
}
