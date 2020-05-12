package me.kyrxstudios.chatreverser.events;

import me.kyrxstudios.chatreverser.ChatReverser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatListener implements Listener {

    private final ChatReverser plugin = JavaPlugin.getPlugin(ChatReverser.class);

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (plugin.getReversed().contains(e.getPlayer().getUniqueId())) {
            // Execute reverse message logic, then set the message. Your logic for the reversal could be done a bit better, specifically in the loop, but it works, so
            // I thought I might as well keep it.
            StringBuilder sb = new StringBuilder();
            for(int i = e.getMessage().length()-1; i >= 0; i--) {
                sb.append(e.getMessage().charAt(i));
            }
            e.setMessage(sb.toString());
        }
    }
}
