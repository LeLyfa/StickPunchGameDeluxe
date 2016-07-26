package de.lelyfa.stgd.utils;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;
import org.bukkit.material.Wool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class ItemBuilder {

    public static ItemStack addNameToItemStack(ItemStack st, String name) {

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack addNbtTag(ItemStack input, String key, Object value) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        NBTTagCompound tag = craftItem.hasTag() ? craftItem.getTag() : new NBTTagCompound();

        if ((value instanceof Double)) {

            tag.setDouble(key, (Double) value);

        }

        if ((value instanceof String)) {

            tag.setString(key, (String) value);

        }

        if ((value instanceof Integer)) {

            tag.setInt(key, (Integer) value);

        }

        if ((value instanceof Float)) {

            tag.setFloat(key, (Float) value);

        }

        if ((value instanceof Byte)) {

            tag.setByte(key, (Byte) value);

        }

        if ((value instanceof Boolean)) {

            tag.setBoolean(key, (Boolean) value);

        }

        if ((value instanceof Long)) {

            tag.setLong(key, (Long) value);

        }

        if ((value instanceof Short)) {

            tag.setShort(key, (Short) value);

        }

        craftItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(craftItem);

    }


    public static ItemStack createClay(DyeColor c) {

        return new ItemStack(Material.STAINED_CLAY, 1, c.getData());

    }


    public static ItemStack createClay(DyeColor c, int amount) {

        return new ItemStack(Material.STAINED_CLAY, amount, c.getData());

    }


    public static ItemStack createClay(DyeColor c, String name) {

        ItemStack st = new ItemStack(Material.STAINED_CLAY, 1, c.getData());

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createClay(DyeColor c, String name, int amount) {

        ItemStack st = new ItemStack(Material.STAINED_CLAY, amount, c.getData());

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createDye(DyeColor d) {

        Dye dye = new Dye();

        dye.setColor(d);

        return dye.toItemStack(1);

    }


    public static ItemStack createDye(DyeColor d, int amount) {

        Dye dye = new Dye();

        dye.setColor(d);

        return dye.toItemStack(amount);

    }


    public static ItemStack createDye(DyeColor d, String name) {

        Dye dye = new Dye();

        dye.setColor(d);

        ItemStack st = dye.toItemStack(1);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createDye(DyeColor d, String name, int amount) {

        Dye dye = new Dye();

        dye.setColor(d);

        ItemStack st = dye.toItemStack(amount);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name) {

        ItemStack st = new ItemStack(mat);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name, byte data) {

        ItemStack st = new ItemStack(mat, 1, data);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name, byte data, List<String> lore) {

        ItemStack st = new ItemStack(mat, 1, data);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        m.setLore(lore);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material isss, String name, HashMap<Enchantment, Integer> enchantments) {

        ItemStack st = new ItemStack(isss);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        for (Map.Entry<Enchantment, Integer> k : enchantments.entrySet()) {

            m.addEnchant(k.getKey(), k.getValue(), true);

        }

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name, HashMap<Enchantment, Integer> enchantments,
                                            List<String> lore) {

        ItemStack st = new ItemStack(mat);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        m.setLore(lore);

        for (Map.Entry<Enchantment, Integer> k : enchantments.entrySet()) {

            m.addEnchant(k.getKey(), k.getValue(), true);

        }

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name, int amount) {

        ItemStack st = new ItemStack(mat, amount);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createItemStack(Material mat, String name, List<String> lore) {

        ItemStack st = new ItemStack(mat);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        m.setLore(lore);

        st.setItemMeta(m);

        return st;

    }

    public static ItemStack createItemStack(short data) {

        ItemStack st = new ItemStack(Material.STAINED_GLASS_PANE, 1, data);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(" ");

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createLeatherBoots(Color c, String name) {

        ItemStack st = new ItemStack(Material.LEATHER_BOOTS);

        LeatherArmorMeta m = (LeatherArmorMeta) st.getItemMeta();

        m.setColor(c);

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static ItemStack createWool(DyeColor c, int amount) {

        Wool w = new Wool();

        w.setColor(c);

        return w.toItemStack(amount);

    }


    public static ItemStack createWool(DyeColor c, int amount, String name) {

        Wool w = new Wool();

        w.setColor(c);

        ItemStack st = w.toItemStack(amount);

        ItemMeta m = st.getItemMeta();

        m.setDisplayName(name);

        st.setItemMeta(m);

        return st;

    }


    public static Object getNbtTag(ItemStack input, String key) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        if (craftItem.hasTag()) {

            NBTTagCompound tag = craftItem.getTag();

            return tag.get(key);

        }

        return null;

    }


    public static HashMap<String, Object> getNbtTags(ItemStack input) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        if (craftItem.hasTag()) {

            HashMap<String, Object> tags = new HashMap();

            for (String key : craftItem.getTag().c()) {

                tags.put(key, craftItem.getTag().get(key));

            }

            return tags;

        }

        return null;

    }


    public static boolean hasNbtTag(ItemStack input, String key) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        if (craftItem.hasTag()) {

            NBTTagCompound tag = craftItem.getTag();

            return tag.hasKey(key);

        }

        return false;

    }


    public static boolean hasNbtTag(ItemStack input, String key, Object value) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        if (craftItem.hasTag()) {

            NBTTagCompound tag = craftItem.getTag();

            return (tag.hasKey(key)) && (tag.get(key).equals(value));

        }

        return false;

    }


    public static ItemStack removeNbtTag(ItemStack input, String key) {

        net.minecraft.server.v1_8_R3.ItemStack craftItem = CraftItemStack.asNMSCopy(input);

        NBTTagCompound tag = craftItem.hasTag() ? craftItem.getTag() : new NBTTagCompound();

        tag.remove(key);

        craftItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(craftItem);

    }

}

