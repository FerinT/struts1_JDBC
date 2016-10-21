package main.utils;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by tayfer01 on 10/18/2016.
 */

public class EstablishConnection {

    private static Connection connection;

    public static Connection getConnection()
    {
        System.setProperty("oracle.net.tns_admin", "C:\\oracle\\product\\11.2.0\\client_1\\network\\admin");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@tst1124", "hr7", "hr7");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
