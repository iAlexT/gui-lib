package me.ialext.gui.guilib.item.builder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultItemBuilder implements ItemBuilder {

    private String name;
    private List<String> lore;
    private final byte data;
    private final int amount;

    private final Material type;
    private final Map<Enchantment, Integer> enchantments = new HashMap<>();
    private final List<ItemFlag> flags = new ArrayList<>();

    DefaultItemBuilder(Material type, int amount, byte data) {
        this.type = type;
        this.amount = amount;
        this.data = data;
    }

    DefaultItemBuilder(Material type, int amount) {
        this(type, amount, (byte) 0);
    }

    DefaultItemBuilder(Material type) {
        this(type, 1, (byte) 0);
    }

    @Override
    public Material getType() {
        return type;
    }

    @Override
    public ItemBuilder name(String name) {
        this.name = name;

        return this;
    }

    @Override
    public ItemBuilder lore(List<String> lore) {
        this.lore = lore;

        return this;
    }

    @Override
    public ItemBuilder addEnchantment(Enchantment enchantment, Integer level) {
        enchantments.put(enchantment, level);

        return this;
    }

    @Override
    public ItemBuilder addFlag(ItemFlag flag) {
        flags.add(flag);

        return this;
    }

    @Override
    public ItemStack build() {
        ItemStack item = new ItemStack(type, amount, data);
        ItemMeta meta = item.getItemMeta();
        enchantments.forEach((enchant, level) -> meta.addEnchant(enchant, level, true));
        meta.setDisplayName(name);
        meta.setLore(lore);
        flags.forEach(meta::addItemFlags);
        item.setItemMeta(meta);

        return item;
    }
}
