package Client;

import java.io.Serializable;

public abstract class User implements Serializable {

    protected String name;
    protected String planet;
    protected String species;
    protected String nick;
    protected String idNumber;
    protected String password;
    protected String email;

    public User(String name, String planet, String species, String idNumber, String nick,  String password, String email) {
        this.name = name;
        this.planet = planet;
        this.species = species;
        this.nick = nick;
        this.idNumber = idNumber;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPlanet() {
        return planet;
    }

    public String getSpecies() {
        return species;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public abstract void doOperation();
}
