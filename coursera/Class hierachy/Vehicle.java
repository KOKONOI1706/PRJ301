abstract class Vehicle {
    String registration;
    Engine engine;

    public Vehicle(String registration, Engine engine) {
        this.registration = registration;
        this.engine = engine;
    }

    public abstract void startEngine();

}

protected class Engine {
    String engineType;
    double capacity;

    void getEngineDetails() {
        System.out.println("Type: " + this.engineType);
    }

}

abstract class Car extends Vehicle {
    String make;
    String model;
    String color;
    int year;

    Car(String registration, Engine engine) {
        super(registration, engine);
    }

    abstract String getColor();

    abstract String getModel();

    public void getYear(int year) {
        this.year = year;
    }

    public String getDetails() {
        return "Car with " + this.registration + "model :" + this.model + "year of " +
                "Mfg: " + this.year;
    }

}

Class Sedan extends

Car {
    int doors;
    @Override
    String getColor(){
        return this.color;
    }
    @Override
    String getModel(){
        return this.model;
    }
    @Override
    public  void startEngine(){
        System.out.println("Sedan with" + this.getDetails() + "Engine started");
    }

}