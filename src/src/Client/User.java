package Client;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class User implements Serializable {

    protected String name;
    protected String planet;
    protected String species;
    protected String nick;
    protected String idNumber;
    protected String nick;
    protected String password;
    protected String email;


    protected List<Operation> operations = new ArrayList<Operation>();

    // mirar comparator
    // ya hecha serializable

    public User(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        this.name = name;
        this.planet = planet;
        this.species = species;
        this.idNumber = idNumber;
        this.nick = nick;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    private boolean isClientOperation (Operation operation){
        String operationClass = operation.getClass().getSimpleName();
        return operationClass.equals("CreateOffer") || operationClass.equals("SearchOffer") || operationClass.equals("Subscribe") ||
        operationClass.equals("CheckNotifications") || operationClass.equals("CheckComments") || operationClass.equals("CheckValoration");
    }

    public void getOperation() {
        int option;
        do {
            System.out.println(" Select an operation ");
            for (int i = 0; i < this.operations.size(); i++) {
                System.out.println(i + ". " + operations.get(i).getClass().getSimpleName());
            }
            System.out.println("6. Exit ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option < 6 && option >= 0){
                Operation operation = this.operations.get(option);
                if (isClientOperation(operation)){
                    ClientOperation clientOperation = (ClientOperation) operation;
                    clientOperation.doOperation();
                } else {
                    AdministratorOperation administratorOperation = (AdministratorOperation) operation;
                    operation.doOperation();
                }
            } else {
                System.out.println(" Wrong option ");
            }
        } while (option != 6);

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
