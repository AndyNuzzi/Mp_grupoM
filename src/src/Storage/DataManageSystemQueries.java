package Storage;

import Client.*;

import java.util.*;

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
        if (l != null) {
            Iterator<Client> it = l.iterator();
            boolean chosen = false;
            String id = "";
            while (it.hasNext() && !chosen) {
                Client c = it.next();
                chosen = nick.equals(c.getNick());
            }
            if (!chosen) {
                List<Administrator> lAdm = loadAdministratorsFile();
                Iterator<Administrator> itAd = lAdm.iterator();
                while (itAd.hasNext() && !chosen) {
                    Administrator admin = itAd.next();
                    chosen = nick.equals(admin.getNick());
                }
            }
            return chosen;
        }
        return false;
    }

    public List<Offer> searchOffers (String offerType, String id){
        List<Offer> l = loadOffersFile();
        if (l!=null){
            List <Offer> sol = new LinkedList<>();
            for (Offer o: l){
                if (o.checkType(offerType)&& !o.getCreator().equals(id)){
                    sol.add(o);
                }
            }
            return sol;
        }
        return null;
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
        if (l!=null) {
            Iterator<Comment> it = l.iterator();
            while (it.hasNext()) {
                Comment c = it.next();
                if (c.getIdSeller().equals(idClient))
                    output.add(c);
            }
        }
        return output;
    }

    public float getValoration(String id){
        //Calculates the average valoration of a client
        List<Comment> commentList = getComments(id);
        int val = 0;
        int i = 0;
        if (commentList.size()>0) {
            for (Comment c : commentList) {
                val += c.getValoration();
                i++;
            }
            return val / i;
        }
        else return 0;
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
        if (l != null) {
            Iterator<Starship> it = l.iterator();
            boolean found = false;
            while (it.hasNext() && !found) {
                Starship starship = it.next();
                if (starship.getRegisterNumber().equals(id))
                    found = true;
            }
            return !found;
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

    public List<Starship> getStarships(List<String> ids){
        Collections.sort(ids);
        List<Starship> starshipList = loadStarshipsFile();
        List<Starship> sol = new ArrayList<Starship>();
        if (starshipList!=null){
            Iterator<Starship> iterator = starshipList.iterator();
            String id = ids.remove(0);
            while (iterator.hasNext() && !ids.isEmpty()){
                Starship next = iterator.next();
                if (next.getRegisterNumber().equals(id)){
                    sol.add(next);
                    id = ids.remove(0);
                }
            }
        }
        return sol;
    }
}
