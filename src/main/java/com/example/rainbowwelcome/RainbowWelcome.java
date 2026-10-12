package com.example.rainbowwelcome;

import org.bukkit.plugin.java.JavaPlugin;

public class RainbowWelcome extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    }
}
