package Countries;


import java.io.Serializable;

public abstract class State implements Serializable {
    private String name = "";
    private String capital = "";
    private int population = 0;

    State(String name, String capital, int population) {
        setName(name);
        setCapital(capital);
        setPopulation(population);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        if (capital == null || capital.trim().isEmpty()) {
            throw new IllegalArgumentException("Capital cannot be null or empty");
        }
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if (population <= 0) {
            throw new IllegalArgumentException("Population cannot be negative or zero");
        }
        this.population = population;
    }

    abstract void goveremnt() throws Exception;
    abstract void collectTaxes() throws Exception;
    abstract void getDetails() throws Exception;
}