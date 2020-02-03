package net.mineset.patheo.games.player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.mineset.patheo.games.manager.InternalServerRank;
import net.mineset.patheo.games.manager.RankFinder;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.lang.reflect.Field;
import java.util.Iterator;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        Player player = event.getPlayer();

        InternalServerRank playerRank = RankFinder.GetRank(player);
        player.setDisplayName(playerRank.Prefix + player.getName());

        if (player.hasPermission("RANK_VIBE")) {
            @SuppressWarnings("rawtypes")
            Iterator var8 = Bukkit.getServer().getOnlinePlayers().iterator();
            if (var8.hasNext()) {
                Bukkit.broadcastMessage("§7➟ " + playerRank.Prefix + playerRank.ShortPrefix + player.getName() + " joined the lobby!");
                return;
            }

        }
    }
}
