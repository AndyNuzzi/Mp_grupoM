package Storage;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileOperations implements Serializable {


    //Methods
    public List read(String directory) {
        try {
            FileInputStream inputStream = new FileInputStream(directory);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            return (List) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public boolean write(String directory, List l) {
        try {
            FileOutputStream outputStream = new FileOutputStream(directory);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            output.writeObject(l);
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
}
