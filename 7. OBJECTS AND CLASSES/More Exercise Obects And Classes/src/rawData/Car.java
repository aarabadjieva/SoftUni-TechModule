package rawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyres tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyres tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tyres getTyres() {
        return tyres;
    }
}
