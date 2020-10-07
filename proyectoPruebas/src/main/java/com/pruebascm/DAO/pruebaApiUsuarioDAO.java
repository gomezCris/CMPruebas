package com.pruebascm.DAO;

//Paquete de la clase Conexión
import com.pruebascm.Conexion.Conexion;
//Paquete de la clase Model
import com.pruebascm.Model.pruebaApiUsuarioModel;
//Importación de librerías
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pruebaApiUsuarioDAO {
    //Variable de conexión
    Connection connection;
    //Instanciamos nuevo objeto de tipo Conexión en base a la clase "Conexión"
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta en DB
    ResultSet rs;
    int resultado;
    boolean res;
    
    //Declaración de variables de objeto
    int id;
    String nombre;
    String apellido;
    int edad;
    String telefono;
    
    //Declaración de consultas
    String INSERT = "INSERT INTO pruebaApiUsuario VALUES(?, ?, ?, ?, ?)";
    //Consulta SELECT para obtener todos los usuarios
    String SELECT = "SELECT * FROM pruebaApiUsuario";
    String selectById = "SELECT * FROM pruebaApiUsuario where id = ";
    //Consulta DELETE para eliminar un registro en específico de la DB
    String DELETE = "DELETE FROM pruebaApiUsuario where id = ";
    //Consulta UPDATE para acutalizar datos de un registro en específico
    String UPDATE = "UPDATE pruebaApiUsuario SET nombre = (?), apellido = (?), edad = (?), tel = (?) where id = (?)";
    
    //Definición de métodos CRUD
    public boolean agregar(pruebaApiUsuarioModel objUsuario){
        try{
            //Obtenemos la conexión
            connection = con.getConnection();
            //Preparamos la consulta
            PreparedStatement statement = connection.prepareStatement(INSERT);
            
            //Asignamos los valores a los campos de la consulta sql
            statement.setInt(1, objUsuario.getId());
            statement.setString(2, objUsuario.getNombre());
            statement.setString(3, objUsuario.getApellido());
            statement.setInt(4, objUsuario.getEdad());
            statement.setString(5, objUsuario.getTelefono());
            statement.execute();
            connection.close();
            
            res = true;
            return res;
        }catch(SQLException e){
            res = false;
            return res;
        }
    }
    
    //Obtener todos los registros
    public List<pruebaApiUsuarioModel> obtenerTodos(){
        //Creamos la lista del tipo de objeto correspondiente que almacenará los registros 
        List<pruebaApiUsuarioModel> listaUsuarios = new ArrayList<pruebaApiUsuarioModel>();
        
        try{
            String sql = SELECT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            if(res){
                while(rs.next()){
                    id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    edad = rs.getInt("edad");
                    telefono = rs.getString("tel");
                    
                    //Creación de objeto de tipo pruebaApiUsuarioModel
                    pruebaApiUsuarioModel usuario = new pruebaApiUsuarioModel(id, nombre, apellido, edad, telefono);
                    //agregamos el objeto a nuestra lista de objetos
                    listaUsuarios.add(usuario);
                }
            }
            
            //Cerrar la conexión a la base de datos
            connection.close();
            
            //Retornamos la lista de registros
            return listaUsuarios;
        }catch(SQLException e){
            return listaUsuarios;
        }
    }
    
    //Obtener un usuario en específico mediante su ID
    
    public pruebaApiUsuarioModel obtenerUnUsuario(int idUsuario){
        
        //Creación de nuestro objeto
        pruebaApiUsuarioModel usuario;
        try{
            String sql = selectById + Integer.toString(idUsuario);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    edad = rs.getInt("edad");
                    telefono = rs.getString("tel");
                    
                }
            }
            
            connection.close();
        }catch(SQLException e){
            return null;
        }
        
        //Creación de objeto de tipo pruebaApiUsuarioModel
        pruebaApiUsuarioModel usuarioById = new pruebaApiUsuarioModel(id, nombre, apellido, edad, telefono);
        return usuarioById;
    }
    
    
    //Método público de eliminación de usuario
    public boolean eliminar(int idUsuario){
        try{
            String sql = DELETE + Integer.toString(idUsuario);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            res = true;
            connection.close();
            return res;
        }catch(SQLException e){
            res = false;
            return res;
        }
    }
    
    //Método público para actualizar un usuario
    public boolean actualizar(pruebaApiUsuarioModel objUsuario){
         try{
            //Obtenemos la conexión
            connection = con.getConnection();
            //Preparamos la consulta
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            
            //Asignamos los valores a los campos de la consulta sql
            statement.setString(1, objUsuario.getNombre());
            statement.setString(2, objUsuario.getApellido());
            statement.setInt(3, objUsuario.getEdad());
            statement.setString(4, objUsuario.getTelefono());
            statement.setInt(5, objUsuario.getId());
            statement.execute();
            connection.close();
            
            res = true;
            return res;
        }catch(SQLException e){
            res = false;
            return res;
        }
    }
}
