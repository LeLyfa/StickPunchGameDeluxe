package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.Main;
import de.lelyfa.stgd.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    private static Main plugin;

    public Death(Main plugin) {
        Death.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerDeathEvent e) {

        Player p = e.getEntity();
        e.getDrops().clear();
        if (Game.lastdamager.get(p) != null) {
            Player q = Game.lastdamager.get(p);
            e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.DARK_GRAY + " wurde von " + ChatColor.GRAY
                    + q.getName() + ChatColor.DARK_GRAY + " getötet!");
            Game.lastdamager.remove(p);
            Game.rankup(q);
        } else {
            e.setDeathMessage(null);
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            p.spigot().respawn();
            p.getInventory().clear();
            Game.rankdown(p);
            Game.givePlayerNewStick(p);
            Game.teleportPlayerToDesiredDestination(p);


        }, 3);
    }

    @EventHandler
    public void on(EntityDeathEvent e) {
        if (e.getEntity() instanceof Player || e.getEntity() instanceof EnderDragon) {
            e.getDrops().clear();
        }
    }
}
