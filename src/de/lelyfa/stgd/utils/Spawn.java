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

    private static String eins = "eins";

    public static void setSpawn(Location spawn, String string) {

        double x = spawn.getBlockX();
        double y = spawn.getBlockY();
        double z = spawn.getBlockZ();
        float yaw = spawn.getYaw();
        float pitch = spawn.getPitch();
        String world = spawn.getWorld().getName();

        cfg.set(string + "Spawnlocation.x", x);
        cfg.set(string + "Spawnlocation.y", y);
        cfg.set(string + "Spawnlocation.z", z);
        cfg.set(string + "Spawnlocation.pitch", pitch);
        cfg.set(string + "Spawnlocation.yaw", yaw);
        cfg.set(string + "Spawnlocation.world", world);

        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void teleportPlayertoSpawn(Player p) {

        p.teleport(new Location(
                Bukkit.getWorld(cfg.getString(eins + "Spawnlocation.world")),
                cfg.getDouble(eins + "Spawnlocation.x"),
                cfg.getDouble(eins + "Spawnlocation.y"),
                cfg.getDouble(eins + "Spawnlocation.z"),
                (float) cfg.getDouble(eins + "Spawnlocation.yaw"),
                (float) cfg.getDouble(eins + "Spawnlocation.pitch")));

    }

    public static void initialConfig() {

        cfg.options().copyDefaults(true);
        cfg.addDefault(eins + "Spawnlocation.x", -53);
        cfg.addDefault(eins + "Spawnlocation.y", 19);
        cfg.addDefault(eins + "Spawnlocation.z", 124);
        cfg.addDefault(eins + "Spawnlocation.world", "world");

        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void teleportPlayertoLevel(Player p, String level) {
        p.teleport(new Location(
                Bukkit.getWorld(cfg.getString(level + "Spawnlocation.world")),
                cfg.getDouble(level + "Spawnlocation.x"),
                cfg.getDouble(level + "Spawnlocation.y"),
                cfg.getDouble(level + "Spawnlocation.z"),
                (float) cfg.getDouble(level + "Spawnlocation.yaw"),
                (float) cfg.getDouble(level + "Spawnlocation.pitch")));
    }
}