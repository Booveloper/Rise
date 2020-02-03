package net.mineset.patheo.games.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockCommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();

        if (command.startsWith("/spigot:") ||
                command.startsWith("/whitelist") ||
                command.startsWith("/permissionex:") ||
                command.startsWith("/pex") ||
                command.startsWith("/permex") ||
                command.startsWith("/permissions") ||
                command.startsWith("/perms") ||
                command.startsWith("/tebex") ||
                command.startsWith("/litebans") ||
                command.startsWith("/clearchat") ||
                command.startsWith("/buycraft") ||
                command.startsWith("/pl") ||
                command.startsWith("/plugins") ||
                command.startsWith("/bukkit:pl") ||
                command.startsWith("/bukkit:plugins") ||
                command.startsWith("/ncp") ||
                command.startsWith("/nocheatplus") ||
                command.startsWith("/version") ||
                command.startsWith("/ver") ||
                command.startsWith("/icanhasbukkit") ||
                command.startsWith("/bukkit:") ||
                command.startsWith("/minecraft:") ||
                command.startsWith("/op")) {

            event.setCancelled(true);
            player.sendMessage("§cCommand is unrecognized by the server!");
        }

    }
}
