package com.example.test.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;

public class Info {


    public static void main(String[] args) throws UnknownHostException {

        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.print("AddressIP" + hostAddress);
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
//            statement.executeUpdate("insert into person values(1, 'leo')");
//            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("SELECT name FROM person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

}
