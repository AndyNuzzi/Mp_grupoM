package Storage;

import Client.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataManageSystemQueries extends DataManageSystem{

    //Properties
    private static DataManageSystemQueries dataManageSystem;


    //Singleton
    private DataManageSystemQueries(){
        clientFile = ClientFile.getInstance();
        offerFile = OfferFile.getInstance();
        saleFile = SaleFile.getInstance();
        administratorFile = AdministratorFile.getInstance();
        starshipFile = StarshipFile.getInstance();
        commentFile = CommentFile.getInstance();
        piratesFile = PiratesFile.getInstance();
        swindlerFile = SwindlerFile.getInstance();
        uncheckedOffersFile = UncheckedOffersFile.getInstance();
    }

    public static DataManageSystemQueries getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystemQueries();
        return dataManageSystem;
    }


    //Methods
    public String validateNick(String nick){
        //Checks if nick is used and provides de Id for the new client.
        List<Client> l = loadClients();
        Iterator<Client> it = l.iterator();
        boolean chosen = false;
        String id ="";
        while (it.hasNext()&&!chosen){
            Client c = it.next();
            id = c.getIdNumber();
            chosen = nick.equals(c.getNick());
        }
        if (!chosen){
            int i = Integer.parseInt(id) + 1;
            return Integer.toString(i);
        }
        return null;
    }

    public List<Offer> searchOffers (String offerType){
        List l = loadOffers();
        List <Offer> sol = new LinkedList<>();
        for (Object obj: l){
            Offer o = (Offer) obj;
            if (compareTypes(o, offerType)){
                sol.add(o);
            }
        }
        return sol;
    }

    public User openSession(String nick, String password){
        List clientList = loadClients();
        User c = search(clientList, nick, password);
        if (c==null){
            List administratorList = loadAdministrators();
            c = search(administratorList, nick, password);
        }
        else{
            List swindlerList = loadSwindler();
            boolean swindler = false;
            if (swindlerList != null)
                swindler = control(swindlerList, c.getIdNumber());
            List piratesList = loadPirates();
            boolean pirate = false;
            if (piratesList != null)
                pirate = control(piratesList, c.getIdNumber());
            if (swindler){
                return null;
            }
        }
        return c;
    }
}
