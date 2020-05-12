package me.kyrxstudios.chatreverser.commands;

import me.kyrxstudios.chatreverser.ChatReverser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ReverseCMD implements CommandExecutor {

    private final ChatReverser plugin = JavaPlugin.getPlugin(ChatReverser.class);

    // I managed to simplify this class to an extreme. You should always be thinking about the most simple way to get what you want done.
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.colorize("&cYou must be a player to use this command!"));
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("reverse.toggle.self")) {
            // Very simple toggle logic to remove extra unnecessary sub-strings
            if (plugin.getReversed().contains(player.getUniqueId())) {
                plugin.getReversed().remove(player.getUniqueId());
                player.sendMessage(plugin.colorize("&cMessage reversal has been toggled off!"));
            } else {
                plugin.getReversed().add(player.getUniqueId());
                player.sendMessage(plugin.colorize("&aMessage reversal has been toggled on!"));
            }
        }

        // Always return true.
        return true;
    }
}
