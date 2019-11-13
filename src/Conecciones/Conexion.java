package Conecciones;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
public class Conexion {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "1234";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/Ferreteria";
    
    public Conexion(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            if(conn != null){
                JOptionPane.showMessageDialog(null, "Conexion Establecida");
            }
        }catch(ClassNotFoundException|SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
            
        }
    }
    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn = null;
        if(conn == null){
            JOptionPane.showMessageDialog(null, "Conexion Terminada");
        }
    }

    public ResultSet consulta(String sql){
        ResultSet res = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            res= pstm.executeQuery();
        }catch(SQLException e){
            System.err.println("Error Consulta :"+ e.getMessage());
        }
        return res;
    }
    
   
}