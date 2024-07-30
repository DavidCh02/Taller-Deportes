import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Campeonato implements Estadisticas {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String sistema;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Campeonato(int id, String nombre, Date fechaInicio, Date fechaFin, String sistema) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sistema = sistema;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    @Override
    public void mostrarEstadisticas() {
        // Implementar lógica para mostrar estadísticas
    }
}
