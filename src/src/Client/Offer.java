package Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Offer implements Serializable {

    private String id;
    private List<String> starshipIdList = new ArrayList<>();
    private Date dateEnd;
    private long price;
    private String creator;
    private boolean [] type = new boolean [4];
    // type[0] = SpaceStation
    // type[1] = Destroyer
    // type[2] = Freighter
    // type[3] = Fighter

    public Offer() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getStarshipIdList() {
        return starshipIdList;
    }

    public void setStarshipIdList(List<String> starshipIdList) {
        this.starshipIdList = starshipIdList;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean[] getType() {
        return type;
    }

    public boolean checkType(String type){
        type = type.toLowerCase();
        switch (type){
            case "spacestation":
                return this.type[0];
            case "destroyer":
                return this.type[1];
            case "freighter":
                return this.type[2];
            case "fighter":
                return this.type[3];
            default:
                return false;
        }
    }

    public void setType(int i) {
        this.type[i] = true;
    }

    public boolean addStarshipToOffer(Starship starship){
        starshipIdList.add(starship.getRegisterNumber());
        if (!starship.getClass().getSimpleName().equals("SpaceStation")){
            SpaceStation sp = (SpaceStation) starship;
            List<Starship> starshipList = sp.getStarships();
            for (Starship s: starshipList){
                starshipIdList.add(s.getRegisterNumber());
                switch (s.getClass().getSimpleName()){
                    case "SpaceStation": type[0] = true;
                    break;
                    case "Destroyer": type[1] = true;
                    break;
                    case "Freighter": type[2] = true;
                    break;
                    case "Fighter": type[3] = true;
                    break;
                }
            }
        }
        return true;
    }

    public Offer finish(){
        return this;
    }


}
