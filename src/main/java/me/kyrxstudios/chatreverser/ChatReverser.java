package me.kyrxstudios.chatreverser;

import me.kyrxstudios.chatreverser.commands.ReverseCMD;
import me.kyrxstudios.chatreverser.events.ChatListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class ChatReverser extends JavaPlugin {

    /*
    Organization is a big thing, as a developer, and you must learn to effectively organize your code for ease of access,
    especially, if you plan on sharing it on a platform such as GitHub, or GitLab, for other developers to use in their
    projects. I added more packages to make things more identifiable.

    You also make some very basic mistakes, which I will correct in my rendition of this plugin, and there are some
    small ways you could improve your code, as well.

    I will not explain everything, as you seem pretty well versed with at least standard Java principles, so you should
    be able to understand everything, but let me know if that is not correct, and I will elaborate.
     */

    // Use UUIDs instead of just players, this is a good common practice.
    private ArrayList<UUID> reversed;

    @Override
    public void onEnable() {
        reversed = new ArrayList<>();

        getCommand("reverse").setExecutor(new ReverseCMD());

        // You never actually referenced the event in your originial code, so I don't know how it would work, but you might have somehow managed it.
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    // This is a very simple colorization method, which will translate color codes through the symbol '&'
    public String colorize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public ArrayList<UUID> getReversed() {
        return reversed;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
