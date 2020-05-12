package me.kyrxstudios.chatreverser;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatReverser extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("reverse").setExecutor(new ReversifierCaller(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
