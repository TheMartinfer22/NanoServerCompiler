package dev.nanosync.nanoservercompiler.file;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
    private static final File propertiesFile = new File("nanoserver.properties");
    private static final Properties properties = new Properties();

    public static void loadProperties() throws IOException {
        if (!propertiesFile.exists()) {
            propertiesFile.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            OutputStream storeProperties = new FileOutputStream(propertiesFile);
            properties.load(fileInputStream);
            properties.setProperty("FolderProject", "");
            properties.setProperty("MavenCommand", "");
            properties.setProperty("JarName", "");
            properties.store(storeProperties, "");
        }
        FileInputStream fileInputStream = new FileInputStream(propertiesFile);
        properties.load(fileInputStream);
    }

    public static boolean hasProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(propertiesFile);
        properties.load(fileInputStream);
        return !properties.getProperty("FolderProject").equals("");
    }

    public static void assignProperties(String folder, String mavencommand, String jarname) throws IOException {
        OutputStream storeProperties = new FileOutputStream(propertiesFile);
        properties.setProperty("FolderProject", folder);
        properties.setProperty("MavenCommand", mavencommand);
        properties.setProperty("JarName", jarname);
        properties.store(storeProperties, "");
    }

    public static String getFolderProject(){
        return properties.getProperty("FolderProject");
    }

    public static String getMavenCommand(){
        return properties.getProperty("MavenCommand");
    }

    public static String getJarName(){
        return properties.getProperty("JarName");
    }
}
