package Storage;

import Client.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class DataManageSystem {

    //Properties
    protected ClientFile clientFile;
    protected OfferFile offerFile;
    protected SaleFile saleFile;
    protected AdministratorFile administratorFile;
    protected StarshipFile starshipFile;
    protected CommentFile commentFile;
    protected PiratesFile piratesFile;
    protected SwindlerFile swindlerFile;
    protected UncheckedOffersFile uncheckedOffersFile;

    //methods


    //load methods

    protected List loadClients(){
        return  clientFile.read(clientFile.getDirectory());
    }

    protected List loadOffers(){
        return  offerFile.read(offerFile.getDirectory());
    }

    protected List loadSales(){
        return  saleFile.read(saleFile.getDirectory());
    }

    protected List loadAdministrators(){
        return  administratorFile.read(administratorFile.getDirectory());
    }

    protected List loadStarships(){
        return  starshipFile.read(starshipFile.getDirectory());
    }

    protected List<String> loadComments(){
        return  commentFile.read(commentFile.getDirectory());
    }

    protected List<String> loadPirates(){
        return  piratesFile.read(piratesFile.getDirectory());
    }

    protected List<String> loadSwindler(){
        return  swindlerFile.read(swindlerFile.getDirectory());
    }

    protected List loadUncheckedOfferFile(){
        return  uncheckedOffersFile.read(uncheckedOffersFile.getDirectory());
    }


    //private functionality

    private boolean compareTypes(Offer o, String offerType) {
        //Pensar en implementar como son las ofertas por dentro para indicar tipos de nave
        return true;//o.getTypes()==offerType;
    }

    private boolean controlUsers(User c, List l){
        Iterator <User> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!found){
            User u = it.next();
            found = (u.getNick().equals(c.getNick())) && (u.getIdNumber().equals(c.getIdNumber()));
            //Comparator
        }
        return found;
    }


}
