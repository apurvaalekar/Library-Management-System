/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author apurva
 */
public class ConnUtil {
    
static Connection getConnection(){
    
    Connection conn=null;
     Statement stmt=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
            
                        
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        
        } 
        return conn;
}
static void closeConnection(Connection conn){
    try {
        conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(ConnUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
