
package mx.unam.aragon.tsp.anmh.pizzas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bebidas")
public class Bebida {

    @Id
    private String id;

    private String nombre;
    private String presentacion;
    private int contenidoMl;
    private double precio;

    public Bebida() {
    }

    public Bebida(String nombre, String presentacion, int contenidoMl, double precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.contenidoMl = contenidoMl;
        this.precio = precio;
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

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getContenidoMl() {
        return contenidoMl;
    }

    public void setContenidoMl(int contenidoMl) {
        this.contenidoMl = contenidoMl;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
