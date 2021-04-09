package Storage;

public class IdentificatorsFile extends FileOperations{
    //Properties
    private String directory = "src/src/Files/IdentificatorsFile";
    private static IdentificatorsFile idFile;

    //Singleton
    private IdentificatorsFile(){
    }

    public static IdentificatorsFile getInstance(){
        if (idFile==null)
            idFile = new IdentificatorsFile();
        return idFile;
    }

    public String getDirectory(){
        return directory;
    }
}
