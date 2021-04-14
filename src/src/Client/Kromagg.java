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
        return license;
    }

    /**
     * Se encarga de meter las operaciones del cliente en la lista, y luego llamará al elegir operaciones
     */
    @Override
    public void doOperation() {
        ClientOperation op1 = new CreateOffer(this);
        ClientOperation op2 = new SearchKromaggOffer(this);
        ClientOperation op3 = new CheckValoration(this);
        ClientOperation op4 = new CheckNotifications(this);
        ClientOperation op5 = new CheckComments(this);
        ClientOperation op6 = new Subscribe(this);
        ClientOperation op7 = new CancelSubscription(this);
        super.operations.add(op1);
        super.operations.add(op2);
        super.operations.add(op3);
        super.operations.add(op4);
        super.operations.add(op5);
        super.operations.add(op6);
        super.operations.add(op7);
        super.getOperation();
    }

}
