package eetac;

public class Caja {
    Producto p;
    int cantidad;
    String idPedido;

    public Caja(int cantidad, Producto p, String idPedido) {
        this.p = p;
        this.cantidad = cantidad;
        this.idPedido = idPedido;
    }


    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
}
