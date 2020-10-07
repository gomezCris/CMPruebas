package com.pruebascm.Api;

//Librerías para asignarle el mapeo de la ruta
//para prueba de apis: swapui.org
import com.pruebascm.DAO.pruebaApiUsuarioDAO;
import com.pruebascm.Model.pruebaApiUsuarioModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Mapeo de URL de api
@Path("/usuario")
//Se va a consumir consultas JSon
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class pruebaApiUsuarioAPI {
    //Inicializar el objeto
    pruebaApiUsuarioDAO usuarioDAO = new pruebaApiUsuarioDAO();
    
    //Variable de resultados
    boolean res;
    //Ingresar usuario
    /*
    POST: se utiliza para enviar información y en este caso, insertar esa información
         en una tabla de una base de datos
    */
    @POST
    public Response agregarUsuario(pruebaApiUsuarioModel usuario) throws SQLException{
        res = usuarioDAO.agregar(usuario);
        if(res){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(500, "Ocurrió un error al registrar el usuario, intente más tarde").build();
        }
    }
    
    /*
    Método GET:
    Se utiliza para obtener una lista de objetos, según una tabla de DB
    */
    @GET
    public List<pruebaApiUsuarioModel> obtenerUsuarios(){
        List<pruebaApiUsuarioModel> listaUsuarios = new ArrayList<pruebaApiUsuarioModel>();
        
        listaUsuarios = usuarioDAO.obtenerTodos();
        return listaUsuarios;

    }
    
    /*
    Método GET by ID:
    Se utiliza para obtener un objeto específico según una tabla de DB
    */
    @GET
    @Path("/{id}")
    public pruebaApiUsuarioModel obtenerUnUsuario(@PathParam("id") int id){
        pruebaApiUsuarioModel usuario = new pruebaApiUsuarioModel();
        usuario = usuarioDAO.obtenerUnUsuario(id);
        
        if(usuario != null){
            return usuario;
        }else{
            return null;
        }
    }
    
    /*
    MÉTODO DELETE:
    Encargado de eliminar un registro en específico de la base de datos
    */
    @DELETE
    @Path("/{id}")
    public Response eliminarUsuario(@PathParam("id") int id){
        res = usuarioDAO.eliminar(id);
        if(res){
            return Response.status(200, "Registro eliminado correctamente").build();
        }else{
            return Response.status(500, "Ocurrió un error al eliminar el registro").build();
        }
    }
    
    /*
    MÉTODO PUT: 
    Encargado de actualizar datos de un registro en específico en la DB
    */
    @PUT
    public Response actualizarUsuario(pruebaApiUsuarioModel usuario) throws SQLException{
        res = usuarioDAO.actualizar(usuario);
        if(res){
            return Response.ok(usuario).build();
        }else{
            return Response.status(500, "Ocurrió un error al actualizar el usuario, intente más tarde").build();
        }
    }
}
