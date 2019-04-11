package eetac;
import java.util.*;
import org.apache.log4j.Logger;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class ProtuctManagerImpl implements ProductManager {

    ////////////////Singelton////////////////////////
/////////////Singelton////////

    //
    final static Logger log = Logger.getLogger(ProtuctManagerImpl.class.getName());
    private static ProductManager instance;

    private HashMap<String, Usuario> users;
    private LinkedList<Producto> listaproductos;
    private LinkedList<Pedido> pedidolist;
    private LinkedList<Caja> cajaslist;
    private LinkedList<Pedido> realizados;

    public ProtuctManagerImpl() {

        listaproductos = new LinkedList<Producto>();
        users = new HashMap<String, Usuario>();
        pedidolist = new LinkedList<Pedido>();
        cajaslist = new LinkedList<Caja>();
        realizados = new LinkedList<Pedido>();

    }


    public static ProductManager getInstance() {

        if (instance == null) instance = new ProtuctManagerImpl();

        return instance;

    }


    //////////////////////////////////////////////

    public void addUser(String idUser) {
        log.info("AñadiendoUsuario");
        Usuario u = new Usuario(idUser);
        this.users.put(idUser,u);
        log.info("Usuario añadido con exito" + idUser);
    }

    public void addProducto( int precio, String id, int ventas) {
    log.info("Añadiendo producto");
    Producto p = new Producto(precio,id,ventas);
    listaproductos.add(p);
    }

    public int numUsers() {

        return this.users.size();

    }
    public int numProductos() {

        return this.listaproductos.size();

    }
    public int numPedidos() {

        return this.pedidolist.size();

    }
    public int numCajas(){
        return this.cajaslist.size();
    }



    public LinkedList<Producto> listaproductoprecio() {
        log.info("vamos a ordenar por precio de mayor a menor");

/////////esto va ser de menor a mayor
        LinkedList<Producto> lista = new LinkedList<Producto>(this.listaproductos);
        Collections.sort(lista, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return (int) (o1.getPrecio() - o2.getPrecio());
            }

        });
        log.info("ya esta");
        return lista;

        //si lo queremos al reves ponemos donde pone int: (int)(-1)*(...)
    }

    public void hacerpedido(String idUser, String idPedido) {

        log.info("Hacer pedido");
        Usuario user;
        user = users.get(idUser);
        Pedido pedido = new Pedido(idPedido);
        if (user != null) {

            int i = 0;

            for (i = 0; i < this.cajaslist.size(); i++) {

                if (idPedido.equals(this.cajaslist.get(i).getIdPedido())) {
                    Caja caja = this.cajaslist.get(i);
                    pedido.addProducto(caja);
                }

            }
            user.addpedido(pedido);
            pedidolist.add(pedido);
        } else {
            log.error("Usuario");

    }
           }
    public int damePedidosUsuario(String idUser){
        Usuario user = users.get(idUser);
       return user.listapedido.size();
    }

    public int dameCajasPedido(String idPedido) {
        int a = 0;
        for (int i = 0; i < this.pedidolist.size(); i++) {

            if (idPedido.equals(this.pedidolist.get(i).idPedido)) {
                Pedido pedido = this.pedidolist.get(i);
               a =  pedido.getProductos().size();
            }
        }
        return a;
    }



    public void addCaja( int cantidad, Producto p, String idPedido) {
        log.info("embalando procuto");
        Producto producto = p;
        Caja caja = new Caja ( cantidad, p, idPedido);
        cajaslist.add(caja);
    }

    public void servirPedido(String idPedido) {
        Pedido p;
         p = pedidolist.getFirst();
         pedidolist.poll();
         p.setRealizado(true);
         realizados.add(p);

    }
    public int pedidosrealizados(){
        return realizados.size();

    }


    public LinkedList<Producto> listaProductos() {
        return null;
    }

       public LinkedList<Pedido> listapedidouser(String idUser) {
        return null;
    }
}
