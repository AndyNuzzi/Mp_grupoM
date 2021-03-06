package Client;

import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;

public class Client extends User implements Serializable{

    private boolean pirate;
    private LocalDate banned;
    private boolean warning;
    private List<Notification> notificationList = new LinkedList<Notification>();

    public Client (){
        super ();
    }

    public Client(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    public void setPirate(boolean pirate) {
        this.pirate = pirate;
    }

    public boolean getPirate() {
        return pirate;
    }

    /**
     * Se encarga de meter las operaciones del cliente en la lista, y luego llamarĂ¡ al elegir operaciones
     */
    @Override
    public void doOperation() {
        ClientOperation op1 = new CreateOffer(this);
        ClientOperation op2 = new SearchOffer(this);
        ClientOperation op3 = new CheckValoration(this);
        ClientOperation op4 = new CheckNotifications(this);
        ClientOperation op5 = new CheckComments(this);
        ClientOperation op6 = new Subscribe(this);
        ClientOperation op7 = new CancelSubscription(this);
        super.operations.add(op1);
        super.operations.add(op2);
        super.operations.add(op3);
        super.operations.add(op4);
        super.operations.add(op5);
        super.operations.add(op6);
        super.operations.add(op7);
        super.getOperation();
    }

    public LocalDate getBanned() {
        return banned;
    }

    public void setBanned(LocalDate banned) {
        this.banned = banned;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }

    public void addNotification(Notification n){
        notificationList.add(n);
    }

    public List<Notification> getNotificationList(){
        return notificationList;
    }

    public void setNotificationList(){
        while (!notificationList.isEmpty())
            notificationList.remove(0);
    }

}
