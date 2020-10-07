package com.pruebascm.Conexion;

//Librerías útiles para nuestra conexión y gestión de base de datos
import java.sql.Connection;
import java.sql.SQLException; //Manejo de excepcion de DB
import javax.sql.DataSource; //Manejo de DB correspondiente
import org.apache.commons.dbcp2.BasicDataSource; //Manejo de driver de DB

public class Conexion {
    //Variable de tipo Conexión
    Connection con;
    //Variable de tipo DataSource
    BasicDataSource dataSource = null;
    
    //Método para crear la conexión 
    DataSource getDataSource(){
        if(dataSource == null){
            //Instanciar una nueva conexión
            dataSource = new BasicDataSource();
            //Definición de driver
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            //Ingreso de username y password de DB
            dataSource.setUsername("gearsgtc_javaser");
            dataSource.setPassword("Nfyxrz15ne03");
            //Ingreso de url del servidor de DB
            dataSource.setUrl("jdbc:mysql://dnzmakers.com:3306/gearsgtc_hospital_java?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false");
            //Tamaño inicial de conexiones
            dataSource.setInitialSize(20);
            //Indica tiempo de sincronización en segundos
            dataSource.setMaxIdle(15);
            //Número de conexiones totales
            dataSource.setMaxTotal(1);
            //Tiempo de espera de respuesta en milisegundos
            dataSource.setMaxWaitMillis(5000);
        }
        return dataSource;
    }
    
    //Método público para obtener la conexión
    public Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
}
