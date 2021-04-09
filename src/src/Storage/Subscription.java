package Storage;

import Client.Client;
import Client.Notification;

import java.io.Serializable;
import java.util.List;

public class Subscription implements Serializable {
    private List<String> spaceStationList;
    private List<String> destroyerList;
    private List<String> freighterList;
    private List<String> fighterList;


    public Subscription(List<String> lsp, List<String> ld, List<String> lfr, List<String> lfg){
        this.spaceStationList = lsp;
        this.destroyerList = ld;
        this.freighterList = lfr;
        this.fighterList = lfg;
    }

    public boolean addSubscription(String id, String option){
        switch (option){
            case "SpaceStation": spaceStationList.add(id);
            break;
            case "Destroyer": destroyerList.add(id);
            break;
            case "Freighter": freighterList.add(id);
            break;
            case "Fighter": fighterList.add(id);
            break;
        }
        SubscriptionFile subscriptionFile = SubscriptionFile.getInstance();
        subscriptionFile.write(this);
        return true;
    }

    public void notifySubscriber(String id, String message, DataManageSystemActualization actualization, DataManageSystemQueries queries){
        Client client = queries.getClient(id);
        Notification notification = new Notification(message);
        client.addNotification(notification);
        actualization.clientActualization(client);
    }

    public void notifySubscribers(List<String> type, String message, DataManageSystemActualization actualization, DataManageSystemQueries queries) {
        for (String s: type) {
            switch (s) {
                case "SpaceStation":
                    for(String c : spaceStationList){
                        notifySubscriber(c, message, actualization, queries);
                    }
                    break;
                case "Destroyer":
                    for(String c : destroyerList){
                        notifySubscriber(c, message, actualization, queries);
                    }
                    break;
                case "Freighter":
                    for(String c : freighterList){
                        notifySubscriber(c, message, actualization, queries);
                    }
                    break;
                case "Fighter":
                    for(String c : fighterList){
                        notifySubscriber(c, message, actualization, queries);
                    }
                    break;
            }
        }
    }

}
