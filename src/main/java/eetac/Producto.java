package eetac;

public class Producto {

    int precio;
    String id;
    int ventas;

    public Producto(int precio, String id, int ventas) {
        this.precio = precio;
        this.id = id;
        this.ventas = ventas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
