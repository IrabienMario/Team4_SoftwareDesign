/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDNR;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
/**
 *
 * @author Jose
 */
public class Conexion {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public void estableceonexion() {
        String servidor = "mongodb://localhost:27017";
        try {
            mongoClient = MongoClients.create(servidor);
            database = mongoClient.getDatabase("ClaseMuestra"); // Cambia "mi_base_de_datos" por el nombre de tu base de datos
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    public MongoDatabase getDatabase(){
        return database;
    }
    public void cerrarConexion() {
    mongoClient.close();
    }
    
}

