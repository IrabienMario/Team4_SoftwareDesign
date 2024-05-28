/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mario
 */
public class Calificaciones {
    private int id;
    private int calificacion;
    
    public Calificaciones(int id, int calificacion) {
        this.id = id;
        this.calificacion = calificacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}