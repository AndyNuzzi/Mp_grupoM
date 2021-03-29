package Storage;

public class SaleFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/SaleFile";
    private static SaleFile saleFile;

    //Singleton
    private SaleFile(){
    }

    public static SaleFile getInstance(){
        if (saleFile==null)
            saleFile = new SaleFile();
        return saleFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
