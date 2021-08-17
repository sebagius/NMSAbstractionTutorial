package dev.agius.minecraft.abstraction.model;

public abstract class ACraftPlayer {
    protected Object craftPlayer;

    public ACraftPlayer(Object craftPlayer) {
        this.craftPlayer = craftPlayer;
    }

    public abstract APlayerConnection getPlayerConnection();
}
