package Client;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Offer implements Serializable {
    private List<Starship> starships;
    private Date end;
    private long price;
    private String creator;
    private String id;

    public Offer(List<Starship> starships, Date end, long price, String creator, String id) {
        this.starships = starships;
        this.end = end;
        this.price = price;
        this.creator = creator;
        this.id = id;
    }

    public List<Starship> getStarships() {
        return starships;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
}
