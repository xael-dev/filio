package com.xael.filio.utils;

import models.FileItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class FileUtils {

    //Prevent instantiation of this class
    private FileUtils(){}
    public static boolean doesFileExist(String targetFilePath){
        return Files.exists(Paths.get(targetFilePath));
    }

    public static boolean isPathDir(Path targetFilePath) {
        if (Files.isDirectory(targetFilePath)){
            return true;
        }

        return false;
    }

    public static void listFilesInDirectory(Path targetFilePath) throws IOException {
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(targetFilePath)){
            for (Path path : ds){
                if (isPathDir(path)){
                    System.out.println(path);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO: Separate logic for getting file Properties in directory? Or make a method that does one and loop it? (JMH)
    public static void listFileProperties(Path targetFilePath) throws IOException{
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(targetFilePath);) {
            for (Path path : ds){
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                FileItem detailedFileItem = new FileItem(path, attrs);
                System.out.println(detailedFileItem);
            }
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
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
        } catch (RuntimeException e){
            throw new RuntimeException(e);
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
