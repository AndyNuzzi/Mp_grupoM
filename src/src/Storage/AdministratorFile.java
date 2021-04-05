package Storage;

import java.util.List;

public class AdministratorFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/AdministratorFile";
    private static AdministratorFile administratorFile;

    //Singleton
    private AdministratorFile(){
    }

    public static AdministratorFile getInstance(){
        if (administratorFile==null)
            administratorFile = new AdministratorFile();
        return administratorFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
