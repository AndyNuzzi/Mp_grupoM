package Storage;

public class PiratesFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/PiratesFile";
    private static PiratesFile piratesFile;

    //Singleton
    private PiratesFile(){
    }

    public static PiratesFile getInstance(){
        if (piratesFile==null)
            piratesFile = new PiratesFile();
        return piratesFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
