import Conection.dbConnection;
import DDBBServices.AnimalesServices;
import Modelos.Animales;
import ServiciosSerializar.SerializarService;
import ServiciosXML.XMLService;

import javax.xml.parsers.SAXParser;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        dbConnection dbConn = new dbConnection();
        Connection conn = dbConn.conectar();
        SerializarService serializarService = new SerializarService();

        if(conn != null) {
            System.out.println("Conexion exitosa");
        } else {
            System.out.println("fallo");
        }

        //Inserción de datos
        /*AnimalesServices.insertarAnimal("Tigre","Panthera tigris",3);
        AnimalesServices.insertarAnimal("Elefante","Loxodonta africana",2);
        AnimalesServices.insertarAnimal("Lemur","Lemur catta",5);
        AnimalesServices.insertarAnimal("Xirafa","Giraffa camelopardalis",4);
        AnimalesServices.insertarAnimal("Oso Panda","Ailuropoda melanoleuca",2);
        AnimalesServices.insertarAnimal("Hipopotamo","Hippopotamus amphibius",3);
        AnimalesServices.insertarAnimal("Leon","Panthera leo",6);
        */

        System.out.println("Lendo a táboa!");
        List<Animales> listAnimales = AnimalesServices.leerAnimales();

        System.out.println("id  -  nome");
        System.out.println(listAnimales.get(0).getId() + " - " + listAnimales.get(0).getNombre());
        System.out.println(listAnimales.get(1).getId() + " - " + listAnimales.get(1).getNombre());
        System.out.println(listAnimales.get(2).getId() + " - " + listAnimales.get(2).getNombre());
        System.out.println(listAnimales.get(3).getId() + " - " + listAnimales.get(3).getNombre());
        System.out.println(listAnimales.get(4).getId() + " - " + listAnimales.get(4).getNombre());
        System.out.println(listAnimales.get(5).getId() + " - " + listAnimales.get(5).getNombre());
        System.out.println(listAnimales.get(6).getId() + " - " + listAnimales.get(6).getNombre());

        System.out.println("Exportando copia de seguridad!");

        SerializarService.SerializarAnimales(listAnimales);

        System.out.println("Copia de seguridad feita, modificando valores");

        /*AnimalesServices.actualizarCantidadAnimales(listAnimales,3);*/

        System.out.println("Valores modificados");

        System.out.println(listAnimales.get(0).getId() + " - " + listAnimales.get(0).getNombre() + " - " + listAnimales.get(0).getCantidad());
        System.out.println(listAnimales.get(1).getId() + " - " + listAnimales.get(1).getNombre() + " - " + listAnimales.get(1).getCantidad());
        System.out.println(listAnimales.get(2).getId() + " - " + listAnimales.get(2).getNombre() + " - " + listAnimales.get(2).getCantidad());
        System.out.println(listAnimales.get(3).getId() + " - " + listAnimales.get(3).getNombre() + " - " + listAnimales.get(3).getCantidad());
        System.out.println(listAnimales.get(4).getId() + " - " + listAnimales.get(4).getNombre() + " - " + listAnimales.get(4).getCantidad());
        System.out.println(listAnimales.get(5).getId() + " - " + listAnimales.get(5).getNombre() + " - " + listAnimales.get(5).getCantidad());
        System.out.println(listAnimales.get(6).getId() + " - " + listAnimales.get(6).getNombre() + " - " + listAnimales.get(6).getCantidad());

        System.out.println("Restaurando valores");

        List<Animales> listAnimalesRestaurados = SerializarService.DeserializarAnimales("animalesSerial");

        System.out.println("Valor restaurado, generando informe");

        //System.out.println(listAnimalesRestaurados);

        Animales animal1 =  listAnimalesRestaurados.get(0);
        XMLService.crearXML(animal1);
    }
}