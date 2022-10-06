package net.aaron2599.Utils;

import org.lwjgl.system.CallbackI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static void verifyDir(Path path) {
        if(!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void verifyFile(Path path) {
        if(!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
