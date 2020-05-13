package me.kyrxstudios.chatreverser;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatReversifier implements Listener {
    private final ChatReverser plugin = JavaPlugin.getPlugin(ChatReverser.class);

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (plugin.getReversed().contains(e.getPlayer().getUniqueId())) {
            String ms = "";
            String msg = e.getMessage().replace("§", "&");
            if (msg.contains("&")) {
                for (int i = msg.split("&").length - 1; i >= 1; i--) {
                    String x = "";
                    String s = msg.split("&")[i].substring(1);
                    String s1 = msg.split("&")[i];
                    for (int f = s.length() - 1; f >= 0; f--) {
                        x += s.charAt(f);
                    }
                    ms += "&" + s1.charAt(0) + x;
                }
            } else {
                for (int f = msg.length() - 1; f >= 0; f--) {
                    ms += msg.charAt(f);
                }
            }
            e.setMessage(ChatColor.translateAlternateColorCodes('&', ms));
        }
        return;
    }
}