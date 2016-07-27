package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damage implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();
            Player q = (Player) e.getDamager();
            Game.lastdamager.put(p, q);
            p.setHealth(20);
        }
    }
}
