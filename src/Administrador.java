import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Administrador {

    String identificador;
    String contrasena;

    public Administrador(String identificador, String contrasena) {
        this.identificador = identificador;
        this.contrasena = contrasena;
    }

    public void guardar() {
        try {
            FileWriter archivo = new FileWriter(
                    "db/administradores.csv", true
            );

            archivo.write(
                    identificador + "," +
                            contrasena + "\n"
            );

            archivo.close();

        } catch (IOException e) {
            System.out.println(
                    "Error al guardar el administrador."
            );
        }
    }

    public static void inicializar() {

        try {

            File carpeta = new File("db");

            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            File archivoAdministradores =
                    new File("db/administradores.csv");

            if (!archivoAdministradores.exists()
                    || archivoAdministradores.length() == 0) {

                Administrador administrador =
                        new Administrador(
                                "admin",
                                "1234"
                        );

                administrador.guardar();

            }

        } catch (Exception e) {

            System.out.println(
                    "Error al inicializar los administradores."
            );
        }
    }

    public static Administrador buscarPorIdentificador(
            String identificador) {

        try {

            BufferedReader archivo =
                    new BufferedReader(
                            new FileReader(
                                    "db/administradores.csv"
                            )
                    );

            String linea;

            while ((linea = archivo.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length >= 2
                        && datos[0].equals(identificador)) {

                    archivo.close();

                    return new Administrador(
                            datos[0],
                            datos[1]
                    );
                }
            }

            archivo.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al leer los administradores."
            );
        }

        return null;
    }
}