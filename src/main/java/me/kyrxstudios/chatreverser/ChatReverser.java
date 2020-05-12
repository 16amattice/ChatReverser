package me.kyrxstudios.chatreverser;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.UUID;

public final class ChatReverser extends JavaPlugin {
    private ArrayList<UUID> reversed;
    @Override
    public void onEnable() {
        reversed = new ArrayList<>();
        getCommand("reverse").setExecutor(new ReversifierCaller());
        getServer().getPluginManager().registerEvents(new ChatReversifier(), this);
    }
    public String colorize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    public ArrayList<UUID> getReversed() {
        return reversed;
    }


}
