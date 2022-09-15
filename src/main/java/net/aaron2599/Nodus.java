package net.aaron2599;

import net.aaron2599.EventBus.EventBus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Nodus implements ClientModInitializer {

    public static Nodus Instance;

    public static final String Name = "Nodus++";
    public static final String Build = "1.0";

    public static EventBus EventBus = new EventBus();

    @Override
    public void onInitializeClient() {
        if(Instance == null) Instance = this;



    }
}
