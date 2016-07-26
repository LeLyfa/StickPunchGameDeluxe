package de.lelyfa.stgd.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Spawn {

    private static final File config = new File("plugins/StickPunchGameDeluxe", "spawn.yml");
    private static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config);

    public static void setSpawn(Location spawn) {

        double x = spawn.getBlockX();
        double y = spawn.getBlockY();
        double z = spawn.getBlockZ();
        float yaw = spawn.getYaw();
        float pitch = spawn.getPitch();
        String world = spawn.getWorld().getName();

        cfg.set("Spawnlocation.x", x);
        cfg.set("Spawnlocation.y", y);
        cfg.set("Spawnlocation.z", z);
        cfg.set("Spawnlocation.pitch", pitch);
        cfg.set("Spawnlocation.yaw", yaw);
        cfg.set("Spawnlocation.world", world);

        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void teleportPlayertoSpawn(Player p) {

        p.teleport(new Location(
                Bukkit.getWorld(cfg.getString("Spawnlocation.world")),
                cfg.getDouble("Spawnlocation.x"),
                cfg.getDouble("Spawnlocation.y"),
                cfg.getDouble("Spawnlocation.z"),
                (float) cfg.getDouble("Spawnlocation.yaw"),
                (float) cfg.getDouble("Spawnlocation.pitch")));

    }

    public static void initialConfig() {

        cfg.options().copyDefaults(true);
        cfg.addDefault("Spawnlocation.x", 0);
        cfg.addDefault("Spawnlocation.y", 60);
        cfg.addDefault("Spawnlocation.z", 0);
        cfg.addDefault("Spawnlocation.world", "world");

        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}