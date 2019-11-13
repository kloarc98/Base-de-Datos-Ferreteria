/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Loarca
 */
public class combo {
    
    conexion conexion = new conexion();
    
     public void consultarcat (JComboBox combocategoria){
        java.sql.Connection conectar = null;
        
        String SSQL = "SELECT Descripcion FROM Categoria";
        
        try{
        conectar = conexion.getConnection();
        PreparedStatement pst = conectar.prepareCall(SSQL);
        ResultSet result =  pst.executeQuery();
        combocategoria.addItem("Seleccione una opcion");
        
        while(result.next()){
            combocategoria.addItem(result.getString("Descripcion"));
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            if(conectar!=null){
                try {
                    conectar.close();
                } catch (SQLException ex) {
                    Logger.getLogger(combo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
    }
    
}
