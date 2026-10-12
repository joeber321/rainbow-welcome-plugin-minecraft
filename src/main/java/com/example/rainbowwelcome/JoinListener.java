package com.example.rainbowwelcome;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final String FIRST_JOIN_MESSAGE =
        "<rainbow>Welcome to the server, <player>!</rainbow>";
    private static final String RETURNING_MESSAGE =
        "<gray>Welcome back, <player>!</gray>";

    private final RainbowWelcome plugin;

    public JoinListener(RainbowWelcome plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        boolean firstJoin = !player.hasPlayedBefore();
        String configKey = firstJoin ? "welcome-message" : "returning-welcome-message";
        String defaultMessage = firstJoin ? FIRST_JOIN_MESSAGE : RETURNING_MESSAGE;
        String rawMessage = plugin.getConfig().getString(configKey, defaultMessage);

        Component message = MINI_MESSAGE.deserialize(
            rawMessage,
            Placeholder.unparsed("player", player.getName())
        );
        player.sendMessage(message);
    }
}
