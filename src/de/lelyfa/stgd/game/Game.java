package de.lelyfa.stgd.game;

import de.lelyfa.stgd.utils.ItemBuilder;
import de.lelyfa.stgd.utils.Spawn;
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
        teleportPlayerToDesiredDestination(p);

    }

    public static void rankdown(Player p) {

        if (playerlevel.get(p) != 0) {
            playerlevel.put(p, playerlevel.get(p) - 1);
            Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.DARK_GRAY + " ist nun ein Level tiefer");
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
        int z = 1;
        if (i >= 3) {
            z++;
        }
        if (i >= 10) {
            z++;
        }
        if (i >= 25) {
            z++;
        }

        level.put(Enchantment.KNOCKBACK, z);
        p.getInventory().setItem(4, ItemBuilder.createItemStack(Material.STICK, ChatColor.RED + "Level " + lvl++, level));

    }

    public static void teleportPlayerToDesiredDestination(Player p) {
        if (Game.playerlevel.get(p) > 2) {
            Spawn.teleportPlayertoLevel(p, "zwei");
        } else if (Game.playerlevel.get(p) > 9) {
            Spawn.teleportPlayertoLevel(p, "drei");
        } else if (Game.playerlevel.get(p) > 24) {
            Spawn.teleportPlayertoLevel(p, "vier");
        } else {
            Spawn.teleportPlayertoSpawn(p);
        }
    }

}
