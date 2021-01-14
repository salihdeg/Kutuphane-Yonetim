package Sayfalar;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salih Degirmenci
 */
public class My_CNX {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "kutuphane";
    private static Integer portnumber = 3306;
    private static String password = "";
    
    public static Connection getConnection() throws java.sql.SQLException{
        Connection cnx= null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + My_CNX.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Sunucuya Bağlanılamadı","Bağlantı Hatası",0);
        }
        return cnx;
    }
    
}