package me.ialext.gui.core.item;

import me.ialext.gui.core.Button;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface WindowItem {

    int getSlot();

    Optional<Button> clickEvent();

    ItemStack getItem();

}
