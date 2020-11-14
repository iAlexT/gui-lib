package me.ialext.gui.test.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import me.ialext.gui.core.item.ItemBuilder;
import me.ialext.gui.core.item.SimpleWindowItem;
import me.ialext.gui.core.window.Window;
import me.ialext.gui.test.menu.BuildableMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

public class TestCommand implements CommandClass {

    @Inject
    @Named("test-menu")
    private BuildableMenu testMenu;

    @Command(names = {"test", "foo"})
    public boolean mainCommand(@Sender Player sender){
        Inventory inventory = testMenu.build(sender).build();
        sender.openInventory(inventory);

        return true;
    }

    @Command(names = "inv")
    public boolean invCommand(@Sender Player sender) {
        ItemStack vos = ItemBuilder
                .newBuilder(Material.BEDROCK)
                .name("vos")
                .lore(Arrays.asList("quien", "sos"))
                .build();

        Inventory window = Window.newWindow("Vos", 3, false)
                .addItem(
                        new SimpleWindowItem(
                                10,
                                vos,
                                click -> {
                                    sender.sendMessage("Vos o quién");

                                    return true;
                                }
                        )
                ).openEvent(e -> {
                    sender.sendMessage("Vos estás abriendo ajsdas");

                    return false;
                })
                .closeEvent(e -> {
                    sender.sendMessage("Vos estás cerrando xd");

                    return false;
                }).build();
        sender.openInventory(window);

        return true;
    }
}
