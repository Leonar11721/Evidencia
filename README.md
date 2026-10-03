# Sistema de Administración de Citas

Programa desarrollado en Java para simular un sistema de administración de citas para un consultorio clínico.

El sistema permite registrar doctores, registrar pacientes, crear citas y controlar el acceso mediante administradores.

## Instalación y configuración

Para ejecutar el programa se requiere:

- JDK 11.
- IntelliJ IDEA.
- Git.

### Configuración

1. Clonar el repositorio desde GitHub.
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar el proyecto para utilizar JDK 11.
4. Verificar que exista la carpeta `db`.
5. Ejecutar la clase `Main.java`.

Los archivos de información del sistema se almacenan en formato CSV dentro de la carpeta `db`.

## Uso del programa

Al iniciar el programa se solicita el identificador y la contraseña de un administrador.

Después de iniciar sesión correctamente, se muestra el menú principal con las siguientes opciones:

1. Registrar doctor.
2. Registrar paciente.
3. Crear cita.
4. Salir.

### Registrar doctor

Permite registrar:

- Identificador.
- Nombre completo.
- Especialidad.

El sistema verifica que el identificador no esté registrado previamente.

### Registrar paciente

Permite registrar:

- Identificador.
- Nombre completo.

El sistema verifica que el identificador no esté registrado previamente.

### Crear cita

Permite registrar:

- Identificador de la cita.
- Fecha y hora.
- Motivo.
- Doctor.
- Paciente.

El sistema verifica que el doctor y el paciente existan antes de guardar la cita.

## Créditos

Proyecto desarrollado por:

**Leonardo**

Avance 1 Evidencia de Computación en Java.

## Licencia

Este proyecto fue desarrollado con fines académicos.