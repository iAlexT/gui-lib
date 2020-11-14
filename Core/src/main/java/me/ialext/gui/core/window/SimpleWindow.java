package me.ialext.gui.core.window;

import me.ialext.gui.core.WindowConsumer;
import me.ialext.gui.core.item.WindowItem;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class SimpleWindow implements Window {

    private final String title;
    private final int rows;
    private boolean cancel;

    private final WindowItem[] items;
    private static final Map<String, Window> windows = new HashMap<>();

    private WindowConsumer<InventoryOpenEvent> openEvent;
    private WindowConsumer<InventoryCloseEvent> closeEvent;

    public SimpleWindow(String title, int rows, boolean cancel) {
        this.title = title;
        this.rows = rows;
        this.cancel = cancel;
        items = new WindowItem[rows * 9];

        windows.put(title, this);
    }

    @Override
    public Window addItem(WindowItem item) {
        items[item.getSlot()] = item;

        return this;
    }

    @Override
    public Window openEvent(WindowConsumer<InventoryOpenEvent> openEvent) {
        this.openEvent = openEvent;

        return this;
    }

    @Override
    public Window closeEvent(WindowConsumer<InventoryCloseEvent> closeEvent) {
        this.closeEvent = closeEvent;

        return this;
    }

    @Override
    public Window cancelOpen(boolean cancel) {
        this.cancel = cancel;

        return this;
    }

    @Override
    public WindowItem getItem(int slot) {
        return items[slot];
    }

    @Override
    public boolean cancelsOpen() {
        return cancel;
    }

    @Override
    public void executeOpen(InventoryOpenEvent event) {
        openEvent.accept(event);
    }

    @Override
    public void executeClose(InventoryCloseEvent event) {
        closeEvent.accept(event);
    }

    @Override
    public Inventory build() {
        Inventory inventory = Bukkit.createInventory(null, rows * 9, title);
        for(WindowItem windowItem : items) {
            if(windowItem != null) {
                inventory.setItem(windowItem.getSlot(), windowItem.getItem());
            }
        }
        return inventory;
    }

    public static Optional<Window> getWindow(String title) {
        return Optional.ofNullable(windows.get(title));
    }
}
