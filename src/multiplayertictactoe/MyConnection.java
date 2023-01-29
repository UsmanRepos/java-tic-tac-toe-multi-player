
package multiplayertictactoe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usman_Aslam
 */
public class MyConnection {
    static Connection conn;
    static int count = 1;
    
    public static Connection getConnection()
    {
        if(count == 1)
        {
            connect_to_Database();
            count++;
        }
        return conn;
        
    }
    public static  void connect_to_Database()
    {
        try
        {
           String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
           Class.forName(driver);
           
           String db = "jdbc:ucanaccess://C:\\Users\\Usman_Aslam\\Documents\\TicTacToe.accdb";
           conn = DriverManager.getConnection(db);
           //st = conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
