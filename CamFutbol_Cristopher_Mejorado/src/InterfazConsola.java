import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InterfazConsola {
    private SistemaCampeonatos sistema;

    public InterfazConsola() {
        sistema = new SistemaCampeonatos();
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Crear Campeonato");
            System.out.println("2. Eliminar Campeonato");
            System.out.println("3. Registrar Equipo en Campeonato");
            System.out.println("4. Iniciar Partido");
            System.out.println("5. Mostrar Estadísticas");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearCampeonato();
                    break;
                case 2:
                    sistema.eliminarCampeonato();
                    break;
                case 3:
                    registrarEquipoEnCampeonato();
                    break;
                case 4:
                    iniciarPartido();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void crearCampeonato() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ID del campeonato:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Ingrese nombre del campeonato:");
        String nombre = scanner.nextLine();
        LocalDate fechaInicio = Validaciones.leerFecha("Ingrese fecha de inicio (yyyy-mm-dd):");
        LocalDate fechaFin = Validaciones.leerFecha("Ingrese fecha de fin (yyyy-mm-dd):");
        System.out.println("Ingrese sistema del campeonato:");
        String sistema = scanner.nextLine();
        this.sistema.crearCampeonato(id, nombre, convertToDate(fechaInicio), convertToDate(fechaFin), sistema);
    }

    private void registrarEquipoEnCampeonato() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del equipo:");
        String nombre = scanner.nextLine();
        Equipo equipo = new Equipo(nombre);
        sistema.registrarEquipoEnCampeonato(equipo);
    }

    private void iniciarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ID del partido:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Campeonato campeonato = sistema.seleccionarCampeonato();
        if (campeonato == null) {
            System.out.println("No se seleccionó un campeonato válido.");
            return;
        }

        List<Equipo> equipos = campeonato.getEquipos();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados en el campeonato.");
            return;
        }

        System.out.println("Seleccione el equipo local:");
        Equipo equipoLocal = seleccionarEquipo(equipos);
        if (equipoLocal == null) {
            System.out.println("No se seleccionó un equipo local válido.");
            return;
        }

        System.out.println("Seleccione el equipo visitante:");
        Equipo equipoVisitante = seleccionarEquipo(equipos);
        if (equipoVisitante == null) {
            System.out.println("No se seleccionó un equipo visitante válido.");
            return;
        }

        LocalDate fecha = Validaciones.leerFecha("Ingrese fecha del partido (yyyy-mm-dd):");
        System.out.println("Ingrese hora del partido (hh:mm):");
        LocalTime hora = LocalTime.parse(scanner.nextLine());

        Date fechaHora = convertToDateTime(fecha, hora);
        Partido partido = new Partido(id, equipoLocal, equipoVisitante, fechaHora);
        sistema.iniciarPartido(partido);

        System.out.println("Ingrese goles del equipo local:");
        int golesLocal = scanner.nextInt();
        System.out.println("Ingrese goles del equipo visitante:");
        int golesVisitante = scanner.nextInt();
        partido.registrarResultado(golesLocal, golesVisitante);

        if (golesLocal == golesVisitante) {
            System.out.println("Empate! Ingrese goles de penales.");
            System.out.println("Goles penales del equipo local (" + equipoLocal.getNombre() + "):");
            int penalesLocal = scanner.nextInt();
            System.out.println("Goles penales del equipo visitante (" + equipoVisitante.getNombre() + "):");
            int penalesVisitante = scanner.nextInt();
            partido.registrarResultadoPenales(penalesLocal, penalesVisitante);
        }

        campeonato.agregarPartido(partido);
    }

    private Equipo seleccionarEquipo(List<Equipo> equipos) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= equipos.size()) {
            return equipos.get(seleccion - 1);
        }
        return null;
    }

    private void mostrarEstadisticas() {
        Campeonato campeonato = sistema.seleccionarCampeonato();
        if (campeonato != null) {
            campeonato.mostrarEstadisticas();
        }
    }

    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Date convertToDateTime(LocalDate localDate, LocalTime localTime) {
        return Date.from(localDate.atTime(localTime).atZone(ZoneId.systemDefault()).toInstant());
    }
}