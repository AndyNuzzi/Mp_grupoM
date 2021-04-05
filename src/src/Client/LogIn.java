package Client;

import java.util.Locale;
import java.util.Scanner;

public class LogIn extends Access{


    /**
     * Gestiona el log in en caso de que sea para usuarios ya registrados
     */
    @Override
    public void doOperation() {
        System.out.println(" Log In: ");
        int tries = 0;
        User user = null;
        while (tries < 3 && user == null) {
            String nick = super.askForData(" Introduce your nick ");
            String password = super.askForData(" Introduce your password");;
            user = super.validate(nick, password);
            if (user == null) {
                System.out.println("Wrong user");
                tries += 1;
            }
        }
        System.out.println(" Log in successful ");
        if (user.getClass().getSimpleName().equals("Client")){
            Client client = (Client) user;
            client.doOperation();
        } else {
            Administrator administrator = (Administrator) user;
            administrator.doOperation();
        }
    }


}
