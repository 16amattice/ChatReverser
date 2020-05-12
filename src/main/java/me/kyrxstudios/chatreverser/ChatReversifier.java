package me.kyrxstudios.chatreverser;
import jdk.incubator.jpackage.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatReversifier implements Listener {
    private final ChatReverser plugin = JavaPlugin.getPlugin(ChatReverser.class);
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (plugin.getReversed().contains(e.getPlayer().getUniqueId())) {
            StringBuilder sb = new StringBuilder();
            for(int i = e.getMessage().length()-1; i >= 0; i--) {
                sb.append(e.getMessage().charAt(i));
            }
            e.setMessage(sb.toString());
        }
    }
}
