package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        String sql = "INSERT INTO addVehivleToInventory (String vin, int dealership) VALUES (?,?)";

        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement psmt - conn.prepareStatement(sql)
            ){
            pstmt.setString(1, addVehicle.getVin());
            pstmt.setInt(2, addVehicle.getdealershipid());

            pstmt.executeUpdate();
            System.out.println("Vehicle added successfully!");
    } catch (SQLException e 
             e.printStackTrace();
    }

// TODO: Implement the logic to add a vehicle to the inventory
    }

    public void removeVehicleFromInventory(String vin) {
        Connection conn = null;
        PreparedStatement stmt = null;

try {
    conn = dataSource.getConnection();
    String sql = "DELETE FROM vehicles WHERE vin = ?
    stmt = conn.prepareStatement(sql);
    stmt.setString(1, VIN);

    int rowsAffected = stmt.excuteUpdate();
    if (rowsAffected = = 0 {
    System.out.println("No vehicle found with VIN " + VIN);
    } else {
        System.out.println("Vehicle with VIN " + VIN + "removed");
    }
} finally {
    closeResources(conn, stmt, null);
        
        
        // TODO: Implement the logic to remove a vehicle from the inventory
    }
}
