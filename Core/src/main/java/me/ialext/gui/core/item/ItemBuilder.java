package me.ialext.gui.core.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ItemBuilder {

    Material getType();

    ItemBuilder name(String name);

    ItemBuilder lore(List<String> lore);

    ItemBuilder addEnchantment(Enchantment enchantment, Integer level);

    ItemBuilder addFlag(ItemFlag flag);

    ItemStack build();

    static ItemBuilder newBuilder(Material item) {
        return new SimpleItemBuilder(item);
    }

    static ItemBuilder newBuilder(Material item, int amount, byte data) {
        return new SimpleItemBuilder(item, amount, (byte) data);
    }

}
