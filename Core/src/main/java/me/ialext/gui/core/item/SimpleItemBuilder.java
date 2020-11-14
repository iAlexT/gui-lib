package me.ialext.gui.core.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class SimpleItemBuilder implements ItemBuilder {

    private String name;
    private List<String> lore;
    private byte data;
    private int amount;

    private final Material type;
    private final Map<Enchantment, Integer> enchantments = new HashMap<>();
    private final List<ItemFlag> flags = new ArrayList<>();

    SimpleItemBuilder(Material type, int amount, byte data) {
        this.type = type;
    }

    public SimpleItemBuilder(Material type) {
        this(type, 1, (byte) 0);
    }

    SimpleItemBuilder(Material type, int amount) {
        this(type, amount, (byte) 0);
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
        meta.setDisplayName(name);
        meta.setLore(lore);
        enchantments.forEach((enchant, level) -> meta.addEnchant(enchant, level, true));
        flags.forEach(meta::addItemFlags);

        item.setItemMeta(meta);

        return item;
    }
}
