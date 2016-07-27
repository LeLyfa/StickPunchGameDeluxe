package de.lelyfa.stgd.commands;

import de.lelyfa.stgd.utils.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setspawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player && commandSender.isOp()) {

            Player p = (Player) commandSender;
            Spawn.setSpawn(p.getLocation());
            p.sendMessage(ChatColor.GOLD + "Spawn wurde gesetzt!");
        }
        return false;
    }
}
