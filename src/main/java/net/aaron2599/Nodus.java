package net.aaron2599;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.lwjgl.system.CallbackI;

@Environment(EnvType.CLIENT)
public class Nodus implements ClientModInitializer {

    public static Nodus Instance;



    public static final String Name = "Nodus++";
    public static final String Build = "1.0";

    @Override
    public void onInitializeClient() {
        if(Instance == null) {
            Instance = this;
        } else {
            System.out.println("ERROR LOADING CLIENT INSTANCE NOT NULL");
        }



    }
}
