package eetac;

import eetac.Pedido;

import java.util.LinkedList;

public interface ProductManager {

    public void addUser(String idUser);
    public int numUsers();
    public int numProductos();
    public int numPedidos();
    public int numCajas();
    public void addProducto( int precio, String id, int ventas);
    public LinkedList<Producto> listaproductoprecio();
    public void hacerpedido( String idUser, String idPedido) throws UsuarioException;
    public void addCaja( int cantidad, Producto p, String idPedido);
    public void servirPedido( String idPedido);
    public LinkedList<Producto> listaProductos();
    public LinkedList<Pedido> listapedidouser(String idUser);
    public int damePedidosUsuario(String idUser) throws UsuarioException;
    public int dameCajasPedido(String idPedido);
    public int pedidosrealizados();
   // public LinkedList<Pedido> pedidosrealizados  ( String idUsario);


}


