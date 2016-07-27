package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.game.Game;
import de.lelyfa.stgd.utils.Spawn;
import de.lelyfa.stgd.utils.Tablistheader;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Tablistheader.send(ChatColor.AQUA + "Stick" + ChatColor.DARK_AQUA + "Punch" + ChatColor.DARK_PURPLE + "Game"
                + ChatColor.RED + "Deluxe", ChatColor.GREEN + "... made by LeLyfa", p);
        Game.newPlayer(p);
        e.setJoinMessage(ChatColor.GRAY + p.getName() + ChatColor.DARK_GRAY + " ist dem Spiel beigetreten!");
        Spawn.teleportPlayertoSpawn(p);
    }
}
