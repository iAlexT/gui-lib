package me.ialext.gui.guilib.item.builder;

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

    default ItemBuilder newBuilder(Material type, int amount, byte data) {
        return new DefaultItemBuilder(type, amount, data);
    }

    default ItemBuilder newBuilder(Material type, int amount) {
        return new DefaultItemBuilder(type, amount);
    }

    default ItemBuilder newBuilder(Material type) {
        return new DefaultItemBuilder(type);
    }
}
