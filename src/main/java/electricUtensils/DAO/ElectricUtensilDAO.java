package electricUtensils.DAO;

import electricUtensils.DAOInterfaces.IElectricUtensilDAO;
import electricUtensils.Entity.ElectricUtensil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricUtensilDAO implements IElectricUtensilDAO {

    @Override
    public void deleteByID(ElectricUtensil e) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement ps = null;
        String str = "DELETE FROM house_appliances WHERE id = ?;";
        try{
            ps = connection.prepareStatement(str);
            ps.setInt(1, e.getId());
            ps.execute();
        } catch (SQLException s){
            throw new RuntimeException(s);
        } finally {
            if (connection != null && ps != null){
                try{
                    connection.close();
                    ps.close();
                } catch (SQLException s){
                    s.printStackTrace();
                }
            }
        }
    }




    @Override
    public List<ElectricUtensil> getUtensilByPower(int power) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement ps = null;
        List<ElectricUtensil> list = new ArrayList<>();
        String str = "SELECT * FROM house_appliances WHERE power = ?;";

        try{
            assert connection != null;
            ps = connection.prepareStatement(str);
            ps.setInt(1, power);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int pwr = rs.getInt(3);
                boolean isPowered = rs.getBoolean(4);
                ElectricUtensil electricUtensil = new ElectricUtensil(id, name, pwr, isPowered);
                list.add(electricUtensil);
            }
            return list;

        } catch (SQLException s){
            throw new RuntimeException(s);
        } finally {
            if (connection != null && ps != null){
                try{
                    connection.close();
                    ps.close();
                } catch (SQLException s){
                    s.printStackTrace();
                }
            }
        }

    }

    @Override
    public void add(ElectricUtensil e) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement ps = null;
        String str = "INSERT INTO house_appliances (name,power,isPowered) VALUES (?,?,?);";
        try {
            ps = connection.prepareStatement(str);
            ps.setString(1,e.getName());
            ps.setInt(2,e.getPowerConsumption());
            ps.setBoolean(3,e.isPluggedIn());
            ps.execute();
        } catch (SQLException s) {
            throw new RuntimeException(s);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }




    @Override
    public void plugIn(String name) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement ps = null;
        String str = "UPDATE house_appliances SET isPowered = true WHERE name = ?;";
        try {
            assert connection != null;
            ps = connection.prepareStatement(str);
            ps.setString(1,name);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void unplug(String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        String str = "UPDATE house_appliances SET isPowered = false WHERE name = ?;";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(str);
            ps.setString(1,name);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<ElectricUtensil> getAll() {
        List<ElectricUtensil> al = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        String str = "SELECT * FROM house_appliances;";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int power = rs.getInt(3);
                boolean isPowered = rs.getBoolean(4);
                ElectricUtensil appliance = new ElectricUtensil(id, name, power, isPowered);
                al.add(appliance);
            }
            return al;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<ElectricUtensil> sortByPower() {
        List<ElectricUtensil> al = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        String str = "SELECT * FROM house_appliances ORDER BY power;";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int power = rs.getInt(3);
                boolean isPowered = rs.getBoolean(4);
                ElectricUtensil appliance = new ElectricUtensil(id, name, power, isPowered);
                al.add(appliance);
            }
            return al;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public List<ElectricUtensil> getUtensilInPowerRange(int minPower, int maxPower) {
        List<ElectricUtensil> al = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        String str = "SELECT * FROM house_appliances WHERE power>? AND power<?;";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,minPower);
            ps.setInt(2, maxPower);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int power = rs.getInt(3);
                boolean isPowered = rs.getBoolean(4);
                ElectricUtensil appliance = new ElectricUtensil(id, name, power, isPowered);
                al.add(appliance);
            }
            return al;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int totalPowerConsumption() {
        Connection connection = null;
        PreparedStatement ps = null;
        String str = "SELECT SUM(power) FROM house_appliances WHERE isPowered=true;";
        try {
            connection = getConnection();
            assert connection != null;
            ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricUtensils", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
