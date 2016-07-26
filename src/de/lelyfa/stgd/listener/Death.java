package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.Main;
import de.lelyfa.stgd.game.Game;
import de.lelyfa.stgd.utils.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    private static Main plugin;

    public Death(Main plugin) {
        Death.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerDeathEvent e) {
        Player p = e.getEntity();
        p.getInventory().clear();
        if (Game.lastdamager.get(p) != null) {
            Player q = Game.lastdamager.get(p);
            e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.DARK_GRAY + " wurde von " + ChatColor.GRAY
                    + q.getName() + ChatColor.DARK_GRAY + " getötet!");
            Game.lastdamager.remove(p);
            Game.rankup(q);
        } else {
            e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.DARK_GRAY + " ist gestorben.");
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            p.spigot().respawn();
            p.getInventory().clear();
            Game.rankdown(p);
            Game.givePlayerNewStick(p);
            Spawn.teleportPlayertoSpawn(p);
        }, 3);
    }
}
