import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CITAS ===");

        System.out.print("Identificador: ");
        String identificador = scanner.nextLine();

        Administrador administrador =
                Administrador.buscarPorIdentificador(
                        identificador
                );

        if (administrador == null) {

            System.out.println(
                    "Administrador no encontrado."
            );

        } else {

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

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

                        System.out.print(
                                "Identificador: "
                        );

                        String identificadorDoctor =
                                scanner.nextLine();

                        if (Doctor.existeIdentificador(
                                identificadorDoctor)) {

                            System.out.println(
                                    "Ese identificador ya existe."
                            );

                        } else {

                            System.out.print(
                                    "Nombre completo: "
                            );

                            String nombreDoctor =
                                    scanner.nextLine();

                            System.out.print(
                                    "Especialidad: "
                            );

                            String especialidadDoctor =
                                    scanner.nextLine();

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

                        System.out.print(
                                "Identificador: "
                        );

                        String identificadorPaciente =
                                scanner.nextLine();

                        if (Paciente.existeIdentificador(
                                identificadorPaciente)) {

                            System.out.println(
                                    "Ese identificador ya existe."
                            );

                        } else {

                            System.out.print(
                                    "Nombre completo: "
                            );

                            String nombrePaciente =
                                    scanner.nextLine();

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

                        System.out.print(
                                "Identificador de la cita: "
                        );

                        String identificadorCita =
                                scanner.nextLine();

                        if (Cita.existeIdentificador(
                                identificadorCita)) {

                            System.out.println(
                                    "Ese identificador de cita ya existe."
                            );

                        } else {

                            System.out.print(
                                    "Fecha y hora: "
                            );

                            String fechaHora =
                                    scanner.nextLine();

                            System.out.print(
                                    "Motivo: "
                            );

                            String motivo =
                                    scanner.nextLine();

                            System.out.print(
                                    "Identificador del doctor: "
                            );

                            String identificadorDoctor =
                                    scanner.nextLine();

                            Doctor doctor =
                                    Doctor.buscarPorIdentificador(
                                            identificadorDoctor
                                    );

                            if (doctor == null) {

                                System.out.println(
                                        "El doctor no existe."
                                );

                            } else {

                                System.out.print(
                                        "Identificador del paciente: "
                                );

                                String identificadorPaciente =
                                        scanner.nextLine();

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
}