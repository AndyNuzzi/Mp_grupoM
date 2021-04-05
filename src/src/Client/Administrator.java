package Client;

import java.io.Serializable;

public class Administrator extends User implements Serializable {
    public Administrator(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    @Override
    public void doOperation() {
        System.out.println("Soy un administrador");
    }


}
