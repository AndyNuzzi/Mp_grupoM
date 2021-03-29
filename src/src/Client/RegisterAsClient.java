package Client;

public class RegisterAsClient extends Access {

    // GUARDAR EN MAYUSCULAS EN:
    // PLANETA, ESPECIE

    // no salir
    // PARA REGISTRARSE
    // 1 PASARLE EL NICK, DEVUELVE EL ID
    // 2 PASARLE EL USUARIO
    // TE DEVUELVE EL USER Y LO INCIA SESION

    @Override
    public boolean doOperation() {
        // pensar si usar algun metodo para convertirlo
        User user = null;
        String name = super.askForData(" Introduce your name");
        if (name == null) {
            return true;
        }
        String planet = super.askForData(" Introduce your planet");
        if (planet == null) {
            return true;
        }
        String species = super.askForData("Introduce your species");
        if (species == null) {
            return true;
        }
        boolean license;
        license = this.grantLicense(species);
        // aqui llamaremos al controller para que le asigne una id
        String idNumber = this.assignId();
        String nick = super.askForData(" Introduce your nick ");
        if (nick == null) {
            return true;
        }

        // pedir email y password
        String email = null;
        String password = null;
        int tries = 0;
        boolean validEmailPassword = false;
        while (tries < 3 && validEmailPassword == false) {
            email = super.askForData(" Introduce your email ");
            if (email == null) {
                return true;
            }
            password = super.askForData(" Introduce your password");
            if (password == null) {
                return true;
            }
            validEmailPassword = this.validateEmailPassword(email, password);
            if (validEmailPassword == false) {
                System.out.println("Wrong user");
                tries += 1;
            }
        }

        if (tries == 3) {
            return true;
        }
        if (species.equals(" Kromagg ") || species.equals(" kromagg ") || species.equals("KROMAGG")) {
            user = new Kromagg(name, planet, species, idNumber, nick, password, email, license);
        } else {
            user = new Client(name, planet,species,idNumber,nick, password, email);
        }
        this.validate(user);
        user.doOperation();
        return false;
    }

    // Este metodo pedira aisgnará un id
    protected String assignId() {
        // falta pedir id a la base de datos
        return null;
    }

    private void validate(User user) {
        // aqui se le pasa el usuario a la base de datos para que lo guarde
    }

    private boolean validateEmailPassword(String email, String password) {
        // aqui llamamos al controllardor con el email y la password
        // para ver si esta coincide
        // si coincide devolvemos falso, ya que no lo admite
        return true;
    }

    private boolean grantLicense(String species) {
            // aqui llamar al controler
            // o a lo que sea para pedir si le conceden la licencia
            // o ver como hacerlo
            // devuelve si le dan o no licencia

            // al return le falta el metodo para ver si le dan licencia

        return (species.equals(" Kromagg ") || species.equals(" kromagg ") || species.equals("KROMAGG")) ;
    }

}
