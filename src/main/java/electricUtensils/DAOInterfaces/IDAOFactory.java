package electricUtensils.DAOInterfaces;

import electricUtensils.DAO.ElectricUtensilDAO;

public interface IDAOFactory {
    public ElectricUtensilDAO getDAO();
}
