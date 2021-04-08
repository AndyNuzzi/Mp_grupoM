package Storage;

import java.io.*;
import java.util.List;

public class SubscriptionFile{

    //Properties
    private String directory = "src/src/Files/SubscriptionFile";
    private static SubscriptionFile subscriptionFile;

    //Singleton
    private SubscriptionFile(){
    }

    public static SubscriptionFile getInstance(){
        if (subscriptionFile ==null)
            subscriptionFile = new SubscriptionFile();
        return subscriptionFile;
    }

    public void write(Subscription sub){
        try{
            FileOutputStream output = new FileOutputStream(directory);
            ObjectOutputStream outputObject = new ObjectOutputStream(output);
            outputObject.writeObject(sub);
            output.close();
        } catch (IOException e){
            System.out.println("Error en la escritura de subscription");
        }
    }

    public Subscription read(){
        try {
            FileInputStream inputStream = new FileInputStream(directory);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            Subscription s = (Subscription) input.readObject();
            input.close();
            return s;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    //Methods
    public String getDirectory() {
        return directory;
    }
}
