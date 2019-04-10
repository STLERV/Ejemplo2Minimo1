import java.util.LinkedList;

public class Pedido {
   LinkedList<Caja> productos;
    boolean realizado;
    String idPedido;


    public Pedido( LinkedList<Caja> productoslist, String idPedido) {
            this.idPedido = idPedido;
            this.productos= productoslist;
            realizado = false;
    }

    public Pedido(String idPedido){
        this.idPedido =idPedido;
        this.productos = new LinkedList<Caja>();
        realizado =false;

    }

    public void addProducto(Caja p){
        this.productos.add(p);
    }



    public LinkedList<Caja> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Caja> productos) {
        this.productos = productos;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = true;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
}
