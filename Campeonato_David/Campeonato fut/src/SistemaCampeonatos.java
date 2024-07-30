import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaCampeonatos {
    private List<Campeonato> campeonatos;

    public SistemaCampeonatos() {
        campeonatos = new ArrayList<>();
    }

    public void crearCampeonato(int id, String nombre, Date fechaInicio, Date fechaFin, String sistema) {
        Campeonato campeonato = new Campeonato(id, nombre, fechaInicio, fechaFin, sistema);
        campeonatos.add(campeonato);
    }

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void eliminarCampeonato(int id) {
        Campeonato campeonato = buscarCampeonatoPorId(id);
        if (campeonato != null) {
            campeonatos.remove(campeonato);
        }
    }

    public void registrarEquipoEnCampeonato(int campeonatoId, Equipo equipo) {
        Campeonato campeonato = buscarCampeonatoPorId(campeonatoId);
        if (campeonato != null) {
            campeonato.agregarEquipo(equipo);
        }
    }

    public void iniciarPartido(int campeonatoId, Partido partido) {
        Campeonato campeonato = buscarCampeonatoPorId(campeonatoId);
        if (campeonato != null) {
            campeonato.agregarPartido(partido);
        }
    }

    private Campeonato buscarCampeonatoPorId(int id) {
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.getId() == id) {
                return campeonato;
            }
        }
        return null;
    }
}
