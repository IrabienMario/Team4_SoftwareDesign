/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BDNR.QueryManager;
import Modelo.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class CRUD {
    private QueryManager query = new QueryManager();
    
    public void update(String Nombre,String Apellido, int id) throws SQLException{
        Alumno actul = new Alumno(99,Nombre,Apellido);
        if(query.updateQR(actul, id)){
            System.out.println("Se actualizo correctamente el Alumno");
        }
        else{
            System.out.println("No actualizo correctamente el Alumno");
        }
    }
    
    public List<Alumno> read() throws SQLException{
        List<Alumno> lst = new ArrayList<>();
        lst = query.ReadQR();
        return lst;
    }
    
    public void create(String Nombre, String Apellido) throws SQLException{
        Alumno actul = new Alumno(99,Nombre,Apellido);
        if(query.createQR(actul)){
            System.out.println("Alumno creado correctamente)");
        }
        else{
            System.out.println("Alumno no fue creado");
        }
    }
    
    public void delete(int id) throws SQLException{
        if(query.delete(id)){
            System.out.println("Alumno borrado con exito");
        }
        else{
            System.out.println("El alumno no pudo ser borrado, asegurse de ingresar el id correcto");
        }
    }
}
