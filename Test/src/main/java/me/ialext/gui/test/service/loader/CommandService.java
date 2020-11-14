package me.ialext.gui.test.service.loader;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.SimpleCommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitAuthorizer;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.ialext.gui.test.command.TestCommand;
import me.ialext.gui.test.service.Service;

import javax.inject.Inject;

public class CommandService implements Service {

    @Inject
    private TestCommand testCommand;

    @Override
    public void setup() {
        registerCommands(
                testCommand
        );
    }

    private void registerCommands(CommandClass... commandClasses) {
        PartInjector injector = PartInjector.create();
        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder builder = AnnotatedCommandTreeBuilder.create(injector);
        CommandManager manager = new BukkitCommandManager(new SimpleCommandManager(new BukkitAuthorizer()),
                "test");

        for(CommandClass commandClass : commandClasses) {
            manager.registerCommands(builder.fromClass(commandClass));
        }
    }
}
