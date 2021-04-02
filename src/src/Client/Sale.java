package Client;

import java.io.Serializable;
import java.util.Date;
import Controller.*;

public class Sale implements Serializable {

    private Date date;
    private Client seller;
    private Client buyer;
    private long cost;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getSeller() {
        return seller;
    }

    public void setSeller(Client seller) {
        this.seller = seller;
    }

    public Client getBuyer() {
        return buyer;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Sale buy(){
        return this;
    }
}
