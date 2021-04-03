package Controller;

import Client.*;
import Storage.*;

import java.util.List;

public class Controller {
    //Properties
    private DataManageSystemAdders adders;
    private DataManageSystemQueries queries;
    private DataManageSystemDelete delete;
    private DataManageSystemActualization actualization;
    private Identificators identificators;

    //Methods
    public User validate(String nick, String password){
        return queries.openSession(nick, password);
    }

    public String validateNick(String nick){
        if (!queries.validateNick(nick)){
            String output = identificators.getId(0);
            return output;
        }
        return null;
    }

    public void createUser(Client c){
        adders.addNewClient(c);
    }

    public void createStarship(Starship s){
        adders.addNewStarship(s);
    }

    public boolean validateRegisterNumber(String s){
        return queries.checkRegisterNumber(s);
    }

    public boolean addToUncheckedOffers(Offer offer){
        return adders.addNewUncheckedOffer(offer);
    }

    public boolean storeSale(Sale sale){
        return adders.addNewSale(sale);
    }

    public List<Client> getClientList(){
        return queries.loadClientsFile();
    }

    public void addPossiblePirate(String id){
        adders.addNewPirate(id);
    }

    public void addPossibleSwindler(String id){
        adders.addNewSwindler(id);
    }

    public List<String> getPirateList(){
        return queries.loadPiratesFile();
    }

    public void deletePossiblePirate(String id){
        delete.deletePirate(id);
    }

    public List<String> getSwindlerList(){
        return queries.loadSwindlers();
    }

    public void deletePossibleSwindler(String id){
        delete.deleteSwindler(id);
    }


        //No terminadas
        /*    public void addSubscription(String s){
                actualization.clientActualization(c);
            }
            public List<Comment> getCommentsList(){}
            public String getNotificationsList(){}
            public float getAverageValoration(){}*/
}
