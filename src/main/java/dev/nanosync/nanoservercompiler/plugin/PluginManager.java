package dev.nanosync.nanoservercompiler.plugin;

import dev.nanosync.nanoservercompiler.external.PropertiesManager;

import java.io.File;

import static dev.nanosync.nanoservercompiler.external.ProjectJARManager.move;

public class PluginManager {
    public static void compileProject() throws Exception {
        System.out.println("Compilando o projeto...");
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(PropertiesManager.getMavenCommand(), new String[]{""}, new File(PropertiesManager.getFolderProject()));
        Thread.sleep(8200);
        move("/target/", "/plugins/");
    }
}
