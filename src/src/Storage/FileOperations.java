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
            List l = (List) input.readObject();
            input.close();
            return l;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public boolean write(String directory, List l) {
        try {
            FileOutputStream outputStream = new FileOutputStream(directory);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            output.writeObject(l);
            output.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("Not serializable");
            return false;
        }
    }
}
