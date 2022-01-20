package dev.nanosync.nanoservercompiler.handler;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerHandler {

    public ServerHandler(String serverType) throws IOException {
        URL url;
        switch (serverType){
            // Todo user can switch for server jar
            case "Arclight":
                url = new URL("https://github.com/IzzelAliz/Arclight/releases/download/1.16%2F1.0.21/arclight-forge-1.16.5-1.0.21.jar");
                break;
            default:
                throw new FileNotFoundException("Endereço para a JAR não foi encontrada.");
        }
        System.out.println("Baixando a JAR de servidor " + serverType);
        Files.copy(url.openStream(), Paths.get("server.jar"));
        prepareConfigurations();
    }

    private void prepareConfigurations() throws IOException {
        System.out.println("Criando arquivo EULA...");
        File file = new File("eula.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("eula=true");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
