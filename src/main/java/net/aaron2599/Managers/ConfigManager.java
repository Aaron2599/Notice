package net.aaron2599.Managers;

import net.aaron2599.Features.Module.Module;
import net.aaron2599.Features.Setting.Setting;
import net.aaron2599.Features.Setting.types.*;
import net.aaron2599.Notice;
import net.aaron2599.Utils.FileUtils;
import net.aaron2599.Utils.Globals;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager implements Globals {

    private final String configsFolder = Notice.Folder + "configs/";
    private final String configFile = Notice.Folder + "config.txt";
    private String activeConfig = configsFolder + "Default/";
    private String configName = "Default";

    private void loadConfigName() throws IOException {
        BufferedReader br = Files.newBufferedReader(Path.of(configFile));
        String config = br.readLine();

        if(config != null){
            configName = config.trim();
            activeConfig = configsFolder + configName + "/";
            FileUtils.verifyDir(Path.of(activeConfig));
        }
        br.close();
    }

    private void saveConfigName() throws IOException {
        Path path = Path.of(configFile);
        FileUtils.verifyFile(path);
        BufferedWriter br = Files.newBufferedWriter(path);
        br.write(configName);
        br.flush();
        br.close();
    }

    private void loadModules() throws IOException {
        for(Module module : Notice.Modules.getModules()) {
            Path path = Path.of(activeConfig + module.getName() + ".txt");
            if(Files.exists(path)) {
                BufferedReader br = Files.newBufferedReader(path);

                String line;
                while((line = br.readLine()) != null) {
                    try {
                        String[] columns = line.trim().split(":");
                        if(columns.length < 3) continue;
                        String type = columns [0];
                        String name = columns[1];
                        String value = columns[2];

                        System.out.println(type);

                        Setting<?> setting = module.getSettingByName(name);
                        switch (type) {
                            case "Module" -> {
                                module.setActive(Boolean.parseBoolean(columns[2]));
                                module.setVisible(Boolean.parseBoolean(columns[3]));
                                module.setHold(Boolean.parseBoolean(columns[4]));
                            }
                            case "Bind" -> ((BindSetting) setting).setBind(Integer.parseInt(value));
                            case "Boolean" -> ((BooleanSetting) setting).setValue(Boolean.parseBoolean(value));
                            case "Color" -> {
                                int r = Integer.parseInt(columns[2]);
                                int g = Integer.parseInt(columns[3]);
                                int b = Integer.parseInt(columns[4]);
                                ((ColorSetting) setting).setValue(new Color(r, g, b));
                                ((ColorSetting) setting).setRainbow(Boolean.parseBoolean(columns[5]));
                            }
                            case "Enum" -> ((EnumSetting) setting).setValue(value);
                            case "Slider" -> ((SliderSetting) setting).setValue(Double.parseDouble(value));
                        }

                    } catch (Exception e) {
                        System.out.println("Exception Loading module " + module.getName() + " " + e);
                    }

                }

            }
        }
    }

    private void saveModules() throws IOException {
        for(Module module : Notice.Modules.getModules()) {
            Path path = Path.of(activeConfig + module.getName() + ".txt");
            FileUtils.verifyFile(path);
            BufferedWriter br = Files.newBufferedWriter(path);

            br.write("Module" + ":" + module.getName() + ":" + module.isActive() + ":" + module.isVisible() + ":" + module.Hold() + "\n");

            for(Setting<?> setting : module.getSettings()) {
                if(setting instanceof ColorSetting colorSetting){
                    Color value = colorSetting.getValue();
                    br.write(setting.getType() + ":" + setting.getName() + ":" + value.getRed() + ":" + value.getGreen() + ":" + value.getBlue() + colorSetting.isRainbow() + "\n");
                } else {
                    br.write(setting.getType() + ":" + setting.getName() + ":" + setting.getValue() + "\n");
                }
            }
            br.flush();
            br.close();
        }
    }

    public ConfigManager() {
        FileUtils.verifyDir(Path.of(configsFolder));
        FileUtils.verifyFile(Path.of(configFile));
        FileUtils.verifyDir(Path.of(activeConfig));

        loadConfig();
        saveConfig();
    }

    public void saveConfig() {
        try {
            saveConfigName();
            saveModules();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadConfig() {
        try {
            loadConfigName();
            loadModules();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
