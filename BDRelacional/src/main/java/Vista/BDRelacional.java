/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import Controlador.CRUD;
import Modelo.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class BDRelacional {

    public static void main(String[] args) throws SQLException {
        CRUD contr = new CRUD();
        
        /*crear alumno a la base de datos*/
        contr.create("Pablo", "Baeza");
        /*contr.create("Luis", "Pacheco");
        contr.create("Jose", "Murica    ");*/
        
        List<Alumno> alumnos = new ArrayList<>();
        
        /*alumnos = contr.read();*/
        
        /*for (Alumno alumno : alumnos) {
                System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido());
            }*/
        
        /*contr.update("Jose", "Perez", 1);
        contr.delete(2);*/
        
       alumnos = contr.read();
       
       for (Alumno alumno : alumnos) {
                System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido());
        }
        
    }
}
