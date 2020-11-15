package me.ialext.gui.item;

import me.ialext.gui.item.action.Button;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface WindowItem {

    int getSlot();

    Optional<Button> getButton();

    ItemStack getItem();

    static WindowItem newBuilder(int slot, ItemStack item, Button button) {
        return new DefaultWindowItem(slot, item, button);
    }
}
