package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.commands.Debug;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {

    @EventHandler
    public void on(PlayerMoveEvent e) {
        if(!Debug.debugmoede) {
            Player p = e.getPlayer();
            if (p.getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
                p.setHealth(0);
            }
        }
    }
}
