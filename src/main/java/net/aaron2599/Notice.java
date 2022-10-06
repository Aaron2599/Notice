package net.aaron2599;

import net.aaron2599.EventBus.EventBus;
import net.aaron2599.Features.Command.Commands;
import net.aaron2599.Features.Module.Modules;
import net.aaron2599.Managers.ConfigManager;
import net.aaron2599.Utils.FileUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.nio.file.Path;

@Environment(EnvType.CLIENT)
public class Notice implements ClientModInitializer {

    public static Notice Instance;

    public static final String Name = "Notice";
    public static final String Build = "1.0";

    public static final String Folder = "Notice/";

    public static EventBus EventBus = new EventBus();
    public static Commands Commands = new Commands();
    public static Modules Modules = new Modules();

    public static ConfigManager ConfigManager;

    @Override
    public void onInitializeClient() {
        if(Instance != null) return;
        FileUtils.verifyDir(Path.of(Folder));
        Instance = this;

        ConfigManager = new ConfigManager();

    }

}
