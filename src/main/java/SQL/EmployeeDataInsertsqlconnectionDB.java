package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDataInsertsqlconnectionDB {

	
	public static void main(String[] args) {
        // Database URL, username, and password

		String URL= "jdbc:mysql://localhost:3306/Employee";
		String uname= "root";
		String psw ="welcome@123";
        
        
        
        // SQL Insert statement
        String insertSQL = "INSERT INTO EmployeeTask(empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        // Sample employee data
        Object[][] employees = {
            {101, "jenny", 25, 10000},
            {102, "jack", 39, 20000},
            {103, "joe", 20, 40000},
            {104, "john", 40, 80000},
            {105, "shameer", 25, 90000}
        };

        try (Connection connection = DriverManager.getConnection(URL, uname, psw);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Insert each employee data
            for (Object[] employee : employees) {
                preparedStatement.setInt(1, (Integer) employee[0]); // empcode
                preparedStatement.setString(2, (String) employee[1]); // empname
                preparedStatement.setInt(3, (Integer) employee[2]); // empag
                preparedStatement.setInt(4, (Integer) employee[3]); // esalary
                preparedStatement.executeUpdate();
            }

            System.out.println("Employee data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
