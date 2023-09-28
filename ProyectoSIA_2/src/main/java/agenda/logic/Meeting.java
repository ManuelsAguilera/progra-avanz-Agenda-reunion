/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda.logic;

/**
 *
 * @author manu
 */
public class Meeting {
    private String nombre;
    private String descripcion;
    private int hora;
    
    public Meeting(String nomb, String desc, int hor)
    {
        nombre = nomb;
        descripcion= desc;
        hora = hor;
        System.out.println("Debug: new meeting "+nomb+" "+desc+" "+hor);
    }
    
    
    
        // Setter for 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter for 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Setter for 'descripcion'
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter for 'descripcion'
    public String getDescripcion() {
        return descripcion;
    }

    // Setter for 'hora'
    public void setHora(int hora) {
        this.hora = hora;
    }

    // Getter for 'hora'
    public int getHora() {
        return hora;
    }
    
    //set All
    
    public void setAll(String nomb, String desc, int hor)
    {
        nombre = nomb;
        descripcion= desc;
        hora = hor;
    }
}
