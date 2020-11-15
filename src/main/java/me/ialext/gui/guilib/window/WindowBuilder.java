package me.ialext.gui.guilib.window;

import me.ialext.gui.guilib.window.action.WindowConsumer;
import me.ialext.gui.guilib.item.WindowItem;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public interface WindowBuilder {

    WindowBuilder addItem(WindowItem item);

    WindowBuilder openEvent(WindowConsumer<InventoryOpenEvent> openEventWindowConsumer);

    WindowBuilder closeEvent(WindowConsumer<InventoryCloseEvent> closeEventWindowConsumer);

    WindowItem getItem(int slot);

    void runOpen(InventoryOpenEvent openEvent);

    void runClose(InventoryCloseEvent closeEvent);

    Inventory build();

}
