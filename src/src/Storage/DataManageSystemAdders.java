package Storage;

import Client.*;

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
        List l = loadClientsFile();
        if (l == null)
            l = new LinkedList<Client>();
        l.add(c);
        clientFile.write(clientFile.getDirectory(), l);
        return true;
    }

    public boolean addNewAdministrator(Administrator administrator){
        List l = loadAdministratorsFile();
        if (l == null){
            l = new LinkedList<Administrator>();
        }
        l.add(administrator);
        administratorFile.write(administratorFile.getDirectory(), l);
        return true;
    }

    public boolean addNewStarship(Starship starship){
        List l = loadStarshipsFile();
        if (l==null){
            l = new LinkedList<Starship>();
        }
        l.add(starship);
        starshipFile.write(starshipFile.getDirectory(), l);
        return true;
    }

    public boolean addNewOffer(Offer offer){
        List l = loadOffersFile();
        if (l==null){
            l = new LinkedList<Offer>();
        }
        l.add(offer);
        offerFile.write(offerFile.getDirectory(), l);
        return true;
    }

    public boolean addNewSale (Sale sale){
        List l = loadSalesFile();
        if (l==null){
            l = new LinkedList<Sale>();
        }
        l.add(sale);
        saleFile.write(saleFile.getDirectory(), l);
        return true;
    }

    public boolean addNewPirate (String s){
        List l = loadPiratesFile();
        if (l==null){
            l = new LinkedList<String>();
        }
        l.add(s);
        piratesFile.write(piratesFile.getDirectory(), l);
        return true;
    }

    public boolean addNewSwindler (String s){
        List l = loadSwindlerFile();
        if (l==null){
            l = new LinkedList<String>();
        }
        l.add(s);
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

    public boolean addNewComment(Comment comment){
        List l = loadCommentsFile();
        if (l == null){
            l = new LinkedList<>();
        }
        l.add(comment);
        commentFile.write(commentFile.getDirectory(), l);
        return true;
    }

    public boolean addNewUncheckedOffer(Offer uncheckedOffer){
        List l = loadUncheckedOfferFile();
        if (l==null){
            l = new LinkedList<Offer>();
        }
        l.add(uncheckedOffer);
        uncheckedOffersFile.write(uncheckedOffersFile.getDirectory(), l);
        return true;
    }
}
