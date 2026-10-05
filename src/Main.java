import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inicializa el administrador si el archivo no existe o está vacío
        Administrador.inicializar();

        System.out.println("=== SISTEMA DE CITAS ===");

        String identificador =
                leerTextoNoVacio(
                        scanner,
                        "Identificador: "
                );

        Administrador administrador =
                Administrador.buscarPorIdentificador(
                        identificador
                );

        if (administrador == null) {

            System.out.println(
                    "Administrador no encontrado."
            );

        } else {

            String contrasena =
                    leerTextoNoVacio(
                            scanner,
                            "Contraseña: "
                    );

            if (contrasena.equals(administrador.contrasena)) {

                System.out.println(
                        "Acceso concedido."
                );

                int opcion = 0;

                while (opcion != 4) {

                    System.out.println();
                    System.out.println(
                            "=== MENÚ PRINCIPAL ==="
                    );

                    System.out.println(
                            "1. Registrar doctor"
                    );

                    System.out.println(
                            "2. Registrar paciente"
                    );

                    System.out.println(
                            "3. Crear cita"
                    );

                    System.out.println(
                            "4. Salir"
                    );

                    System.out.print(
                            "Seleccione una opción: "
                    );

                    String entrada = scanner.nextLine();

                    try {

                        opcion = Integer.parseInt(
                                entrada
                        );

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Debe ingresar un número."
                        );

                        continue;
                    }

                    if (opcion == 1) {

                        System.out.println();
                        System.out.println(
                                "=== REGISTRAR DOCTOR ==="
                        );

                        String identificadorDoctor =
                                leerTextoNoVacio(
                                        scanner,
                                        "Identificador: "
                                );

                        if (Doctor.existeIdentificador(
                                identificadorDoctor)) {

                            System.out.println(
                                    "Ese identificador ya existe."
                            );

                        } else {

                            String nombreDoctor =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Nombre completo: "
                                    );

                            String especialidadDoctor =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Especialidad: "
                                    );

                            Doctor doctor = new Doctor(
                                    identificadorDoctor,
                                    nombreDoctor,
                                    especialidadDoctor
                            );

                            doctor.guardar();

                            System.out.println(
                                    "Doctor guardado correctamente."
                            );
                        }

                    } else if (opcion == 2) {

                        System.out.println();
                        System.out.println(
                                "=== REGISTRAR PACIENTE ==="
                        );

                        String identificadorPaciente =
                                leerTextoNoVacio(
                                        scanner,
                                        "Identificador: "
                                );

                        if (Paciente.existeIdentificador(
                                identificadorPaciente)) {

                            System.out.println(
                                    "Ese identificador ya existe."
                            );

                        } else {

                            String nombrePaciente =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Nombre completo: "
                                    );

                            Paciente paciente =
                                    new Paciente(
                                            identificadorPaciente,
                                            nombrePaciente
                                    );

                            paciente.guardar();

                            System.out.println(
                                    "Paciente guardado correctamente."
                            );
                        }

                    } else if (opcion == 3) {

                        System.out.println();
                        System.out.println(
                                "=== CREAR CITA ==="
                        );

                        String identificadorCita =
                                leerTextoNoVacio(
                                        scanner,
                                        "Identificador de la cita: "
                                );

                        if (Cita.existeIdentificador(
                                identificadorCita)) {

                            System.out.println(
                                    "Ese identificador de cita ya existe."
                            );

                        } else {

                            String fechaHora =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Fecha y hora: "
                                    );

                            String motivo =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Motivo: "
                                    );

                            String identificadorDoctor =
                                    leerTextoNoVacio(
                                            scanner,
                                            "Identificador del doctor: "
                                    );

                            Doctor doctor =
                                    Doctor.buscarPorIdentificador(
                                            identificadorDoctor
                                    );

                            if (doctor == null) {

                                System.out.println(
                                        "El doctor no existe."
                                );

                            } else {

                                String identificadorPaciente =
                                        leerTextoNoVacio(
                                                scanner,
                                                "Identificador del paciente: "
                                        );

                                Paciente paciente =
                                        Paciente.buscarPorIdentificador(
                                                identificadorPaciente
                                        );

                                if (paciente == null) {

                                    System.out.println(
                                            "El paciente no existe."
                                    );

                                } else {

                                    Cita cita = new Cita(
                                            identificadorCita,
                                            fechaHora,
                                            motivo,
                                            doctor,
                                            paciente
                                    );

                                    cita.guardar();

                                    System.out.println();
                                    System.out.println(
                                            "Cita guardada correctamente."
                                    );

                                    System.out.println(
                                            "Doctor: "
                                                    + doctor.nombre
                                    );

                                    System.out.println(
                                            "Paciente: "
                                                    + paciente.nombre
                                    );
                                }
                            }
                        }

                    } else if (opcion == 4) {

                        System.out.println(
                                "Saliendo del sistema..."
                        );

                    } else {

                        System.out.println(
                                "Opción no válida."
                        );
                    }
                }

            } else {

                System.out.println(
                        "Contraseña incorrecta."
                );
            }
        }

        scanner.close();
    }

    public static String leerTextoNoVacio(
            Scanner scanner,
            String mensaje) {

        String texto;

        do {

            System.out.print(mensaje);

            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {

                System.out.println(
                        "Este campo no puede estar vacío."
                );
            }

        } while (texto.isEmpty());

        return texto;
    }
}