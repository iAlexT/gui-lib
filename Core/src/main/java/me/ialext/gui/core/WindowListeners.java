package me.ialext.gui.core;

import me.ialext.gui.core.item.WindowItem;
import me.ialext.gui.core.window.SimpleWindow;
import me.ialext.gui.core.window.Window;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Optional;

public class WindowListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Optional<Window> optionalWindow = SimpleWindow.getWindow(event.getInventory().getTitle());

        optionalWindow.ifPresent(window -> {
            if(!window.getItem(event.getSlot()).clickEvent().isPresent()) return;
            window.getItem(event.getSlot()).clickEvent();
            event.setCancelled(window.getItem(event.getSlot()).clickEvent().get().accept(event));
        });

    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Optional<Window> optionalWindow = SimpleWindow.getWindow(event.getInventory().getTitle());

        optionalWindow.ifPresent(window -> {
            window.executeOpen(event);
            if(optionalWindow.get().cancelsOpen()) {
                event.setCancelled(true);
            }
        });
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Optional<Window> optionalWindow = SimpleWindow.getWindow(event.getInventory().getTitle());

        optionalWindow.ifPresent(window -> window.executeClose(event));
    }
}
