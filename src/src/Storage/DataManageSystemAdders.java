package Storage;

import Client.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataManageSystemAdders extends DataManageSystem {

    //Properties
    private static DataManageSystemAdders dataManageSystem;


    //Singleton
    private DataManageSystemAdders(){
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

    public static DataManageSystemAdders getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystemAdders();
        return dataManageSystem;
    }


    //Methods

    public boolean addNewClient(Client c){
        //Adds a client in clients' file
        List l = loadClientsFile();
        if (l == null)
            l = new LinkedList<Client>();
        l.add(c);
        clientFile.write(clientFile.getDirectory(), l);
        return true;
    }

    public boolean addNewAdministrator(Administrator administrator){
        //Adds an administrator in administrators' file
        List l = loadAdministratorsFile();
        if (l == null){
            l = new LinkedList<Administrator>();
        }
        l.add(administrator);
        administratorFile.write(administratorFile.getDirectory(), l);
        return true;
    }

    public boolean addNewStarship(Starship starship){
        //Adds a Starship in satrships' file
        List l = loadStarshipsFile();
        if (l==null){
            l = new LinkedList<Starship>();
        }
        l.add(starship);
        starshipFile.write(starshipFile.getDirectory(), l);
        return true;
    }

    public boolean addNewOffer(Offer offer){
        //Adds an offer in offers' file
        List l = loadOffersFile();
        if (l==null){
            l = new LinkedList<Offer>();
        }
        l.add(offer);
        offerFile.write(offerFile.getDirectory(), l);
        return true;
    }

    public boolean addNewSale (Sale sale){
        //Adds a sale in sales' file
        List l = loadSalesFile();
        if (l==null){
            l = new LinkedList<Sale>();
        }
        l.add(sale);
        saleFile.write(saleFile.getDirectory(), l);
        return true;
    }

    public boolean addNewPirate (String s){
        //Adds a pirate in pirates' file
        List l = loadPiratesFile();
        if (l==null){
            l = new LinkedList<String>();
            l.add(s);
            piratesFile.write(piratesFile.getDirectory(), l);
        }
        else if (!contains(l, s)) {
            l.add(s);
            piratesFile.write(piratesFile.getDirectory(), l);
        }
        return true;
    }

    private boolean contains(List<String> l, String s) {
        //Checks if a string is in the list given
        Iterator<String> it = l.iterator();
        boolean found = false;
        while (!found&&it.hasNext()){
            String c = it.next();
            found = c.equals(s);
        }
        return found;
    }

    public boolean addNewSwindler (String s){
        //Adds a swindler to swindlers' file
        List l = loadSwindlerFile();
        if (l==null){
            l = new LinkedList<String>();
            l.add(s);
            swindlerFile.write(swindlerFile.getDirectory(), l);
        }
        else if (!contains(l, s)) {
            l.add(s);
            swindlerFile.write(swindlerFile.getDirectory(), l);
        }
        return true;
    }

    public boolean addNewComment(Comment comment){
        //Adds a comment to comments' file
        List l = loadCommentsFile();
        if (l == null){
            l = new LinkedList<>();
        }
        l.add(comment);
        commentFile.write(commentFile.getDirectory(), l);
        return true;
    }

    public boolean addNewUncheckedOffer(Offer uncheckedOffer){
        //Adds an offer to unchecked offers' file
        List l = loadUncheckedOfferFile();
        if (l==null){
            l = new LinkedList<Offer>();
        }
        l.add(uncheckedOffer);
        uncheckedOffersFile.write(uncheckedOffersFile.getDirectory(), l);
        return true;
    }

    public void newOffers(List<Offer> l){
        offerFile.write(offerFile.getDirectory(), l);
    }

}
