package net.mineset.patheo.games;

import net.mineset.patheo.games.pet.Pet;
import net.mineset.patheo.games.listener.BlockCommandListener;
import net.mineset.patheo.games.listener.ScoreboardListener;
import net.mineset.patheo.games.listener.TabListener;
import net.mineset.patheo.games.manager.RankCommand;
import net.mineset.patheo.games.player.PlayerChatListener;
import net.mineset.patheo.games.player.PlayerJoinListener;
import net.mineset.patheo.games.player.PlayerQuitListener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RiseCore extends JavaPlugin implements Listener {

    private Map<UUID, Pet> pets;

    private List<EntityType> petTypes;

    public void onEnable() {
        this.pets = new HashMap<>();
        this.petTypes = Arrays.asList(
                EntityType.CHICKEN
        );

        getCommand("user").setExecutor(new RankCommand(this));

        getServer().getPluginManager().registerEvents(this, this);

        getServer().getPluginManager().registerEvents(new BlockCommandListener(), this);
        getServer().getPluginManager().registerEvents(new ScoreboardListener(this), this);
        getServer().getPluginManager().registerEvents(new TabListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }

    public void onDisable() {
       // stuff
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        EntityType petType = petTypes.get(ThreadLocalRandom.current().nextInt(petTypes.size()));

        if (player.hasPermission("RANK_VIBE")) {
            spawnPet(new Pet(player, petType));
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Pet pet = pets.get(event.getPlayer().getUniqueId());

        pet.getBukkitEntity().getPassenger().remove();

        if (player.hasPermission("RANK_VIBE")) {
            pet.die();
        }
    }

    private void spawnPet(Pet pet) {
        Location loc = pet.getOwner().getLocation();

        pet.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        ((CraftWorld) loc.getWorld()).getHandle().addEntity(pet);

        ArmorStand armorStand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(ChatColor.GREEN.toString() + pet.getOwner().getName() + "'s Pet Chicken");

        pet.getBukkitEntity().setPassenger(armorStand);

        pets.put(pet.getOwner().getUniqueId(), pet);
    }
}
