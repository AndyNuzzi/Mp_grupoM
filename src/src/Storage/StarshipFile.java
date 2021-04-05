package Storage;

public class StarshipFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/StarshipFile";
    private static StarshipFile starshipFile;

    //Singleton
    private StarshipFile(){
    }

    public static StarshipFile getInstance(){
        if (starshipFile==null)
            starshipFile = new StarshipFile();
        return starshipFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }
}
