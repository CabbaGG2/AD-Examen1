package Modelos;

import java.io.Serializable;

public class Animales implements Serializable {
    private int id;
    private String nombre;
    private String especie;
    private int cantidad;

    public Animales(int id, String nombre, String especie, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
