package Storage;

public class CommentFile extends FileOperations{

    //Properties
    private String directory = "src/src/Files/CommentFile";
    private static CommentFile commentFile;

    //Singleton
    private CommentFile(){
    }

    public static CommentFile getInstance(){
        if (commentFile==null)
            commentFile = new CommentFile();
        return commentFile;
    }

    //Methods
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
