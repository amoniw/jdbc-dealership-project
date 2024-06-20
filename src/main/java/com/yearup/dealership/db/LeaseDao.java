package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
       String sql = "INSERT INTO Lease_contract (contract_id, customer_name, amount, contract_date) VALUES (?, ?, ? ,?)

           try (
           Connection conn = dataSource.getConnection():
           PreparedStatement pstmt = conn.prepareStatement(sql)
           ){
           pstmt.setInt(1, addleaseContract.getLeaseid();
           pstmt.setString(2, addleaseContract.getCustomerName();
           pstmt.setDouble(3, addleaseContact.getAmount();
           pstmt.setDate(4, addleaseContract.getContractDate();
           
           pstmt.excuteUpdate();
           System.out.println("Lease contract added!");
       } catch (SQLException e) {
           e.printStackTrace();
       }
           
 // TODO: Implement the logic to add a lease contract
    }
}
