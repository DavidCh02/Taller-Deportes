import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaCampeonatos {
    private List<Campeonato> campeonatos = new ArrayList<>();

    public SistemaCampeonatos() {
    }

    public void crearCampeonato(int id, String nombre, Date fechaInicio, Date fechaFin, String sistema) {
        Campeonato campeonato = new Campeonato(id, nombre, fechaInicio, fechaFin, sistema);
        campeonatos.add(campeonato);
    }

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void eliminarCampeonato() {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato != null) {
            campeonatos.remove(campeonato);
        }
    }

    public void registrarEquipoEnCampeonato(Equipo equipo) {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato != null) {
            campeonato.agregarEquipo(equipo);
        }
    }

    public void iniciarPartido(Partido partido) {
        Campeonato campeonato = seleccionarCampeonato();
        if (campeonato != null) {
            campeonato.agregarPartido(partido);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese goles del equipo local:");
            int golesLocal = scanner.nextInt();
            System.out.println("Ingrese goles del equipo visitante:");
            int golesVisitante = scanner.nextInt();
            partido.registrarResultado(golesLocal, golesVisitante);
        }
    }

    Campeonato seleccionarCampeonato() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un campeonato:");
        for (int i = 0; i < campeonatos.size(); i++) {
            System.out.println((i + 1) + ". " + campeonatos.get(i).getNombre());
        }
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= campeonatos.size()) {
            return campeonatos.get(seleccion - 1);
        }
        return null;
    }
}