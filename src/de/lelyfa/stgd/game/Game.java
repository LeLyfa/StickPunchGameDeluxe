package de.lelyfa.stgd.game;

import de.lelyfa.stgd.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Game {

    public static final HashMap<Player, Player> lastdamager = new HashMap<>();
    private static final HashMap<Player, Integer> playerlevel = new HashMap<>();

    public static void rankup(Player p) {

        int i = playerlevel.get(p);
        i++;
        playerlevel.put(p, i++);
        Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.DARK_GRAY + " ist nun ein Level höher");
        givePlayerNewStick(p);
    }

    public static void rankdown(Player p) {

        if (playerlevel.get(p) != 0) {
            //int i = playerlevel.get(p);
            playerlevel.put(p, 0);
            Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.DARK_GRAY + " ist nun ein Level zero");
            givePlayerNewStick(p);

        }
    }

    public static void newPlayer(Player p) {
        playerlevel.put(p, 0);
        p.getInventory().clear();
        givePlayerNewStick(p);
    }

    public static void givePlayerNewStick(Player p) {
        int lvl = playerlevel.get(p);
        lvl++;

        HashMap<Enchantment, Integer> level = new HashMap<>();

        int i = playerlevel.get(p);
        if (i >= 0 && i < 10) {
            p.getInventory().setItem(4, ItemBuilder.createItemStack(Material.STICK, ChatColor.RED + "Level " + lvl++));
        } else if (i >= 10 && i < 25) {
            level.put(Enchantment.KNOCKBACK, 1);
            p.getInventory().setItem(4, ItemBuilder.createItemStack(Material.STICK, ChatColor.RED + "Level " + lvl++));
        } else if (i >= 25 && i < 50) {
            level.put(Enchantment.KNOCKBACK, 2);
            p.getInventory().setItem(4, ItemBuilder.createItemStack(Material.STICK, ChatColor.RED + "Level " + lvl++));
        } else {
            level.put(Enchantment.KNOCKBACK, 3);
            p.getInventory().setItem(4, ItemBuilder.createItemStack(Material.STICK, ChatColor.RED + "Level " + lvl++));
        }
    }

}
