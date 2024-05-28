/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mario
 */
public class QueryManager {
    private Connection cn;
    private conexion con = new conexion();
    
    /*READ*/
     public List<Alumno> ReadQR() throws SQLException {
        List<Alumno> lista = new ArrayList<>();

        try {
            cn = con.estableceConexion();
            PreparedStatement pstm = cn.prepareStatement("SELECT * FROM Alumnos");
            ResultSet rs = rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);

                Alumno alm = new Alumno(id, nombre, apellido);
                lista.add(alm);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // O utiliza algún sistema de registro de errores
        }
        cn.close();
        return lista;
    }
     
     /*Create*/
    public boolean createQR(Alumno alumno) throws SQLException {
        String insertSQL = "INSERT INTO Alumnos (Nombre, Apellido) VALUES (?, ?)";
        boolean tr;
        
        try {
            cn = con.estableceConexion();
            PreparedStatement pstm = cn.prepareStatement(insertSQL);
             
            pstm.setString(1, alumno.getNombre());
            pstm.setString(2, alumno.getApellido());

            pstm.executeUpdate();
            
            tr = true;

        } catch (SQLException e) {
            e.printStackTrace(); // O utiliza algún sistema de registro de errores
            tr = false;
        }
        cn.close();
        return tr;
    }
    
    /*Update*/
     public boolean updateQR(Alumno alumno, int id) throws SQLException {
        String updateSQL = "UPDATE Alumnos SET Nombre = ?, Apellido = ? WHERE id = ?";
        boolean tr;
        
        try {
            cn = con.estableceConexion();
             PreparedStatement pstm = cn.prepareStatement(updateSQL);
            String nombre = alumno.getNombre();
            String apellido = alumno.getApellido();
            pstm.setString(1, nombre);
            pstm.setString(2, apellido);
            pstm.setInt(3, id);

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                tr = true;
            } else {
                tr = false;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // O utiliza algún sistema de registro de errores
            tr = false;
        }
        cn.close();
        return tr;
    }
    
    /*Delete*/
    public boolean delete(int id) throws SQLException {
       String deleteSQL = "DELETE FROM Alumnos WHERE id = ?";
       boolean tr;
       
       try {
           cn = con.estableceConexion();
           PreparedStatement pstm = cn.prepareStatement(deleteSQL);
           pstm.setInt(1, id);

           int rowsAffected = pstm.executeUpdate();
           if (rowsAffected > 0) {
               tr= true;
           } else {
               tr = false;
           }

       } catch (SQLException e) {
           e.printStackTrace(); // O utiliza algún sistema de registro de errores
           tr = false;
       }
       cn.close();
       return tr;
   }

}