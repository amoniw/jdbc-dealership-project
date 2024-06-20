package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
      String sql = "INSERT INTO sales_contracts (contract_id, customer_name, amount, contract_date) VALUES (?,?,?,?)";

        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
            ) {
            pstmt.setInt(1, salesContract.getContractId());
            pstmt.setString(2, salesContract.getCustomerName());
            pstmt.setDouble(3, salesContract.getAmount());
            pstmt.setDate(4, salesContract.getContractDate());

            pstmt.executeUpdate();
            System.out.println("Sales contract added!");
        } catch (SQLException e) {
            e.printStackTrace();
        
        // TODO: Implement the logic to add a sales contract
    }
}
