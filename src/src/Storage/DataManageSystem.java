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

    //methods

    //singleton
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

    //load methods

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

    //add objects in files

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

    public boolean addNewStarship(Starship starship){
        List l = loadStarships();
        if (l==null){
            l = new LinkedList<Starship>();
        }
        else{
            //Implementar logica de control de nave unica
        }
        l.add(starship);
        starshipFile.write(starshipFile.getDirectory(), l);
        return true;
    }

    public boolean addNewOffer(Offer offer){
        List l = loadOffers();
        if (l==null){
            l = new LinkedList<Offer>();
        }
        else{
            //Implementar logica de oferta con id unico
        }
        l.add(offer);
        offerFile.write(offerFile.getDirectory(), l);
        return true;
    }

    public boolean addNewSale (Sale sale){
        List l = loadSales();
        if (l==null){
            l = new LinkedList<Sale>();
        }
        else{
            //Implementar logica de venta con id unico
        }
        l.add(sale);
        saleFile.write(saleFile.getDirectory(), l);
        return true;
    }

    public boolean addNewPirate (Client c){
        List l = loadPirates();
        if (l==null){
            l = new LinkedList<String>();
        }
        else{
            //Lógica de que es unico
        }
        l.add(c.getIdNumber());
        piratesFile.write(piratesFile.getDirectory(), l);
        return true;
    }

    public boolean addNewSwindler (Client c){
        List l = loadSwindler();
        if (l==null){
            l = new LinkedList<String>();
        }
        else{
            //Lógica de que es unico
        }
        l.add(c.getIdNumber());
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

    //public boolean addNewComment(Comment)

    //public boolean addNewUncheckedOffer(UncheckedOffers)

    //delete objects in files

    public boolean deleteOffer(Offer offer) {
        List l = loadOffers();
        l.remove(offer);
        offerFile.write(offerFile.getDirectory(), l);
    }

    public boolean deletePirate(String id){
        List l = loadPirates();
        l.remove(id);
        piratesFile.write(piratesFile.getDirectory(), l);
        return true;
    }

    public boolean deleteSwindler(String id){
        List l = loadSwindler();
        l.remove(id);
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

    //query methods

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
            boolean swindler = control(swindlerList, c.getIdNumber());
            List piratesList = loadPirates();
            if (swindler){
                return null;
            }
        }
        return c;
    }


    //private functionality

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

    private boolean compareTypes(Offer o, String offerType) {
        //Pensar en implementar como son las ofertas por dentro para indicar tipos de nave
        return o.getTypes()==offerType;
    }





}
