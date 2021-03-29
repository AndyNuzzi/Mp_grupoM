package Storage;

public class UncheckedOffersFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/UncheckedOffersFile";
    private static UncheckedOffersFile uncheckedOffersFile;

    //Singleton
    private UncheckedOffersFile(){
    }

    public static UncheckedOffersFile getInstance(){
        if (uncheckedOffersFile==null)
            uncheckedOffersFile = new UncheckedOffersFile();
        return uncheckedOffersFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
