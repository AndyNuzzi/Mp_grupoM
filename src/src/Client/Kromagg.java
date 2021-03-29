package Client;

public class Kromagg extends Client{

    private boolean license = false;

    public Kromagg(String name, String planet, String species, String idNumber, String nick, String password, String email, boolean license) {
        super(name, planet, species, idNumber, nick, password, email);
        this.license = license;
    }

    @Override
    public void doOperation() {

    }

    // al estar siempre a false, solo habra que pedirle si tiene licencia o no, y en caso de tener licencia lo ponemos
    // a true
    public void requestLicense (){
        // nos devuelve si tiene licencia o no
    }

}
