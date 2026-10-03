import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Doctor {

    String identificador;
    String nombre;
    String especialidad;

    public Doctor(String identificador, String nombre, String especialidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void guardar() {

        try {
            FileWriter archivo = new FileWriter("db/doctores.csv", true);

            archivo.write(
                    identificador + "," +
                            nombre + "," +
                            especialidad + "\n"
            );

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al guardar el doctor.");
        }
    }

    public static boolean existeIdentificador(String identificador) {

        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("db/doctores.csv")
            );

            String linea;

            while ((linea = archivo.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[0].equals(identificador)) {
                    archivo.close();
                    return true;
                }
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al leer los doctores.");
        }

        return false;
    }

    public static Doctor buscarPorIdentificador(String identificador) {

        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("db/doctores.csv")
            );

            String linea;

            while ((linea = archivo.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[0].equals(identificador)) {

                    archivo.close();

                    return new Doctor(
                            datos[0],
                            datos[1],
                            datos[2]
                    );
                }
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al leer los doctores.");
        }

        return null;
    }
}