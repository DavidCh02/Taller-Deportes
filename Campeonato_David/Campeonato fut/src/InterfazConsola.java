import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InterfazConsola {
    private SistemaCampeonatos sistema;
    private Scanner scanner;

    public InterfazConsola() {
        sistema = new SistemaCampeonatos();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("1. Crear Campeonato");
            System.out.println("2. Campeonatos");
            System.out.println("3. Marcadores");
            System.out.println("4. Eliminar Campeonato");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCampeonato();
                    break;
                case 2:
                    mostrarMenuCampeonatos();
                    break;
                case 3:
                    mostrarMenuMarcadores();
                    break;
                case 4:
                    eliminarCampeonato();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void crearCampeonato() {
        System.out.print("Ingrese el ID del campeonato: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el nombre del campeonato: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicioStr = scanner.next();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFinStr = scanner.next();
        System.out.print("Ingrese el sistema del campeonato: ");
        String sistemaStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio, fechaFin;
        try {
            fechaInicio = dateFormat.parse(fechaInicioStr);
            fechaFin = dateFormat.parse(fechaFinStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }

        sistema.crearCampeonato(id, nombre, fechaInicio, fechaFin, sistemaStr);
        System.out.println("Campeonato creado exitosamente.");
    }

    private void mostrarMenuCampeonatos() {
        System.out.println("1. Registrar Equipo");
        System.out.println("2. Iniciar Partido");
        System.out.println("3. Ver Marcadores");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                registrarEquipo();
                break;
            case 2:
                iniciarPartido();
                break;
            case 3:
                verMarcadores();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void mostrarMenuMarcadores() {
        while (true) {
            System.out.println("1. Ver Marcadores");
            System.out.println("2. Actualizar Marcador");
            System.out.println("3. Finalizar Partido");
            System.out.println("4. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verMarcadores();
                    break;
                case 2:
                    actualizarMarcador();
                    break;
                case 3:
                    finalizarPartido();
                    break;
                case 4:
                    return;  // Salir del menú de marcadores y regresar al menú principal
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void registrarEquipo() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        System.out.print("Ingrese el ID del equipo: ");
        int equipoId = scanner.nextInt();
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();

        Equipo equipo = new Equipo(equipoId, nombreEquipo);
        sistema.registrarEquipoEnCampeonato(campeonato.getId(), equipo);
        System.out.println("Equipo registrado exitosamente.");
    }

    private void iniciarPartido() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        System.out.print("Ingrese el ID del partido: ");
        int partidoId = scanner.nextInt();
        System.out.print("Ingrese el ID del equipo local: ");
        int equipoLocalId = scanner.nextInt();
        System.out.print("Ingrese el ID del equipo visitante: ");
        int equipoVisitanteId = scanner.nextInt();
        System.out.print("Ingrese la fecha (yyyy-MM-dd): ");
        String fechaStr = scanner.next();
        System.out.print("Ingrese la hora de inicio (HH:mm): ");
        String horaStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date fechaHora;
        try {
            fechaHora = dateFormat.parse(fechaStr + " " + horaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha u hora inválido.");
            return;
        }

        Equipo equipoLocal = new Equipo(equipoLocalId, "Local");
        Equipo equipoVisitante = new Equipo(equipoVisitanteId, "Visitante");
        Partido partido = new Partido(partidoId, equipoLocal, equipoVisitante, fechaHora, fechaHora);

        sistema.iniciarPartido(campeonato.getId(), partido);
        System.out.println("Partido iniciado exitosamente.");
    }

    private void verMarcadores() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        for (Partido partido : campeonato.getPartidos()) {
            Marcador marcador = partido.getMarcador();
            System.out.println("Partido ID: " + partido.getId() +
                    " | Local: " + marcador.getGolesLocal() +
                    " | Visitante: " + marcador.getGolesVisitante());
        }
    }

    private void actualizarMarcador() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        Partido partido = seleccionarPartido(campeonato);
        if (partido == null) return;

        System.out.print("Ingrese los goles del equipo local: ");
        int golesLocal = scanner.nextInt();
        System.out.print("Ingrese los goles del equipo visitante: ");
        int golesVisitante = scanner.nextInt();

        partido.registrarMarcador(golesLocal, golesVisitante);
        System.out.println("Marcador actualizado exitosamente.");
    }

    private void finalizarPartido() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        Partido partido = seleccionarPartido(campeonato);
        if (partido == null) return;

        System.out.println("Partido finalizado. Marcador final: Local " + partido.getMarcador().getGolesLocal() +
                " - Visitante " + partido.getMarcador().getGolesVisitante());
    }

    private void eliminarCampeonato() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato == null) return;

        sistema.eliminarCampeonato(campeonato.getId());
        System.out.println("Campeonato eliminado exitosamente.");
    }

    private Campeonato seleccionarCampeonato() {
        List<Campeonato> campeonatos = sistema.getCampeonatos();
        if (campeonatos.isEmpty()) {
            System.out.println("No hay campeonatos registrados.");
            return null;
        }

        System.out.println("Seleccione un campeonato:");
        for (int i = 0; i < campeonatos.size(); i++) {
            Campeonato campeonato = campeonatos.get(i);
            System.out.println((i + 1) + ". " + campeonato.getId() + " - " + campeonato.getNombre());
        }

        System.out.print("Ingrese el número del campeonato: ");
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > campeonatos.size()) {
            System.out.println("Opción inválida.");
            return null;
        }

        return campeonatos.get(opcion - 1);
    }

    private Partido seleccionarPartido(Campeonato campeonato) {
        List<Partido> partidos = campeonato.getPartidos();
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados en este campeonato.");
            return null;
        }

        System.out.println("Seleccione un partido:");
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            System.out.println((i + 1) + ". Partido ID: " + partido.getId() +
                    " | Local: " + partido.getEquipoLocal().getNombre() +
                    " vs Visitante: " + partido.getEquipoVisitante().getNombre() +
                    " | Fecha: " + partido.getFechaHora());
        }

        System.out.print("Ingrese el número del partido: ");
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > partidos.size()) {
            System.out.println("Opción inválida.");
            return null;
        }

        return partidos.get(opcion - 1);
    }

    private Equipo seleccionarEquipo(Campeonato campeonato) {
        List<Equipo> equipos = campeonato.getEquipos();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados en este campeonato.");
            return null;
        }

        System.out.println("Seleccione un equipo:");
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            System.out.println((i + 1) + ". Equipo ID: " + equipo.getId() + " - " + equipo.getNombre());
        }

        System.out.print("Ingrese el número del equipo: ");
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > equipos.size()) {
            System.out.println("Opción inválida.");
            return null;
        }

        return equipos.get(opcion - 1);
    }
}
