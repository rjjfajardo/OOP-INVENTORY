/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class DBConnection {
    
    public static Connection connect()
    { 
        Connection conn = null;
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?", "root", "");
                JOptionPane.showMessageDialog(null, "connection success");
            }catch(Exception e){
                
            }
            return conn;
    }
    
}
