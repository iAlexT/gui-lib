package me.ialext.gui.guilib.item;

import me.ialext.gui.guilib.item.action.Button;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface WindowItem {

    int getSlot();

    Optional<Button> getButton();

    ItemStack getItem();

    default WindowItem newBuilder(int slot, ItemStack item, Button button) {
        return new DefaultWindowItem(slot, item, button);
    }
}
