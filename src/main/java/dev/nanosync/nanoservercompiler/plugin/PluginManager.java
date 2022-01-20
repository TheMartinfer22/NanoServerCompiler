package dev.nanosync.nanoservercompiler.plugin;

import dev.nanosync.nanoservercompiler.file.PropertiesManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class PluginManager {
    public static void compileProject() throws Exception {
        System.out.println("Compilando o projeto...");
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(PropertiesManager.getMavenCommand(), new String[]{""}, new File(PropertiesManager.getFolderProject()));
        Thread.sleep(8200);
        moveProject();
    }

    public static void moveProject() throws Exception {
        System.out.println("Copiando o arquivo do target para os plugins...");
        File targetJarFile = new File(PropertiesManager.getFolderProject() + "/target/" + PropertiesManager.getJarName());
        if (targetJarFile.exists()){
            File folderPlugins = new File("plugins");
            folderPlugins.mkdir();
            Files.move(Paths.get(targetJarFile.toURI()), Paths.get(System.getProperty("user.dir") + "/plugins/" + PropertiesManager.getJarName()), REPLACE_EXISTING);
        } else {
            System.out.println("O arquivo JAR não existe no projeto, verifique as variáveis novamente.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Você deseja realizar o processo novamente? (S/N)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("N")) {
            System.out.println("Encerrando a aplicação...");
        } else {
            PluginManager.compileProject();
        }
    }
}
