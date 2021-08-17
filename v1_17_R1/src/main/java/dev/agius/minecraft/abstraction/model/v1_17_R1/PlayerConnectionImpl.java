package dev.agius.minecraft.abstraction.model.v1_17_R1;

import dev.agius.minecraft.abstraction.model.APlayerConnection;
import net.minecraft.server.network.PlayerConnection;

public class PlayerConnectionImpl extends APlayerConnection {
    private final PlayerConnection internal;

    public PlayerConnectionImpl(PlayerConnection playerConnection) {
        super(playerConnection);
        this.internal = playerConnection;
    }

    @Override
    public boolean isDisconnected() {
        return this.internal.isDisconnected();
    }
}
