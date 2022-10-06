package net.aaron2599.Utils;

import net.minecraft.client.MinecraftClient;

public interface Globals {

    MinecraftClient mc = MinecraftClient.getInstance();

    default boolean nullCheck() { return mc.player == null || mc.world == null; }
}
