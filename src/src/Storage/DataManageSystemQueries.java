package Storage;

import Client.*;

import java.util.ArrayList;
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
    public boolean validateNick(String nick){
        //Checks if nick is used
        List<Client> l = loadClientsFile();
        Iterator<Client> it = l.iterator();
        boolean chosen = false;
        String id ="";
        while (it.hasNext()&&!chosen){
            Client c = it.next();
            chosen = nick.equals(c.getNick());
        }
        if (!chosen){
            List<Administrator> lAdm = loadAdministratorsFile();
            Iterator<Administrator> itAd = lAdm.iterator();
            while (itAd.hasNext()&&!chosen){
                Administrator admin = itAd.next();
                chosen = nick.equals(admin.getNick());
            }
        }
        return chosen;
    }

    public List<Offer> searchOffers (String offerType){
        List l = loadOffersFile();
        List <Offer> sol = new LinkedList<>();
        for (Object obj: l){
            Offer o = (Offer) obj;
            if (true){//(compareTypes(o, offerType)){
                sol.add(o);
            }
        }
        return sol;
    }

    public User openSession(String nick, String password){
        //Opens a session of a User
        List clientList = loadClientsFile();
        User c = search(clientList, nick, password);
        if (c==null){
            List administratorList = loadAdministratorsFile();
            c = search(administratorList, nick, password);
        }
        else{
            List swindlerList = loadSwindlerFile();
            boolean swindler = false;
            if (swindlerList != null){
                swindler = check(swindlerList, c.getIdNumber());
                if (swindler)
                    return null;
            }
            List piratesList = loadPiratesFile();
            boolean pirate = false;
            if (piratesList != null){
                pirate = check(piratesList, c.getIdNumber());
                if (pirate) {
                    //c.setPirate();
                    return c;
                }
            }
        }
        return c;
    }

    public List<Comment> getComments(String idClient){
        //Returns a comments' list of a specific client
        List<Comment> l = loadCommentsFile();
        List<Comment> output = new ArrayList<Comment>();
        Iterator <Comment> it = l.iterator();
        while (it.hasNext()){
            Comment c = it.next();
            if (c.getIdSeller().equals(idClient))
                output.add(c);
        }
        return output;
    }

    public float getValoration(String id){
        //Calculates the average valoration of a client
        List<Comment> commentList = getComments(id);
        int val = 0;
        int i = 0;
        for (Comment c: commentList){
            val += c.getValoration();
            i++;
        }
        return val/i;
    }

    private boolean check(List<String> l, String idNumber) {
        //Checks if a string is in the list passed
        Iterator<String> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!false){
            String str = it.next();
            found = str.equals(idNumber);
        }
        return found;
    }

    private User search(List<User> list, String nick, String password){
        //Returns the User logged
        Iterator<User> it = list.listIterator();
        boolean found = false;
        User u = null;
        while (it.hasNext()&&!found){
            u = (User) it.next();
            found = u.getNick().equals(nick) && u.getPassword().equals(password);
        }
        if (!found){
            return null;
        }
        return u;
    }

    public List<Client> loadClients(){
        //Returns clients' list
        return loadClientsFile();
    }

    public List<String> loadPirates(){
        //Returns pirates' list
        return loadPiratesFile();
    }

    public List<String> loadSwindlers(){
        //Returns swindlers' list
        return loadSwindlerFile();
    }

    public boolean checkRegisterNumber(String id){
        //Checks if a register number has been used before
        List<Starship> l = loadStarshipsFile();
        Iterator<Starship> it = l.iterator();
        boolean found = false;
        while(it.hasNext()&&!found){
            Starship starship = it.next();
            if (starship.getRegisterNumber().equals(id))
                found = true;
        }
        return true;
    }

    public List<Offer> loadUncheckedOffers(){
        //Returns a list of unchecked offers
        return loadUncheckedOfferFile();
    }

    public Client getClient(String id) {
        //Returns a client with IdNumber = id
        List clientList = loadClientsFile();
        return search(clientList, id);
    }

    private Client search(List clientList, String id) {
        //Returns a client searched by its id
        Iterator<User> it = clientList.iterator();
        boolean found = false;
        Client c = null;
        while (it.hasNext()&&!found){
            c = (Client) it.next();
            found = c.getIdNumber().equals(id);
        }
        return c;
    }
}
