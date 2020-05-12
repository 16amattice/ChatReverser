package me.kyrxstudios.chatreverser;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.util.HashMap;

public class ReversifierCaller implements CommandExecutor {
    HashMap<Player, ChatReversifier> chatListeners = new HashMap<>();
    ChatReverser m;
    public ReversifierCaller(ChatReverser main) {
        m = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Your regular stuff here
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("on")) {
                    if (p.hasPermission("reverse.toggle.self")) {
                        if (chatListeners.containsKey(p))
                            return true;
                        ChatReversifier cRev = new ChatReversifier(p);
                        Bukkit.getPluginManager().registerEvents(cRev, m);
                        chatListeners.put(p, cRev);
                        p.sendMessage("Reverse On");
                        return true;

                    }else{
                        p.sendMessage("You do not have permission to run this command!");
                    }
                }
                if (args[0].equalsIgnoreCase("off")) {
                    if (p.hasPermission("reverse.toggle.self")) {
                        if (!chatListeners.containsKey(p))
                            return true;
                        HandlerList.unregisterAll(chatListeners.get(p));
                        chatListeners.remove(p);
                        p.sendMessage("Reverse Off");
                        return true;
                    }else{
                        p.sendMessage("You do not have permission to run this command!");
                    }
                }
            } else {
                p.sendMessage("/r [on] [off]");
            }
        }else{
            System.out.println("You must be a player to run this command!");
        }
        return false;
    }
}
