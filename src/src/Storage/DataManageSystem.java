package Storage;

import Client.*;

import java.util.LinkedList;
import java.util.List;

public class DataManageSystem {

    //Properties
    private static DataManageSystem dataManageSystem;
    private ClientFile clientFile;
    private OfferFile offerFile;
    private SaleFile saleFile;
    private AdministratorFile administratorFile;
    private StarshipFile starshipFile;
    private CommentFile commentFile;
    private PiratesFile piratesFile;
    private SwindlerFile swindlerFile;
    private UncheckedOffersFile uncheckedOffersFile;

    //Methods
    private DataManageSystem(){
        clientFile = new ClientFile();
        offerFile = new OfferFile();
        saleFile = new SaleFile();
        administratorFile = new AdministratorFile();
        starshipFile = new StarshipFile();
        commentFile = new CommentFile();
        piratesFile = new PiratesFile();
        swindlerFile = new SwindlerFile();
        uncheckedOffersFile = new UncheckedOffersFile();
    }

    public static DataManageSystem getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystem();
        return dataManageSystem;
    }

    private List loadClients(){
        return  clientFile.read(clientFile.getDirectory());
    }

    private List loadOffers(){
        return  offerFile.read(offerFile.getDirectory());
    }

    private List loadSales(){
        return  saleFile.read(saleFile.getDirectory());
    }

    private List loadAdministrators(){
        return  administratorFile.read(administratorFile.getDirectory());
    }

    private List loadStarships(){
        return  starshipFile.read(starshipFile.getDirectory());
    }

    private List loadComments(){
        return  commentFile.read(commentFile.getDirectory());
    }

    private List<String> loadPirates(){
        return  piratesFile.read(piratesFile.getDirectory());
    }

    private List<String> loadSwindler(){
        return  swindlerFile.read(swindlerFile.getDirectory());
    }

    private List loadUncheckedOfferFile(){
        return  uncheckedOffersFile.read(uncheckedOffersFile.getDirectory());
    }

    private Client search(List<Object> list, String nick, String password){
        int i = 0;
        boolean found = false;
        Client c = null;
        while (!found && i < list.size()){
            c = (Client) list.get(i);
            String nick_search = c.getNick();
            String password_search = c.getPassword();
            if (nick.equals(nick_search) && password.equals(password_search))
                found = true;
            i++;
        }
        return c;
    }

    private boolean control(List l, String id){
        return l.contains(id);
    }

    public Client openSession(String nick, String password){
        List clientList = loadClients();
        Client c = search(clientList, nick, password);
        List swindlerList = loadSwindler();
        boolean swindler = control(swindlerList, c.getIdNumber());
        List piratesList = loadPirates();
        boolean pirate = control(piratesList, c.getIdNumber());
        if (swindler){
            return null;
        }
        else if (pirate){
            c.setPirate(true);
        }
        else
            c.setPirate(false);
        return c;
    }

    public boolean addNewClient(Client c){
        List l = loadClients();
        if (l == null)
            l = new LinkedList<Client>();
        l.add(c);
        clientFile.write(clientFile.getDirectory(), l);
        return true;
    }
}
