package de.lelyfa.stgd.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Debug implements CommandExecutor {

    public static boolean debugmoede = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.isOp()) {

            if (debugmoede) {
                debugmoede = false;
                commandSender.sendMessage(ChatColor.AQUA + "Der Debugmodus ist nun ausgeschalten!");
            } else {
                debugmoede = true;
                commandSender.sendMessage(ChatColor.AQUA + "Der Debugmodus ist nun angeschalten!");
            }
        }
        return false;
    }

}
