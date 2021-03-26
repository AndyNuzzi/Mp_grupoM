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

    private User search(List<Object> list, String nick, String password){
        int i = 0;
        boolean found = false;
        User u = null;
        while (!found && i < list.size()){
            u = (User) list.get(i);
            String nick_search = u.getNick();
            String password_search = u.getPassword();
            if (nick.equals(nick_search) && password.equals(password_search))
                found = true;
            i++;
        }
        if (!found){
            return null;
        }
        return u;
    }

    private boolean control(List l, String id){
        return l.contains(id);
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
            boolean swindler = control(swindlerList, c.getIdNumber());
            List piratesList = loadPirates();
            if (swindler){
                return null;
            }
        }
        return c;
    }

    public boolean addNewClient(Client c){
        List l = loadClients();
        if (l == null)
            l = new LinkedList<Client>();
        else{
            //Implementar logica de control de identificador y nick unicos
        }
        l.add(c);
        clientFile.write(clientFile.getDirectory(), l);
        return true;
    }

    public boolean addNewAdministrator(Administrator administrator){
        List l = loadAdministrators();
        if (l == null){
            l = new LinkedList<Administrator>();
        }
        else{
            //Implementar logica de control de identificador y nick unicos
        }
        l.add(administrator);
        administratorFile.write(administratorFile.getDirectory(), l);
        return true;
    }
}
