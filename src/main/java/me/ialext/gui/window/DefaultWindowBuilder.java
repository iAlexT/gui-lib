package me.ialext.gui.window;

import me.ialext.gui.item.DefaultWindowItem;
import me.ialext.gui.window.action.WindowConsumer;
import me.ialext.gui.item.WindowItem;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultWindowBuilder implements WindowBuilder {

    private final String title;
    private final int rows;

    private final WindowItem[] items;
    private static final Map<String, WindowBuilder> windows = new HashMap<>();

    private WindowConsumer<InventoryOpenEvent> openEventWindowConsumer;
    private WindowConsumer<InventoryCloseEvent> closeEventWindowConsumer;
    private boolean cancel;

    DefaultWindowBuilder(String title, int rows) {
        this.title = title;
        this.rows = rows;

        items = new WindowItem[rows * 9];

        windows.put(title, this);
    }

    @Override
    public WindowBuilder addItem(WindowItem item) {
        items[item.getSlot()] = item;

        return this;
    }

    @Override
    public WindowBuilder filler(WindowItem item, int from, int to) {
        for(int i = from; i < to; i++) {
            if(!item.getButton().isPresent()) {
                items[i] = WindowItem.newBuilder(i, item.getItem(), null);
            } else {
                items[i] = WindowItem.newBuilder(i, item.getItem(), item.getButton().get());
            }
        }

        return this;
    }

    @Override
    public WindowBuilder openEvent(WindowConsumer<InventoryOpenEvent> openEventWindowConsumer) {
        this.openEventWindowConsumer = openEventWindowConsumer;

        return this;
    }

    @Override
    public WindowBuilder closeEvent(WindowConsumer<InventoryCloseEvent> closeEventWindowConsumer) {
        this.closeEventWindowConsumer = closeEventWindowConsumer;

        return this;
    }

    @Override
    public WindowBuilder cancelClick(boolean cancel) {
        this.cancel = cancel;

        return this;
    }

    @Override
    public WindowItem getItem(int slot) {
        return items[slot];
    }

    @Override
    public WindowConsumer<InventoryOpenEvent> getOpenEventConsumer() {
        return openEventWindowConsumer;
    }

    @Override
    public WindowConsumer<InventoryCloseEvent> getCloseEventConsumer() {
        return closeEventWindowConsumer;
    }

    @Override
    public void runOpen(InventoryOpenEvent openEvent) {
        openEventWindowConsumer.apply(openEvent);
    }

    @Override
    public void runClose(InventoryCloseEvent closeEvent) {
        closeEventWindowConsumer.apply(closeEvent);
    }

    @Override
    public boolean isCancelClick() {
        return cancel;
    }

    @Override
    public Inventory build() {
        Inventory inventory = Bukkit.createInventory(null, rows * 9, title);
        for(WindowItem windowItem : items) {
            if(windowItem != null) {
                inventory
                        .setItem(
                                windowItem.getSlot(),
                                windowItem.getItem()
                        );
            }
        }

        return inventory;
    }

    public static Optional<WindowBuilder> getWindow(String title) {
        return Optional.ofNullable(windows.get(title));
    }

}
