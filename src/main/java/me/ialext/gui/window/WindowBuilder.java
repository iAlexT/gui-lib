package me.ialext.gui.window;

import me.ialext.gui.window.action.WindowConsumer;
import me.ialext.gui.item.WindowItem;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public interface WindowBuilder {

    WindowBuilder addItem(WindowItem item);

    WindowBuilder filler(WindowItem item, int from, int to);

    WindowBuilder openEvent(WindowConsumer<InventoryOpenEvent> openEventWindowConsumer);

    WindowBuilder closeEvent(WindowConsumer<InventoryCloseEvent> closeEventWindowConsumer);

    WindowBuilder cancelClick(boolean cancel);

    WindowItem getItem(int slot);

    WindowConsumer<InventoryOpenEvent> getOpenEventConsumer();

    WindowConsumer<InventoryCloseEvent> getCloseEventConsumer();

    void runOpen(InventoryOpenEvent openEvent);

    void runClose(InventoryCloseEvent closeEvent);

    boolean isCancelClick();

    Inventory build();

    static WindowBuilder newBuilder(String title, int rows) {
        return new DefaultWindowBuilder(title, rows);
    }
}
