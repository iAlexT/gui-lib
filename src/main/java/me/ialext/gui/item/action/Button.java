package me.ialext.gui.item.action;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface Button {

    boolean click(InventoryClickEvent event);

}
