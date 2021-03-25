package Client;

import java.io.IOException;
import java.util.Scanner;

public class LoginManage {

    private void showLoginMenu() {
        System.out.println("");
        System.out.println(" Wellcome ");
        System.out.println("");
        System.out.println(" Select an option");
        System.out.println(" 1. Register as administrator");
        System.out.println(" 2. Register as client");
        System.out.println("");
    }

    public void doOperation() {
        this.showLoginMenu();
        Scanner scanner = new Scanner(System.in);
        int loginOption = scanner.nextInt();
        if (loginOption == 1) {
            LogIn login = new RegisterAsAdministrator();
            login.doOperation();
        } else if (loginOption == 2) {
            LogIn login = new RegisterAsClient();
            login.doOperation();
        } else {
            System.out.println(" See you soon ");
            System.out.println("");
        }

    }
}
