package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Datasource.getConnection();
            String sql = "INSERT INTO vehicles (make, model, year) VALUES (?, ?, ?)
            stmt = conn.preparedstatement(sql)
            stmt.setString(1, addvehicle.getMake());
            stmt.setString(2, addvehicle.getModel());
            stmt.setInt(3, addvehicle.getYear());
            stmt.executeUpdate();
        } finally {
            //Close
            if (stmt != null) {
                stmt.close():
            }
            if (conn != null) {
                conn.close():
            }        
        // TODO: Implement the logic to add a vehicle
    }

    public void removeVehicle(String VIN) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = dataSource.getConnection();
            String sql = "DELETE FROM vehicles WHERE vin = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,VIN);

            int rowsAffected = stmt.excuteUpdate();
            if (rowsAffected = = 0) {
                System.out.println("No vehicle found with VIN " + VIN);
            } else {
                System.out.println("Vehicle with VIN " + VIN + " removed");
            }
        } finally {
            closeResources(conn, stmt, nll);
        // TODO: Implement the logic to remove a vehicle
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>():
        Connection conn null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?":
            stmt = conn.prepareStatement(sql)
            stmt.setDouble(1, searchBymin_Price);
            stmt.setDouble(2, searchBymax_Price);

            rs = stmt.executeQuery():
            
        // TODO: Implement the logic to search vehicles by price range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
         List<Vehicle> searchByMakeModel = new ArrayList<>():
        Connection conn null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE  MAKE ? MODEL ?":
            stmt = conn.prepareStatement(sql)
            stmt.setDouble(1, String make);
            stmt.setDouble(2, String model);

            rs = stmt.executeQuery():

        // TODO: Implement the logic to search vehicles by make and model
        return new ArrayList<>();
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs - null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE year BEWTWEEN ? AND ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, searchBymin_Year);
            stmt.setInt(2, searchBymax_Year);

            rs = stmt.excuteQuery();

         while (rs.next()) {
             String vin = rs.getString("vin");
             String make = rs.getString("make");
             String model = rs.getString("model")    
             int year = rs.getInt("year")
             double price = rs.getDouble("price");

             Vehicle vehicle = new Vehicle(vin, make , model, year, price);
         }
        } finally {
            closeResources(conn, stmt, rs);
        }
        // TODO: Implement the logic to search vehicles by year range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByColor(String color) {
         List<Vehicle> vehicles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs - null;

        try {
         conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE color = ?
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, color);

            rs = stmt.exexcuteQuery();

             while (rs.next()) {
             String color = rs.getString("color");
            
             Vehicle vehicle = new Vehicle("color)";
             vehicles.add(vehicle):
                 }
        } finally {
            closeResources(conn, stmt, rs);
        
        // TODO: Implement the logic to search vehicles by color
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs - null;

          try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE mileage BEWTWEEN min_mileage AND max_mileage;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, minMileage);
            stmt.setInt(2, maxMileage);

            rs = stmt.exexcuteQuery();

             while (rs.next()) {
             String min_Mileage = rs.getString("min_Mileage");
             String max_Mileage = rs.getString("max_Mileage");
             
             Vehicle vehicle = new Vehicle(min_Mileage, max_Mileage,);
             vehicles.add(vehicle):
                 }
        } finally {
            closeResources(conn, stmt, rs);   
 // TODO: Implement the logic to search vehicles by mileage range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs - null; 

         try {
         conn = dataSource.getConnection();
            String sql = "SELECT * FROM vehicles WHERE type = ?
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, type);

            rs = stmt.exexcuteQuery();

              while (rs.next()) {
             String type = rs.getString("type");
             
             
             Vehicle vehicle = new Vehicle(type);
             vehicles.add(vehicle):
                 }
        } finally {
            closeResources(conn, stmt, rs);   
        // TODO: Implement the logic to search vehicles by type
        return new ArrayList<>();
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
