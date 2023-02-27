package electricUtensils;

import electricUtensils.DAO.DAOFactory;
import electricUtensils.DAO.ElectricUtensilDAO;
import electricUtensils.DAOInterfaces.IDAOFactory;
import electricUtensils.Entity.ElectricUtensil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDAOFactory idaoFactory = DAOFactory.getInstance();
        ElectricUtensilDAO applianceDAO = idaoFactory.getDAO();
        ElectricUtensil computer = new ElectricUtensil("computer", 250);
        ElectricUtensil dishWasher = new ElectricUtensil("dishWasher", 2500);
        ElectricUtensil kettle = new ElectricUtensil("kettle", 2000);
        ElectricUtensil stove = new ElectricUtensil("stove", 7000);
        ElectricUtensil fridge = new ElectricUtensil("fridge", 300);
        ElectricUtensil iron = new ElectricUtensil("iron", 2000);
        ElectricUtensil tv = new ElectricUtensil("tv", 150);
        ElectricUtensil washer = new ElectricUtensil("washer", 1500);

        applianceDAO.add(computer);
        applianceDAO.add(dishWasher);
        applianceDAO.add(kettle);
        applianceDAO.add(stove);
        applianceDAO.add(fridge);
        applianceDAO.add(iron);
        applianceDAO.add(tv);
        applianceDAO.add(washer);

        System.out.println((char) 27 + "[34m" + "All electric appliances in the house:" + (char) 27 + "[38m");
        List<ElectricUtensil> list = applianceDAO.getAll();
        for (ElectricUtensil temp : list) System.out.println(temp);

        System.out.println((char) 27 + "[34m" + "\nTurn on some appliances:" + (char) 27 + "[38m");
        applianceDAO.plugIn("computer");
        applianceDAO.plugIn("stove");
        applianceDAO.plugIn("iron");
        applianceDAO.plugIn("fridge");
        applianceDAO.unplug("fridge");
        list = applianceDAO.getAll();
        for (ElectricUtensil temp : list) System.out.println(temp);

        System.out.println((char) 27 + "[34m" + "\nPower consumption: " + (char) 27 + "[38m" + applianceDAO.totalPowerConsumption());

        System.out.println((char) 27 + "[34m" + "\nSorted by power: " + (char) 27 + "[38m");
        list = applianceDAO.sortByPower();
        for (ElectricUtensil temp : list) System.out.println(temp);

        System.out.println((char) 27 + "[34m" + "\nElectrical appliances with a power of less than 2000 and more than 200 watts: " + (char) 27 + "[38m");
        list = applianceDAO.getUtensilInPowerRange(200, 2000);
        for (ElectricUtensil temp : list) System.out.println(temp);
    }
}