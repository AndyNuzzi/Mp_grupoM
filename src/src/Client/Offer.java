package Client;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Offer implements Serializable {

    private String id;
    private List<String> starshipIdList = new ArrayList<>();
    private LocalDate dateEnd;
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

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
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

    public List<String> getType() {
        List<String> l = new ArrayList<>();
        for (int i = 0; i <= 3; i++){
            if (type[i])
                switch (i) {
                    case 0 : l.add("SpaceStation");
                    break;
                    case 1: l.add("Destroyer");
                    break;
                    case 2: l.add("Freighter");
                    break;
                    case 3: l.add("Fighter");
                    break;
                }
        }
        return l;
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
        if (starship.getClass().getSimpleName().equals("SpaceStation")){
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
