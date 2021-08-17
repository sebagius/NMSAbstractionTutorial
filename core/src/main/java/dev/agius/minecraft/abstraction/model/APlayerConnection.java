package dev.agius.minecraft.abstraction.model;

public abstract class APlayerConnection {

    protected Object playerConnection;

    public APlayerConnection(Object playerConnection) {
        this.playerConnection = playerConnection;
    }

    public abstract boolean isDisconnected();

}
