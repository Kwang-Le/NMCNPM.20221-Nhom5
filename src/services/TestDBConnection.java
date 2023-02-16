package services;

import java.sql.*;
import java.sql.DriverManager;

public class TestDBConnection {

    public static void main(String[] args) {
        String Url = "jdbc:mysql://localhost:3306/quan_ly_nhan_khau?verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true";
        String user= "root";
        String Password= "Tommyguns@123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(Url,user,Password);

            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}