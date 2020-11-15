package me.ialext.gui;

import me.ialext.gui.item.action.Button;
import me.ialext.gui.window.DefaultWindowBuilder;
import me.ialext.gui.window.WindowBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Optional;

public class WindowListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Optional<WindowBuilder> optionalWindowBuilder = DefaultWindowBuilder.getWindow(event.getInventory().getTitle());

        optionalWindowBuilder.ifPresent(window -> {
            if(event.getSlot() < 0) {
                return;
            }

            if(event.getCurrentItem() == null) {
                return;
            }

            Optional<Button> optionalButton = window.getItem(event.getSlot()).getButton();
            if(!optionalButton.isPresent()) {
                return;
            }
            optionalButton.get().click(event);
            event.setCancelled(optionalButton.get().click(event));
        });
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Optional<WindowBuilder> optionalWindowBuilder = DefaultWindowBuilder.getWindow(event.getInventory().getTitle());

        optionalWindowBuilder.ifPresent(window -> {
            if(window.getOpenEventConsumer() != null) {
                window.runOpen(event);
            }

            event.setCancelled(window.isCancelClick());
        });
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Optional<WindowBuilder> optionalWindowBuilder = DefaultWindowBuilder.getWindow(event.getInventory().getTitle());

        optionalWindowBuilder.ifPresent(window -> {
            if(window.getCloseEventConsumer() != null) {
                window.runClose(event);
            }
        });
    }
}
