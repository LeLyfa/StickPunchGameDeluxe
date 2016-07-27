package de.lelyfa.stgd.listener;

/*
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
*/
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
    @EventHandler
    public void on(PlayerQuitEvent e) {
        //Player p = e.getPlayer();
        e.setQuitMessage(/*ChatColor.GRAY + p.getName() + ChatColor.DARK_GRAY + " hat das Spiel verlassen!"*/ null);
    }
}
