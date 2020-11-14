package me.ialext.gui.test.menu;

import me.ialext.gui.core.item.ItemBuilder;
import me.ialext.gui.core.item.SimpleWindowItem;
import me.ialext.gui.core.window.Window;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class TestMenu implements BuildableMenu {
    @Override
    public Window build(Player who) {
        return Window.newWindow("Vos", 3, who.hasPermission("foo"))
                .addItem(
                        new SimpleWindowItem(
                                10,
                                ItemBuilder
                                .newBuilder(Material.BEDROCK)
                                .name("vos")
                                .lore(Arrays.asList("", "vos"))
                                .build(),
                                click -> {
                                    who.sendMessage("You clicked!");

                                    return true;
                                }
                        )
                )
                .openEvent(e -> {
                    who.sendMessage("Opening!");

                    return false;
                })
                .closeEvent(e -> {
                    who.sendMessage("Closing!");

                    return false;
                });
    }
}
