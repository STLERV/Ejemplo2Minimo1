package Service;
import eetac.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

import javax.ws.rs.core.GenericEntity;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/tienda", description = "Endpoint to tienda Service")

@Path("/tienda")

public class ProductManagerImpService {

    final static Logger log = Logger.getLogger(ProductManagerImpService.class.getName());
    private ProductManager pm;

    public ProductManagerImpService(){
        this.pm = ProtuctManagerImpl.getInstance();
    }

  @GET
  @ApiOperation(value = "Obetener lista productos por precio")
  @ApiResponses(value= {
          @ApiResponse(code = 201, message = "exito", response = Producto.class, responseContainer = "Lista de productos por precio"),
  })
  @Path("/{listaprecio}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response productsbyprice(){
      LinkedList<Producto> listaprecio = new LinkedList<>();
        listaprecio = pm.listaproductoprecio();
          GenericEntity<List<Producto>>entity = new GenericEntity<List<Producto>>(listaprecio){};
          return Response.status(201).entity(entity).build();

      }


    @POST
    @ApiOperation(value = "Añadir Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "exito")
    })
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser ( Usuario u){
        pm.addUser(u.getIdUsuario());
        return Response.status(201).build();

        }



    @GET
    @ApiOperation(value = "Obetener numero pedidos de un usuario")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "exito", response = Producto.class, responseContainer = "numero de productos de un usuario"),
    })
    @Path("/{pedidosusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productosbyuser(@PathParam("idUser")String idUser)
    {
        int numero;
        try {
            numero = pm.damePedidosUsuario("idUser");
            GenericEntity entity = new GenericEntity(numero) {
            };
            return Response.status(201).entity(entity).build();

        }
        catch (UsuarioException e){
            return Response.status(201).build();
                   }
    }




}







