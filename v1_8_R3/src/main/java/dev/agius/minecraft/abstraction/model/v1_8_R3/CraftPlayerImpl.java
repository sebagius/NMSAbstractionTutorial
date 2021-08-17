package dev.agius.minecraft.abstraction.model.v1_8_R3;

import dev.agius.minecraft.abstraction.model.ACraftPlayer;
import dev.agius.minecraft.abstraction.model.APlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

public class CraftPlayerImpl extends ACraftPlayer {

    public CraftPlayerImpl(CraftPlayer craftPlayer) {
        super(craftPlayer);
    }

    @Override
    public APlayerConnection getPlayerConnection() {
        return new PlayerConnectionImpl(((CraftPlayer) craftPlayer).getHandle().playerConnection);
    }
}
