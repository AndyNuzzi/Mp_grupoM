package Storage;

public class OfferFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/OfferFile";
    private static OfferFile offerFile;

    //Singleton
    private OfferFile(){
    }

    public static OfferFile getInstance(){
        if (offerFile==null)
            offerFile = new OfferFile();
        return offerFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
