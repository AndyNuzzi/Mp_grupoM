package Client;

import java.util.Locale;

public class RegisterAsClient extends Access {

    // GUARDAR EN MAYUSCULAS EN:
    // PLANETA, ESPECIE

    // no salir
    // PARA REGISTRARSE
    // 1 PASARLE EL NICK, DEVUELVE EL ID
    // 2 PASARLE EL USUARIO
    // TE DEVUELVE EL USER Y LO INCIA SESION


    private String validateNick(String nick) {
        // le pasamos el nick al controlador, este nos devolvera el idNumber si el nick es valido o null si no
        return null;
    }

    private String verifyPassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            return oldPassword;
        }
        return null;
    }

    private boolean verifyLicense(String species) {
        return super.askForData(" Introduce yes if u have a license, no if you do not ").toLowerCase().equals(" yes ");
    }

    private void createUser (Client client){
        // le pasamos el cliente para que lo cree
    }

    @Override
    public void doOperation() {
        System.out.println(" Register as client ");
        Client client = null;
        String name = super.askForData(" Introduce your name");
        String planet = super.askForData(" Introduce your planet").toLowerCase();
        String species = super.askForData("Introduce your species").toLowerCase();

        String idNumber = null;
        int tries = 0;
        String nick = null;
        while (tries < 3 && idNumber == null) {
            nick = super.askForData(" Introduce your nick ");
            idNumber = this.validateNick(nick);
            tries += 1;
        }
        if (tries < 3) {
            tries = 0;
            String password = null;
            while (tries < 3 && password == null) {
                String oldPassword = super.askForData(" Introduce your password ");
                String newPassword = super.askForData(" Introduce your password again ");
                password = this.verifyPassword(oldPassword, newPassword);
            }
            if (tries < 3) {
                String email = super.askForData(" Introduce your email ");
                if (species.equals(" kromagg ")) {
                    boolean license = this.verifyLicense(species);
                    client = new Kromagg(name, planet, species, idNumber, nick, password, email, license);
                } else {
                    client = new Client(name, planet, species, idNumber, nick, password, email);
                }
                this.createUser(client);
                User user = super.validate(nick, password);
                user.doOperation();
            }
        }
    }

}
