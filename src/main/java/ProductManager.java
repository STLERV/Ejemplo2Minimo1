import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public interface ProductManager {

    public void addUser(String idUser);
    public void addProducto( String idProducto, int precio, int ventas);
    public LinkedList<Producto> listaproductoprecio();
    public void hacerpedido( String idUser, String idPedido);
    public void addCaja(Producto p, int cantidad, String idPedido);
    public void servirPedido( String idPedido);
    public LinkedList<Producto> listaProcuctos();
    public LinkedList<Pedido> listapedidouser(String idUser);


}


