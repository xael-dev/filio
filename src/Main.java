//Import the file class and NIO java file packages
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;


//Error handling
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

//Create a file (on UNIX based systems)
//File myFileObj = new File("/Users/xael/Desktop/TestFolder/filetest.txt");

//Basic File creation
public class Main {
    public static void main(String[] args) throws IOException {
//        File myObj = new File("/Users/xael/Desktop/TestFolder/filetest.txt");
//        myObj.createNewFile();
//        System.out.println(myObj.getName());

        System.out.println(System.getProperty("user.dir"));

        try {
            FileWriter myFileWriter = new FileWriter("/Users/xael/Desktop/TestFolder/filetest.txt");
            myFileWriter.write("Testing write to a file created using Java");
            myFileWriter.close();
            System.out.println("Written to file!");
        } catch (Exception e){
            e.printStackTrace();
        };

        //Write to file specified, for now to file created
//        FileWriter myFileWriter = new FileWriter("/Users/xael/Desktop/TestFolder/filetest.txt");
//        myFileWriter.write("Testing write to a file created using Java");
//        myFileWriter.close();
//        System.out.println("Wrote to file");

        //After writing to file move file to desktop as a test
        Path sourcePath = Paths.get("/Users/xael/Desktop/TestFolder/filetest.txt");
        Path targetPath = Paths.get("/Users/xael/Desktop/TestFolder2/filetest.txt");

        Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(targetPath + " file copied!");
    }
}
