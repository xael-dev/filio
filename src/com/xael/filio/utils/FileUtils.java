package com.xael.filio.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FileUtils {

    public static boolean doesFileExist(String targetFilePath){
        return Files.exists(Paths.get(targetFilePath));
    }

    public static String listFilesInDirectory(Path targetFilePath) throws IOException {
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(targetFilePath)){
            for (Path path : ds){
                System.out.println(path);
            }
        }
        return "Files listed!";
    }

    //If file is smaller then 2GB
    public static String readSmallFile(String targetFilePath) throws IOException {
        return Arrays.toString(Files.readAllBytes(Paths.get(targetFilePath)));
    }

    //Consider method overloading to create and write?
    public static String createFile(String filePath) throws IOException{
        try {
            File myFileObj = new File(filePath);
            myFileObj.createNewFile();
        } catch (Exception e){
            e.printStackTrace(); //TODO: Replace with better logging
        }
        return "File created successfully";
    }

    public static void writeFile(String targetFilePath, String writeContent) throws IOException {
        try {
            FileWriter myFileWriter = new FileWriter(targetFilePath);
            myFileWriter.write(writeContent);
            myFileWriter.close();
            System.out.println("File written!");
        } catch (Exception e){
            e.printStackTrace(); // TODO: Replace with better logging
        }
    }

    public static String copyFile(Path sourcePath, Path targetPath, String optionForMove) throws IOException{
        try {
            Files.copy(sourcePath, targetPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "File Copied successfully!";
    }

    public static String moveFile(Path sourcePath, Path targetPath) throws IOException {
        try {
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace(); //TODO: Replace with better logging
        }

        return "File was moved successfully!";
    }
}
