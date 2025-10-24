package DDBBServices;

import Conection.dbConnection;
import Modelos.Animales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalesServices {

    public static void insertarAnimal(String nombre, String especie, int cantidad) {
        String sql = "INSERT INTO animais (nome, especie, cantidade) VALUES (?,?,?)";

        try (Connection conn = dbConnection.conectar();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1,nombre);
            toInsert.setString(2,especie);
            toInsert.setInt(3,cantidad);
            toInsert.executeUpdate();
            System.out.println("Entrada insertada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());
        }
    }

    public static List<Animales> leerAnimales() {
        String sql = "SELECT * FROM animais";
        List<Animales> listAnimales = new ArrayList<>();

        try (Connection conn = dbConnection.conectar();
            PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet resultSet = toRead.executeQuery()){

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nome");
                String especie = resultSet.getString("especie");
                int cantidad = resultSet.getInt("cantidade");

                Animales animal = new Animales(id,nombre,especie,cantidad);
                listAnimales.add(animal);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listAnimales;
    }

    public static void actualizarCantidadAnimales(List<Animales> animales, int numero) {
        String sql = "UPDATE animais SET cantidade = cantidade * ?";

        try (Connection conn = dbConnection.conectar();
            PreparedStatement actualizar = conn.prepareStatement(sql)) {
            actualizar.setInt(1,numero);

            int filasAfectadas = actualizar.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Entradas actualizadas correctamente");
            } else {
                System.out.println("No se logró actualizar las cantidades");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la entrada: " + e.getMessage());
        }
    }


}
