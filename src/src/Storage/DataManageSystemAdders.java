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
        List l = loadClients();
        if (l == null)
            l = new LinkedList<Client>();
        l.add(c);
        clientFile.write(clientFile.getDirectory(), l);
        return true;
    }

    public boolean addNewAdministrator(Administrator administrator){
        List l = loadAdministrators();
        if (l == null){
            l = new LinkedList<Administrator>();
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
        l.add(starship);
        starshipFile.write(starshipFile.getDirectory(), l);
        return true;
    }

    public boolean addNewOffer(Offer offer){
        List l = loadOffers();
        if (l==null){
            l = new LinkedList<Offer>();
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
        l.add(sale);
        saleFile.write(saleFile.getDirectory(), l);
        return true;
    }

    public boolean addNewPirate (Client c){
        List l = loadPirates();
        if (l==null){
            l = new LinkedList<String>();
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
        l.add(c.getIdNumber());
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

    public boolean addNewComment(Comment comment){
        List l = loadComments();
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
