package me.ialext.gui.test.module;

import me.ialext.gui.test.menu.BuildableMenu;
import me.ialext.gui.test.menu.TestMenu;
import me.yushust.inject.Binder;
import me.yushust.inject.Module;

public class WindowsModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(BuildableMenu.class).named("test-menu").to(TestMenu.class).singleton();
    }
}
