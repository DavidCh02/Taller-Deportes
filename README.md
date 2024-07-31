# Sistema de Campeonatos

Este proyecto es un sistema de campeonatos que permite crear campeonatos, registrar equipos, iniciar partidos y mostrar estadísticas. Está desarrollado en Java y utiliza una interfaz de consola para la interacción con el usuario. A sido mejorado a la primera version que falatab de implementar siertas funciones.

## Características

- **Crear Campeonato**: Permite al usuario crear un nuevo campeonato ingresando el ID, nombre, fecha de inicio, fecha de fin y sistema del campeonato.
- **Eliminar Campeonato**: Permite al usuario eliminar un campeonato existente.
- **Registrar Equipo en Campeonato**: Permite al usuario registrar un nuevo equipo en un campeonato existente ingresando el nombre del equipo.
- **Iniciar Partido**: Permite al usuario iniciar un partido entre dos equipos seleccionados de un campeonato, ingresando la fecha, hora y los goles de cada equipo. Si el partido termina en empate, se ingresan los goles de penales.
- **Mostrar Estadísticas**: Permite al usuario ver las estadísticas del campeonato, incluyendo la tabla de posiciones.


## Digrama de clases actualizado y mejorado

![Campeonato Mejorado](https://github.com/user-attachments/assets/f62befde-cee8-4149-8665-b12c5dee1726)


## Cambios Realizados a diferencia de la primera version 
Se agrego una tabla de posciones que se mostrara en "Estadisticas" ademas de cambiar la clase "Penales" por un metodo en "Partido" y ademas de agregar algunas validaciones 
## Funcionalidades

1. **Menú Principal**: Muestra un menú con las opciones disponibles:
    - Crear Campeonato
    - Eliminar Campeonato
    - Registrar Equipo en Campeonato
    - Iniciar Partido
    - Mostrar Estadísticas
    - Salir

2. **Crear Campeonato**:
    - Solicita al usuario ingresar el ID, nombre, fecha de inicio, fecha de fin y sistema del campeonato.
    - Crea un nuevo campeonato con los datos ingresados.

3. **Eliminar Campeonato**:
    - Permite al usuario eliminar un campeonato existente (implementación pendiente).

4. **Registrar Equipo en Campeonato**:
    - Solicita al usuario ingresar el nombre del equipo.
    - Registra el equipo en el campeonato seleccionado.

5. **Iniciar Partido**:
    - Solicita al usuario ingresar el ID del partido.
    - Permite al usuario seleccionar el campeonato, equipo local y equipo visitante.
    - Solicita la fecha y hora del partido.
    - Solicita los goles del equipo local y visitante.
    - Si el partido termina en empate, solicita los goles de penales.
    - Registra el resultado del partido y lo agrega al campeonato.

6. **Mostrar Estadísticas**:
    - Muestra la tabla de posiciones del campeonato seleccionado.


  ## Diagrama anterior

![Campeonato Fut](https://github.com/user-attachments/assets/22a35b03-e337-4026-ace3-6d38b735ff1e)


## Requisitos

- Java 8 o superior
- IDE recomendado: IntelliJ IDEA 2024.1

## Ejecución

Para ejecutar el proyecto, compile todas las clases y ejecute la clase `Main`:
```java
public class Main {
    public static void main(String[] args) {
        InterfazConsola interfaz = new InterfazConsola();
        interfaz.mostrarMenuPrincipal();
    }
}

