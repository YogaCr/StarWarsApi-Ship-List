package id.sch.smktelkom_mlg.tugas02.xirpl338.swapiships;

/**
 * Created by Sakata Yoga on 06/02/2018.
 */

public class ShipClass {
    private String name;
    private String model;
    private String manufacture;
    private String ship_class;
    private String passenger;

    public ShipClass(String Name, String Model, String Manufacture, String Shipclass, String Passenger) {
        name = Name;
        model = Model;
        manufacture = Manufacture;
        ship_class = Shipclass;
        passenger = Passenger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setShip_class(String ship_class) {
        this.ship_class = ship_class;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }
}
