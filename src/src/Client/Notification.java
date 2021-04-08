package Client;

public class Notification {
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
