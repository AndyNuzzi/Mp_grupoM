package Storage;

public class SwindlerFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/SwindlerFile";
    private static SwindlerFile swindlerFile;

    //Singleton
    private SwindlerFile(){
    }

    public static SwindlerFile getInstance(){
        if (swindlerFile==null)
            swindlerFile = new SwindlerFile();
        return swindlerFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
