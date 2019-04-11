import eetac.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class ProductManagerTest {
    final static org.apache.log4j.Logger log = Logger.getLogger(ProductManagerTest.class.getName());
    ProductManager pm;

    @Before

    public void SetUp() {

        System.out.println("SETUP");
        pm = ProtuctManagerImpl.getInstance();
        this.pm = new ProtuctManagerImpl();


    }

    @Test
    public void addUsersTest() {

        this.pm.addUser("1");
        this.pm.addUser("2");
        Assert.assertEquals(2, pm.numUsers());
    }

    @Test
    public void addProductosTest() {

        this.pm.addProducto(32, "patatas", 44);
        this.pm.addProducto(44, "UNICORNIO", 0);

        Assert.assertEquals(2, pm.numProductos());
    }

    @Test
    public void  listaordenadaTest() {

        this.pm.addProducto(32, "patatas", 44);
        this.pm.addProducto(44, "UNICORNIO", 0);
        this.pm.addProducto(3332, "casa", 10);
        this.pm.addProducto(342, "casa zulo", 444);


        Assert.assertEquals(32, pm.listaproductoprecio().get(0).getPrecio());
        Assert.assertEquals(44, pm.listaproductoprecio().get(1).getPrecio());
        Assert.assertEquals(342, pm.listaproductoprecio().get(2).getPrecio());
        Assert.assertEquals(3332, pm.listaproductoprecio().get(3).getPrecio());



    }

    @Test
    public void  añadircajaTest() {

        this.pm.addUser("1");
        Producto producto1  = new Producto(32, "patatas", 44);
        Producto producto2  = new Producto(44, "UNICORNIO", 44);
        Producto producto3  = new Producto(323, "casa", 44);

        this.pm.addCaja(3, producto1,"pedido1");
        this.pm.addCaja(2, producto2,"pedido1");
        this.pm.addCaja(3, producto3,"pedido2");

        Assert.assertEquals(3, pm.numCajas());


    }
    @Test
    public void  hacerPedidoTest() {

        this.pm.addUser("1");
        Producto producto1  = new Producto(32, "patatas", 44);
        Producto producto2  = new Producto(44, "UNICORNIO", 44);
        Producto producto3  = new Producto(323, "casa", 44);

        this.pm.addCaja(3, producto1,"pedido1");
        this.pm.addCaja(2, producto2,"pedido1");
        this.pm.addCaja(3, producto3,"pedido2");

        this.pm.hacerpedido("1", "pedido1");
        Assert.assertEquals(1, this.pm.damePedidosUsuario("1"));
        Assert.assertEquals(2, this.pm.dameCajasPedido("pedido1"));


    }
    @Test
    public void  servirpedidoTest() {

        this.pm.addUser("1");
        Producto producto1  = new Producto(32, "patatas", 44);
        Producto producto2  = new Producto(44, "UNICORNIO", 44);
        Producto producto3  = new Producto(323, "casa", 44);

        this.pm.addCaja(3, producto1,"pedido1");
        this.pm.addCaja(2, producto2,"pedido1");
        this.pm.addCaja(3, producto3,"pedido2");

        this.pm.hacerpedido("1", "pedido1");
        this.pm.servirPedido("pedido1");
      //  Assert.assertEquals(1, this.pm.damePedidosUsuario("1"));
//        Assert.assertEquals(2, this.pm.dameCajasPedido("pedido1"));
        Assert.assertEquals(1, this.pm.pedidosrealizados());
        Assert.assertEquals(0, this.pm.numPedidos());


    }





}