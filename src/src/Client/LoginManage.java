package Client;

import java.util.Scanner;

public class LoginManage {

    /**
     * Muestra el menu de log in
     */
    private void showLoginMenu() {
        System.out.println("");
        System.out.println(" Welcome ");
        System.out.println("");
        System.out.println(" Select an option");
        System.out.println(" 1. Log in, for created accounts");
        System.out.println(" 2. Register as client, for first time users");
        System.out.println(" 3. Exit ");
        System.out.println("");
    }

    /**
     * Gestiona el pedir la opción de log in, y ejecuta el log in elegido
     */
    public void doOperation() {
        int loginOption;
        Access access;
        do {
            this.showLoginMenu();
            Scanner scanner = new Scanner(System.in);
            loginOption = scanner.nextInt();
            switch (loginOption) {
                case 1:
                    access = new LogIn();
                    access.doOperation();
                    break;
                case 2:
                    access = new RegisterAsClient();
                    access.doOperation();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("This isn't a valid option");
                    break;
            }

        }
        while (loginOption != 3);
        System.out.println(" See you soon ");
    }
}
