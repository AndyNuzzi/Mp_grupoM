package Client;

import java.util.*;

public class Client extends User{

    private List<Offer> onSale = new ArrayList<Offer>();
    private boolean pirate;
    private List <String> subscription = new LinkedList<String>();
    private int additionVote;
    private int interactions;
    // preguntar de donde es el import si de sql o de java util
    private Date banned;
    private boolean warning;
    private List <ClientOperation> operations = new LinkedList<ClientOperation>();

    public Client(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    @Override
    public void setOption() {
        // suponemos que tenemos en la clase User List <Operations>
        // creamos todas las operaciones
        // y las añadimos
    }


}
