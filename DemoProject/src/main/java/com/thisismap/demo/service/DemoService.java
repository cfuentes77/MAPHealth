package com.thisismap.demo.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisismap.demo.domain.Patient;
import com.thisismap.demo.domain.PatientAttribute;

@Service
public class DemoService {

    @Autowired
    private DataSource dataSource;
    
	public Patient getPatientInfo(int patientId) {
		Patient patient = new Patient();
    	 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			
			String getDBUSERByUserIdSql = "{call spViewPatient(?)}";
			CallableStatement  stmt = conn.prepareCall(getDBUSERByUserIdSql);
			stmt.setInt(1, patientId);
			
			boolean results = stmt.execute();
		      int rsCount = 0;

		      //Loop through the available result sets
		     while (results) {
		           ResultSet rs = stmt.getResultSet();
		           rsCount++;
		           
		           if (rsCount == 1) {
			           //Retrieve data from the result set.
			           while (rs.next()) {
			        	   patient.setFirstName(rs.getString("Patient_FirstName"));
			        	   patient.setLastName(rs.getString("Patient_LastName"));
			        	   patient.setEmail(rs.getString("Patient_Email"));			        	   
			           }
		           }
		           if (rsCount == 4) {
			           while (rs.next()) {
			        	   PatientAttribute attribute = new PatientAttribute();
			        	   attribute.setGroup(rs.getString("AttributeGroup"));
			        	   attribute.setName(rs.getString("Attribute"));
			        	   attribute.setDescription(rs.getString("AttributeDescription"));
			        	   patient.addAttribute(attribute);
			           }
		           }
		           rs.close();

		        //Check for next result set
		        results = stmt.getMoreResults();
		      } 
		      stmt.close();
		      
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		return patient;
	}
	
	public Patient getUserInfo(int userId) {
		Patient patient = new Patient();
		
    	String sql = "SELECT FirstName, LastName FROM [User] WHERE Id = " +userId;
    	
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				patient.setFirstName(rs.getString("FirstName"));
				patient.setLastName(rs.getString("LastName"));
			}
			
			stmt.close();
		      
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		return patient;
	}
	
	public void updateUser(int id, String firstName, String lastName) {
		Connection conn = null;
		 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE [User] SET FirstName = ?, LastName = ? WHERE id = ?");
			
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setInt(3,Integer.valueOf(id));

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
