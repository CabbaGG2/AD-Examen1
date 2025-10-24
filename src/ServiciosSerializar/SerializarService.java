package ServiciosSerializar;

import Modelos.Animales;

import java.io.*;
import java.util.List;

public class SerializarService {

    public static void SerializarAnimales(List<Animales> animales) {
        try (FileOutputStream fos = new FileOutputStream("animalesSerial");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animales);
            System.out.println("Lista guardada con éxito en el fichero: 'animalesSerial'");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public static List<Animales> DeserializarAnimales(String ruta) {
        try (FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Animales> lista = (List<Animales>) ois.readObject();
            return lista;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }

        return null;
    }

}
