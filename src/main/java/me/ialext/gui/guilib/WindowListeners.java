package me.ialext.gui.guilib;

import me.ialext.gui.guilib.item.WindowItem;
import me.ialext.gui.guilib.item.action.Button;
import me.ialext.gui.guilib.window.DefaultWindowBuilder;
import me.ialext.gui.guilib.window.WindowBuilder;
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

        optionalWindowBuilder.ifPresent(window -> window.runOpen(event));
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Optional<WindowBuilder> optionalWindowBuilder = DefaultWindowBuilder.getWindow(event.getInventory().getTitle());

        optionalWindowBuilder.ifPresent(window -> window.runClose(event));
    }
}
