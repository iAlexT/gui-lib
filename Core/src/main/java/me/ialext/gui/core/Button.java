package me.ialext.gui.core;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface Button {

    boolean accept(InventoryClickEvent event);
}
