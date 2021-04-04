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


    //Methods

    protected List loadClientsFile(){
        return  clientFile.read(clientFile.getDirectory());
    }

    protected List loadOffersFile(){
        return  offerFile.read(offerFile.getDirectory());
    }

    protected List loadSalesFile(){
        return  saleFile.read(saleFile.getDirectory());
    }

    protected List loadAdministratorsFile(){
        return  administratorFile.read(administratorFile.getDirectory());
    }

    protected List loadStarshipsFile(){
        return  starshipFile.read(starshipFile.getDirectory());
    }

    protected List<Comment> loadCommentsFile(){
        return  commentFile.read(commentFile.getDirectory());
    }

    protected List<String> loadPiratesFile(){
        return  piratesFile.read(piratesFile.getDirectory());
    }

    protected List<String> loadSwindlerFile(){
        return  swindlerFile.read(swindlerFile.getDirectory());
    }

    protected List loadUncheckedOfferFile(){
        return  uncheckedOffersFile.read(uncheckedOffersFile.getDirectory());
    }

}
