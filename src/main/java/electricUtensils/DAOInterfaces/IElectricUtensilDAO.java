package electricUtensils.DAOInterfaces;

import electricUtensils.Entity.ElectricUtensil;

import java.util.List;

public interface IElectricUtensilDAO {
    void add(ElectricUtensil e);

    void deleteByID(ElectricUtensil e);

    List<ElectricUtensil> getAll();
    List<ElectricUtensil> sortByPower();

    List<ElectricUtensil> getUtensilByPower (int power);
    List<ElectricUtensil> getUtensilInPowerRange (int minPower, int maxPower);
    int totalPowerConsumption();

    void plugIn(String name);
    void unplug(String name);
}
