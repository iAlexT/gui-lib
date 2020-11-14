package me.ialext.gui.test;

import me.ialext.gui.test.module.MainModule;
import me.ialext.gui.test.service.MainService;
import me.yushust.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;

public final class Test extends JavaPlugin {

    @Inject
    private MainService service;

    @Override
    public void onEnable() {
        Injector injector = Injector.create(new MainModule(this));
        injector.injectMembers(this);

        service.setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
