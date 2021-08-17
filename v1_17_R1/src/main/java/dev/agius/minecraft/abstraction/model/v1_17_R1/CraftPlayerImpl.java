package dev.agius.minecraft.abstraction.model.v1_17_R1;

import dev.agius.minecraft.abstraction.model.ACraftPlayer;
import dev.agius.minecraft.abstraction.model.APlayerConnection;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;

public class CraftPlayerImpl extends ACraftPlayer {

    public CraftPlayerImpl(CraftPlayer craftPlayer) {
        super(craftPlayer);
    }


    public APlayerConnection getPlayerConnection() {
        return new PlayerConnectionImpl(((CraftPlayer) craftPlayer).getHandle().b);
    }
}
