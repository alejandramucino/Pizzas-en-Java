package mx.unam.aragon.tsp.anmh.pizzas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tamanos")
public class Tamano {

    @Id
    private String id;

    private String nombre;
    private int diametro;
    private double precioExtra;

    public Tamano() {
    }

    public Tamano(String nombre, int diametro, double precioExtra) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.precioExtra = precioExtra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }


}
