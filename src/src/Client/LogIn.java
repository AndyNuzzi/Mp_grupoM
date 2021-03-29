package Client;

import java.util.Scanner;

public class LogIn extends Access{

    // mejor nick

    @Override
    public boolean doOperation() {
        int tries = 0;
        User user = null;
        while (tries < 3 && user == null) {
            String nick = super.askForData(" Introduce your nick ");
            if (nick == null) {
                return true;
            }
            String password = super.askForData(" Introduce your password");
            if (password == null) {
                return true;
            }
            user = this.validate(nick, password);
            if (user == null) {
                System.out.println("Wrong user");
                tries += 1;
            }
        }
        if (tries == 3){
            return true;
        }
        // aqui ya lo que toca es ejecutar el usuaria y con ello el menu de las operaciones
        // no tiene que devolver nada, ya que se acabara cuando le de a salir
        System.out.println( " va bien ");
        user.doOperation();
        return false;
    }

    protected User validate(String nick, String password) {
        // aqui falta el buscar si existe y si no es sospechoso
        // y que nos devuelvan el usuario
        // si no existe devuelve null
        // si existe devuelve el usuario
        return null;
    }


}
