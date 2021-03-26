package Client;

import java.io.Serializable;

public class Client extends User implements Serializable {
    public Client(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    boolean pirate;

    public void setPirate(boolean pirate) {
        this.pirate = pirate;
    }

    public boolean getPirate() {
        return pirate;
    }

}
