package net.mineset.patheo.games.player;

import net.mineset.patheo.games.manager.InternalServerRank;
import net.mineset.patheo.games.manager.RankFinder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (!player.getServer().getServerName().equalsIgnoreCase("PARKOUR-1")) {
            InternalServerRank playerRank = RankFinder.GetRank(player);
            event.setFormat("%s§7:" + playerRank.CColor + " %s");
        }
    }
}
