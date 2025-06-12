import com.xael.filio.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String currentWorkingDir = System.getProperty("user.dir");
        String homeDir = System.getProperty("user.home");

        //List system properties
        System.out.println(System.getProperties());

        System.out.println(currentWorkingDir + " is the current directory for the project. \n");
        System.out.println(System.getProperty("user.home") + " is the home directory for the project. \n");


        try {
            FileUtils.listFilesInDirectory(Paths.get(homeDir + "/Downloads/"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
