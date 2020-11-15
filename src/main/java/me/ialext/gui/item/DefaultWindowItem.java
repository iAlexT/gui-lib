package me.ialext.gui.item;

import me.ialext.gui.item.action.Button;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class DefaultWindowItem implements WindowItem {

    private final int slot;
    private final Button button;
    private final ItemStack item;

    DefaultWindowItem(int slot, ItemStack item, Button button) {
        this.slot = slot;
        this.item = item;
        this.button = button;
    }
    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public Optional<Button> getButton() {
        return Optional.ofNullable(button);
    }

    @Override
    public ItemStack getItem() {
        return item;
    }
}
