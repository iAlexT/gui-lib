package me.ialext.gui.core.item;

import me.ialext.gui.core.Button;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class SimpleWindowItem implements WindowItem {

    private final int slot;
    private final ItemStack item;
    private final Button button;

    public SimpleWindowItem(int slot, ItemStack item, Button button) {
        this.slot = slot;
        this.item = item;
        this.button = button;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public Optional<Button> clickEvent() {
        return Optional.ofNullable(button);
    }

    @Override
    public ItemStack getItem() {
        return item;
    }


}
