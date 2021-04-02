package Client;

import java.util.Locale;

public class RegisterAsClient extends Access {

    /**
     * Le pasa el nick al controller, este verifica si ya existe, si no exiete devuelve el IdNumber del cliente
     * Si ya existe devuelve null
     *
     * @param nick
     * @return
     */
    private String validateNick(String nick) {
        // le pasamos el nick al controlador, este nos devolvera el idNumber si el nick es valido o null si no
        return null;
    }

    /**
     * Verifica que las dos contraseñas sean iguales
     *
     * @param oldPassword
     * @param newPassword
     * @return
     */
    private String verifyPassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            return oldPassword;
        }
        return null;
    }

    /**
     * Pide si el usuario tiene licencia
     *
     * @param species
     * @return
     */
    private boolean verifyLicense(String species) {
        return super.askForData(" Introduce yes if u have a license, no if you do not ").toLowerCase().equals("yes");
    }

    /**
     * Crea un cliente y se lo pasa al controller para que lo guarde
     *
     * @param client
     */
    private void createUser(Client client) {
        // le pasamos el cliente para que lo cree
    }

    /**
     * Se encarga de pedir las dos contraseñas y comprobar que son iguales
     *
     * @return
     */
    private String askForPassword() {
        int tries = 0;
        String password = null;
        while (tries < 3 && password == null) {
            String oldPassword = super.askForData(" Introduce your password ");
            String newPassword = super.askForData(" Introduce your password again ");
            password = this.verifyPassword(oldPassword, newPassword);
            if (password == null) {
                System.out.println(" Wrong password ");
                tries += 1;
            }
        }
        return password;
    }

    /**
     * Gestiona el registro de usuarios nuevos
     */
    @Override
    public void doOperation() {
        System.out.println(" Register as client ");
        Client client = null;
        String name = super.askForData(" Introduce your name");
        String planet = super.askForData(" Introduce your planet").toLowerCase();
        String species = super.askForData("Introduce your species").toLowerCase();
        String idNumber = null;
        String nick = null;
        int tries = 0;
        while (tries < 3 && idNumber == null) {
            nick = super.askForData(" Introduce your nick ");
            idNumber = this.validateNick(nick);
            if (idNumber == null) {
                System.out.println(" Wrong nick ");
                tries += 1;
            }
        }
        if (idNumber != null) {
            String password = this.askForPassword();
            if (password != null) {
                String email = super.askForData(" Introduce your email ");
                if (species.equals("kromagg")) {
                    boolean license = this.verifyLicense(species);
                    client = new Kromagg(name, planet, species, idNumber, nick, password, email, license);
                } else {
                    client = new Client(name, planet, species, idNumber, nick, password, email);
                }
                this.createUser(client);
                System.out.println(" New User created successfully ");
                User user = super.validate(nick, password);
                System.out.println(" Log in successful ");

                // Si en user haces esto, this.getClass().getSimpleName() Client???

                if (user.getClass().getSimpleName().equals("Client")){
                    client = (Client) user;
                    client.doOperation();
                } else {
                    Administrator administrator = (Administrator) user;
                    administrator.doOperation();
                }
            }
        }
    }

}
