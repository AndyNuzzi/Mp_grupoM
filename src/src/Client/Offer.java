package Client;

import java.util.Date;
import java.util.List;
import Controller.*;

public class Offer {

    private List<String> starshipIdList;
    private Date dateEnd;
    private long price;
    private String creator;
    private String id;

    public Offer() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean addStarshipToOffer(Starship starship){
        starshipIdList.add(starship.getRegisterNumber());
        return true;
    }

    public boolean addStarshipToOffer(SpaceStation spaceStation){
        starshipIdList.add(spaceStation.getRegisterNumber());
        List <Starship> starshipList = spaceStation.getStarships();
        for (Starship s:starshipList){
            starshipIdList.add(s.getRegisterNumber());
        }
        return true;
    }

    public boolean finish(){

        return addToUncheckedOffers();
    }

}
