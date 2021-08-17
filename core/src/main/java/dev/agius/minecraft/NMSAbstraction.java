package dev.agius.minecraft;

import dev.agius.minecraft.abstraction.AbstractionLoader;
import dev.agius.minecraft.abstraction.model.ACraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NMSAbstraction extends JavaPlugin implements Listener {

    private AbstractionLoader abstractionLoader;

    @Override
    public void onEnable() {
        this.abstractionLoader = new AbstractionLoader();
        this.abstractionLoader.loadLocalAbstractions(getServer());

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        this.getServer().getConsoleSender().sendMessage(String.valueOf(getAbstractionLoader().initiateObject(ACraftPlayer.class, e.getPlayer()).getPlayerConnection().isDisconnected()));
    }

    public AbstractionLoader getAbstractionLoader() {
        return this.abstractionLoader;
    }
}
