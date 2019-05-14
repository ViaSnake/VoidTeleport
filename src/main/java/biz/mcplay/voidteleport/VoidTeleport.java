package biz.mcplay.voidteleport;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidTeleport extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("VoidTeleport is enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("VoidTeleport is disabled.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location loc = player.getLocation();
        if(player.getWorld() == getServer().getWorlds().get(0) && loc.getY() <= 0.0) {
            player.teleport(getServer().getWorlds().get(0).getSpawnLocation());
        }
    }
}

