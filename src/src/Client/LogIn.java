package Client;

import java.util.Scanner;

public class LogIn extends Access{

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
        if (tries < 3){
            System.out.println( " va bien ");
            user.doOperation();
        }
    }


}
