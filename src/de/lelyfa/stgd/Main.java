package de.lelyfa.stgd;

import de.lelyfa.stgd.commands.Debug;
import de.lelyfa.stgd.commands.Setspawn;
import de.lelyfa.stgd.listener.*;
import de.lelyfa.stgd.utils.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        initial();
        loadListener();
        loadCommands();
        System.out.println("Plugin erfolgreich gestartet");

    }

    private void initial() {
        Spawn.initialConfig();
        Bukkit.getServer().setDefaultGameMode(GameMode.SURVIVAL);
    }

    private void loadCommands() {
        getCommand("setspawn").setExecutor(new Setspawn());
        getCommand("debug").setExecutor(new Debug());
    }

    private void loadListener() {
        PluginManager pm = Bukkit.getPluginManager();

        Death cDeath = new Death(this);

        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Quit(), this);
        pm.registerEvents(new Damage(), this);
        pm.registerEvents(cDeath, this);
        pm.registerEvents(new Move(), this);
        pm.registerEvents(new Others(), this);
    }
}
