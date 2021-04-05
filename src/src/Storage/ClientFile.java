package Storage;

import java.util.List;

public class ClientFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/ClientFile";
    private static ClientFile clientFile;

    //Singleton
    private ClientFile(){
    }

    public static ClientFile getInstance(){
        if (clientFile==null)
            clientFile = new ClientFile();
        return clientFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }

}
