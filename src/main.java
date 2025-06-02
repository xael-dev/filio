//Import the file class
import java.io.File;

//Error handling
import java.io.IOException;

//Create a file (on UNIX based systems)
//File myFileObj = new File("/Users/xael/Desktop/TestFolder/filetest.txt");

//Basic File creation
public class main {
    public static void main(String[] args) throws IOException {
        File myObj = new File("/Users/xael/Desktop/TestFolder/filetest.txt");
        myObj.createNewFile();
        System.out.println(myObj.getName());
    }
}
