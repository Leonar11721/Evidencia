import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Paciente {

    String identificador;
    String nombre;

    public Paciente(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public void guardar() {

        try {
            FileWriter archivo = new FileWriter("db/pacientes.csv", true);

            archivo.write(
                    identificador + "," +
                            nombre + "\n"
            );

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al guardar el paciente.");
        }
    }

    public static boolean existeIdentificador(String identificador) {

        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("db/pacientes.csv")
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
            System.out.println("Error al leer los pacientes.");
        }

        return false;
    }

    public static Paciente buscarPorIdentificador(String identificador) {

        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("db/pacientes.csv")
            );

            String linea;

            while ((linea = archivo.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[0].equals(identificador)) {

                    archivo.close();

                    return new Paciente(
                            datos[0],
                            datos[1]
                    );
                }
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al leer los pacientes.");
        }

        return null;
    }
}