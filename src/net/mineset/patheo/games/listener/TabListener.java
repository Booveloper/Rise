package net.mineset.patheo.games.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class TabListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTabComplete(PlayerChatTabCompleteEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("RANK_OWNER") || !player.hasPermission("RANK_ADMIN")) {
            event.getTabCompletions().clear();
        }

    }
}
