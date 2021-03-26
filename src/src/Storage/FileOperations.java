package Storage;

import Client.Client;

import java.io.*;
import java.util.List;

public class FileOperations implements Serializable {

    protected String directory;

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
            System.out.println("Not serializable");
            return false;
        }
    }
}
