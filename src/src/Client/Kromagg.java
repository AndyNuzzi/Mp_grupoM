package Client;

import java.io.Serializable;

public class Kromagg extends Client implements Serializable {

    private boolean license;

    /**
     * Constructor con todos los parámetros
     *
     * @param name
     * @param planet
     * @param species
     * @param idNumber
     * @param nick
     * @param password
     * @param email
     * @param license
     */
    public Kromagg(String name, String planet, String species, String idNumber, String nick, String password, String email, boolean license) {
        super(name, planet, species, idNumber, nick, password, email);
        this.license = license;
    }

    /**
     * Preguntamos al controller si tiene licencia o no
     *
     * @return
     */
    public boolean requestLicense() {
        // nos devuelve si tiene licencia o no
        return false;
    }

}
