/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class conexion {
     public Connection Cn = null;
     
    static String Usuario = "usersql";
    static String Contraseña = "123";
    static String Bd = "ClasePractica";
    static String Puerto ="1433";
     
    
    public Connection estableceConexion(){
        try {
            String Cadena = "jdbc:sqlserver://localhost:"+Puerto+";"+"databaseName="+Bd+";integratedSecurity=false;"+"encrypt=false;trustServerCertificate=true";
            Cn = DriverManager.getConnection(Cadena,Usuario,Contraseña);
            JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
        } catch(Exception e){   
            JOptionPane .showMessageDialog(null,"Error al conectar la base de datos:" + e.toString());
        }
        return Cn;
    }
}
