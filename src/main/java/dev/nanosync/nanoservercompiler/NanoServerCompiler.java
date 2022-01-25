package dev.nanosync.nanoservercompiler;

import dev.nanosync.nanoservercompiler.external.PropertiesManager;
import dev.nanosync.nanoservercompiler.handler.ServerHandler;
import dev.nanosync.nanoservercompiler.plugin.PluginManager;

import java.io.*;
import java.util.Scanner;

public class NanoServerCompiler {

    private static String folderProject;
    private static String mavenCompileCommand;
    private static String jarName;

    public static void main(String[] args) throws Exception {
        PropertiesManager.loadProperties();
        File file = new File("server.jar");
        if (!file.exists()) callJAR();

        if (PropertiesManager.hasProperties()){
            folderProject = PropertiesManager.getFolderProject();
            mavenCompileCommand = PropertiesManager.getMavenCommand();
            jarName = PropertiesManager.getJarName();
        }

        if (folderProject == null && mavenCompileCommand == null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o diretório root do projeto JAR:");
            folderProject = scanner.nextLine();
            System.out.println("Digite o comando para compilar o projeto para target folder:");
            mavenCompileCommand = scanner.nextLine();
            System.out.println("Digite o nome do arquivo JAR:");
            jarName = scanner.nextLine();
            PropertiesManager.assignProperties(folderProject, mavenCompileCommand, jarName);
        }

        PluginManager.compileProject();
    }

    public static void callJAR() throws IOException {
        new ServerHandler("Arclight");
    }
}
