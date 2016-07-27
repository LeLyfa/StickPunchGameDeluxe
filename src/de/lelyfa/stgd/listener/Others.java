package de.lelyfa.stgd.listener;

import de.lelyfa.stgd.commands.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Others implements Listener {


    @EventHandler
    public void on(PlayerDropItemEvent e) {
        if (!Debug.debugmoede) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerPickupItemEvent e) {
        if (!Debug.debugmoede) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void on(BlockBreakEvent e) {
        if (!Debug.debugmoede) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(WeatherChangeEvent e) { e.setCancelled(true); }

}
