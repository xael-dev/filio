import com.xael.filio.utils.FileUtils;
import models.FileItem;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String currentWorkingDir = System.getProperty("user.dir");
        String homeDir = System.getProperty("user.home");

        //List system properties; check OS and use for path specific formatting
        System.out.println(System.getProperty("os.name\n"));

        System.out.println(currentWorkingDir + " is the current directory for the project. \n");
        System.out.println(System.getProperty("user.home") + " is the home directory for the project. \n");



        FileUtils.listFilesInDirectory(Paths.get(homeDir));
        // FileUtils.listFileProperties(Paths.get(homeDir));
    }
}
