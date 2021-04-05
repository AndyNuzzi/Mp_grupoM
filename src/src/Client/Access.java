package Client;

import Controller.Controller;

import java.util.Scanner;

public abstract class Access {

    protected Controller controller = new Controller();

    /**
     * Cada log in sobreescribira esta clase, se ecargará de llevar a cabo el log in del usuario
     */
    public abstract void doOperation();

    /**
     * Pide informacion al usuario, ej email, contraseña...
     *
     * @param output
     * @return
     */
    protected String askForData(String output) {
        System.out.println("");
        System.out.println(output);
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Se encargará de pasar al controller el nick y la contraseña, este comprueba que son validos
     * Devolveraun User si ambos son válidos, es decir, se efectúa el log in
     * Null en caso contrario
     *
     * @param nick
     * @param password
     * @return
     */
    protected User validate(String nick, String password) {
        return controller.validate(nick,password);
    }

}
