package me.kyrxstudios.chatreverser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ReversifierCaller implements CommandExecutor {
    private final ChatReverser plugin = JavaPlugin.getPlugin(ChatReverser.class);
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.colorize("&cYou must be a player to use this command!"));
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("reverse.toggle.self")) {
            if (plugin.getReversed().contains(player.getUniqueId())) {
                plugin.getReversed().remove(player.getUniqueId());
                player.sendMessage(plugin.colorize("&cMessage reversal has been toggled off!"));
            } else {
                plugin.getReversed().add(player.getUniqueId());
                player.sendMessage(plugin.colorize("&aMessage reversal has been toggled on!"));
            }
        }
        return true;
    }
}
