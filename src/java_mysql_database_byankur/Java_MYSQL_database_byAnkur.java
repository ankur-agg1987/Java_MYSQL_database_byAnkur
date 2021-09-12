package java_mysql_database_byankur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ankur-Agg
 */
public class Java_MYSQL_database_byAnkur {

    public static void main(String[] args) {
        // Before working with MYSQL using Connector/J driver you have to
        // add the new MYSQL driver refering to C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.11.jar
        // in Services -> Drivers -> delete old one and add new as above mentioned
        
        try {
            // add the library of MYSQL (Connector/J driver) in project mysql-connector-java-8.0.11.jar 
            // use the com.mysql.cj.jdbc.Driver as the class name to access MYSQL driver for Java application
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // In MYSQL default database is "mysql" you can use the same for tesing
            String url = "jdbc:mysql://localhost:3306/mysql";
            // if you have set the username and password for the MYSQL use them here
            String user = "root";
            String password = "mysqlpwd";
            
            // Connect to the database using username and password
            Connection con = DriverManager.getConnection(url, user, password);
            
            // create a simple statement
            Statement st =  con.createStatement();
            
            // we have create a simple query to fetch data form user table in mysql database
            String query = "SELECT * FROM `user`";
            
            // execute the query 
            ResultSet rs = st.executeQuery(query);
            
            // process the result and print the detail
            while(rs.next()){
                System.out.print("Host name: " + rs.getString(1));
                System.out.println(" // Username : " + rs.getString(2));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
