package dev.nanosync.nanoservercompiler.external;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ProjectJARManager {
    public static void move(String jarProjectFolder, String to) throws Exception {
        System.out.println("Copiando o arquivo do target para os plugins...");
        File targetJarFile = new File(PropertiesManager.getFolderProject() + jarProjectFolder + PropertiesManager.getJarName());
        if (targetJarFile.exists()){
            File folderPlugins = new File("plugins");
            folderPlugins.mkdir();
            Files.move(Paths.get(targetJarFile.toURI()), Paths.get(System.getProperty("user.dir") + to + PropertiesManager.getJarName()), REPLACE_EXISTING);
        } else {
            System.out.println("O arquivo JAR não existe no projeto, verifique as variáveis novamente.");
        }
    }
}
