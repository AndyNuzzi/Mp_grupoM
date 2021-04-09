package Client;

import java.io.Serializable;

public class Notification implements Serializable {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void print(){
        if (message != null){
            System.out.println(message);
        }
    }
}
