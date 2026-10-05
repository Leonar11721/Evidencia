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

La aplicación crea automáticamente la carpeta `db` y los archivos necesarios cuando no existen.

Los archivos generados son:

- `administradores.csv`
- `doctores.csv`
- `pacientes.csv`
- `citas.csv`

## Uso del programa

Al iniciar el programa se solicita el identificador y la contraseña de un administrador.

El administrador inicial utilizado por el sistema es:

- Identificador: `admin`
- Contraseña: `1234`

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

El sistema verifica que el identificador no esté registrado previamente y que los campos obligatorios no estén vacíos.

### Registrar paciente

Permite registrar:

- Identificador.
- Nombre completo.

El sistema verifica que el identificador no esté registrado previamente y que los campos obligatorios no estén vacíos.

### Crear cita

Permite registrar:

- Identificador de la cita.
- Fecha y hora.
- Motivo.
- Doctor.
- Paciente.

El sistema verifica que el identificador de la cita no esté registrado previamente y que tanto el doctor como el paciente existan antes de guardar la cita.

### Control de acceso

El sistema solicita un identificador y una contraseña antes de permitir el acceso al menú principal.

Si las credenciales son incorrectas, el acceso es rechazado.

### Ejecución mediante JAR

La aplicación puede ejecutarse mediante el archivo JAR generado por IntelliJ IDEA.

Desde la carpeta donde se encuentra `Consultorio.jar`, ejecutar:

`bash
java -jar Consultorio.jar`

La aplicación puede ejecutarse sin abrir el proyecto desde IntelliJ IDEA, siempre que el equipo tenga instalado Java 11.
### Créditos

Proyecto desarrollado por:

Leonardo Peralta

Evidencia de Computación en Java.

### Licencia

Este proyecto fue desarrollado con fines académicos.

