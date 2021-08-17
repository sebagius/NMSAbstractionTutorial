package dev.agius.minecraft.abstraction.model.v1_8_R3;

import dev.agius.minecraft.abstraction.model.APlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerConnection;

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
