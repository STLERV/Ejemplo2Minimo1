import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;

public class ProtuctManagerImpl implements ProductManager{

    ////////////////Singelton////////////////////////
/////////////Singelton////////

    //
    final static Logger log = Logger.getLogger(ProtuctManagerImpl.class.getName());
    private static ProductManager instance;

   private HashMap<String, Usuario> users;
    private LinkedList<Producto> listaproductos;
    private LinkedList<Pedido> pedidolist;
    private LinkedList<Caja> cajaslist;

    public ProtuctManagerImpl() {

        listaproductos = new LinkedList<Producto>();
        users = new HashMap<String, Usuario>();
        pedidolist = new LinkedList<Pedido>();
        cajaslist = new LinkedList<Caja>();

    }


    public static ProductManager getInstance() {

        if (instance == null) instance = new ProtuctManagerImpl();

        return instance;

    }


    ////////////////////////////////////////////

    public void addUser(String idUser) {
        log.info("AñadiendoUsuario");

    }

    public void addProducto(String idProducto, int precio, int ventas) {

    }


    public LinkedList<Producto> listaproductoprecio() {
        return null;
    }


    public void hacerpedido(String idUser, String idPedido) {

    }


    public void addCaja(Producto p, int cantidad, String idPedido) {

    }


    public void servirPedido(String idPedido) {

    }


    public LinkedList<Producto> listaProcuctos() {
        return null;
    }

       public LinkedList<Pedido> listapedidouser(String idUser) {
        return null;
    }
}
