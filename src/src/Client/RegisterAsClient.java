package Client;

public class RegisterAsClient extends LogIn {

    @Override
    public void doOperation() {
        User usuario = this.createUser();
        // y ahora ya mostraremos el menu y con ello seguiran las siguientes operaciones
    }

    @Override
    public User createUser() {
        System.out.println("");
        String email = super.askForEmail();
        String password = super.askForPassword();
        Boolean existingUser = this.validate(email, password);
        User usuario;
        if (existingUser) {
            // lo recuperamos de la base de datos
            usuario = null;
        } else {
            String name = super.askForName();
            String planet = super.askForPlanet();
            String species = super.askForSpecies();
            String idNumber = super.assignId();
            String nick = super.askForNick();
            usuario = new Client (name, planet, species, idNumber, nick, password, email);
            // y lo guardamos en la base de datos
        }
        return usuario;
    }

    @Override
    protected Boolean validate(String email, String password) {
        // aqui hay que acceder a la base de datos para ver si coincide
        return true;
    }
}
