/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDNR;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import Modelo.Alumno;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.MongoException;

/**
 *
 * @author Jose
 */
public class QueryManager {
    private Conexion conexion = new Conexion();
    
    
    public boolean createQR(Alumno alumno) {
        boolean B;
        try {
            // Establecer conexión con la base de datos MongoDB
            conexion.estableceonexion();

            // Obtener la colección "alumnos"
            MongoCollection<Document> collection = conexion.getDatabase().getCollection("alumnos");

            // Encontrar el documento con el id más alto
            Document lastDoc = collection.find()
                                         .sort(new Document("id", -1)) // Ordenar por id en orden descendente
                                         .first(); // Obtener el primer documento (el de id más alto)

            int newId = 1; // Valor por defecto si la colección está vacía

            if (lastDoc != null) {
                newId = lastDoc.getInteger("id") + 1;
            }

            // Crear un documento con el nuevo id y los datos del alumno
            Document doc = new Document("id", newId)
                    .append("nombre", alumno.getNombre())
                    .append("apellido", alumno.getApellido());

            // Insertar el documento en la colección
            collection.insertOne(doc);
            B = true; // Indicar que la operación fue exitosa
        } catch (MongoException E) {
            E.printStackTrace();
            B = false; // Indicar que la operación falló
        } finally {
            // Cerrar la conexión con la base de datos
            conexion.cerrarConexion();
        }

        return B;
    }


    public List<Alumno> ReadQR() {
        conexion.estableceonexion();
        List<Alumno> listaAlumnos = new ArrayList<>();
        MongoCollection<Document> collection = conexion.getDatabase().getCollection("alumnos");
        for (Document doc : collection.find()) {
            Alumno alumno = new Alumno(
                    doc.getInteger("id"),
                    doc.getString("nombre"),
                    doc.getString("apellido")
            );
            listaAlumnos.add(alumno);
        }
        conexion.cerrarConexion();
        return listaAlumnos;
    }

    // Update
    public boolean updateQR(Alumno alumno,int id) {
        Boolean B;
        try{
        conexion.estableceonexion();
        MongoCollection<Document> collection = conexion.getDatabase().getCollection("alumnos");
        Bson filter = Filters.eq("id", id);
        Bson updates = Updates.combine(
            Updates.set("nombre", alumno.getNombre()),
            Updates.set("apellido", alumno.getApellido())
        );
        collection.updateOne(filter, updates);
        B=true;
        }catch(MongoException e){
            e.printStackTrace();
            B=false;
        }
        conexion.cerrarConexion();
        return B;
    }

    // Delete
    public boolean delete(int id) {
        Boolean B;
        try{
            conexion.estableceonexion();
            MongoCollection<Document> collection = conexion.getDatabase().getCollection("alumnos");
            Bson filter = eq("id", id);
            DeleteResult result = collection.deleteOne(filter);
            if (result.getDeletedCount() > 0) {
                B=true;
            } else {
                B=false;
            }
        }catch(MongoException e){
            e.printStackTrace();
            B=false;
        }
        conexion.cerrarConexion();
        return B;
    }

}
