package Client;

import java.io.Serializable;
import java.time.LocalDate;


public class Sale implements Serializable {

    private String id;
    private LocalDate date;
    private String seller;
    private String buyer;
    private long cost;

    public String getId(String idOffer) { return id; }

    public void setId(String id) { this.id = id; }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
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
