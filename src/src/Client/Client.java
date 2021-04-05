package Client;

import java.util.*;
import java.io.Serializable;

public class Client extends User implements Serializable{

    private List<Offer> onSale = new ArrayList<Offer>();
    private boolean pirate;
    private List <String> subscription = new LinkedList<String>();
    private int additionVote;
    private int interactions;
    // preguntar de donde es el import si de sql o de java util
    private Date banned;
    private boolean warning;

    public Client(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);

    public void setPirate(boolean pirate) {
        this.pirate = pirate;
    }

    public boolean getPirate() {
        return pirate;
    }

    @Override
    public void doOperation() {
        ClientOperation op1 = new CreateOffer();
        ClientOperation op2 = new SearchOffer();
        ClientOperation op3 = new Subscribe();
        ClientOperation op4 = new CheckNotifications();
        ClientOperation op5 = new CheckComments();
        ClientOperation op6 = new CheckValoration();
        super.operations.add(op1);
        super.operations.add(op2);
        super.operations.add(op3);
        super.operations.add(op4);
        super.operations.add(op5);
        super.operations.add(op6);
        super.getOperation();
    }

}
