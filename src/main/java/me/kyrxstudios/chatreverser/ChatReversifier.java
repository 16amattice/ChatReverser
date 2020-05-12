package me.kyrxstudios.chatreverser;
import jdk.incubator.jpackage.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatReversifier implements Listener {
    private Player p;
    public ChatReversifier(Player player) {

        this.p = player;

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!e.getPlayer().equals(this.p))
            return;
        StringBuilder sb = new StringBuilder();
        for(int i = e.getMessage().length()-1; i >= 0; i--)sb.append(e.getMessage().charAt(i));
        e.setMessage(sb.toString());

    }
}
