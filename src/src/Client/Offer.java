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
}
