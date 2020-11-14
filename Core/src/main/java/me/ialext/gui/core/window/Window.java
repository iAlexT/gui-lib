package me.ialext.gui.core.window;

import me.ialext.gui.core.WindowConsumer;
import me.ialext.gui.core.item.WindowItem;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.Optional;

public interface Window {

    Window addItem(WindowItem item);

    Window openEvent(WindowConsumer<InventoryOpenEvent> inventoryOpenEventConsumer);

    Window closeEvent(WindowConsumer<InventoryCloseEvent> inventoryCloseEventConsumer);

    Window cancelOpen(boolean cancel);

    WindowItem getItem(int slot);

    boolean cancelsOpen();

    void executeOpen(InventoryOpenEvent event);

    void executeClose(InventoryCloseEvent event);

    Inventory build();

    static Window newWindow(String title, int rows, boolean cancelOpen) {
        return new SimpleWindow(title, rows, cancelOpen);
    }
}
