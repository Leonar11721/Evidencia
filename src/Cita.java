import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cita {

    String identificador;
    String fechaHora;
    String motivo;
    Doctor doctor;
    Paciente paciente;

    public Cita(
            String identificador,
            String fechaHora,
            String motivo,
            Doctor doctor,
            Paciente paciente) {

        this.identificador = identificador;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public void guardar() {

        try {
            FileWriter archivo = new FileWriter("db/citas.csv", true);

            archivo.write(
                    identificador + "," +
                            fechaHora + "," +
                            motivo + "," +
                            doctor.identificador + "," +
                            paciente.identificador + "\n"
            );

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al guardar la cita.");
        }
    }

    public static boolean existeIdentificador(String identificador) {

        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("db/citas.csv")
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
            System.out.println("Error al leer las citas.");
        }

        return false;
    }
}