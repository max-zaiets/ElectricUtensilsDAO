package electricUtensils.Entity;

public class ElectricUtensil  {
    private int id;
    private String name;
    private int powerConsumption;

    private boolean isPluggedIn = false;

    public ElectricUtensil(int id, String name, int powerConsumption, boolean isPluggedIn) {
        this.id = id;
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.isPluggedIn = isPluggedIn;
    }

    public ElectricUtensil(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public void setPluggedIn(boolean pluggedIn) {
        isPluggedIn = pluggedIn;
    }

    @Override
    public String toString() {
        return "ElectricUtensil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", isPluggedIn=" + isPluggedIn +
                '}';
    }
}
