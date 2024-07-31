import java.util.*;

public class Campeonato {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String sistema;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private Map<Equipo, Integer> tablaPosiciones;

    public Campeonato(int id, String nombre, Date fechaInicio, Date fechaFin, String sistema) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sistema = sistema;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.tablaPosiciones = new HashMap<>();
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
        tablaPosiciones.put(equipo, 0);
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
        actualizarTablaPosiciones(partido);
    }

    private void actualizarTablaPosiciones(Partido partido) {
        Resultado resultado = partido.getResultado();
        if (resultado != null) {
            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();
            if (resultado.esEmpate()) {
                Resultado resultadoPenales = partido.getResultadoPenales();
                if (resultadoPenales != null) {
                    if (resultadoPenales.getGolesLocal() > resultadoPenales.getGolesVisitante()) {
                        tablaPosiciones.put(local, tablaPosiciones.get(local) + 3);
                    } else {
                        tablaPosiciones.put(visitante, tablaPosiciones.get(visitante) + 3);
                    }
                } else {
                    tablaPosiciones.put(local, tablaPosiciones.get(local) + 1);
                    tablaPosiciones.put(visitante, tablaPosiciones.get(visitante) + 1);
                }
            } else {
                if (resultado.getGolesLocal() > resultado.getGolesVisitante()) {
                    tablaPosiciones.put(local, tablaPosiciones.get(local) + 3);
                } else {
                    tablaPosiciones.put(visitante, tablaPosiciones.get(visitante) + 3);
                }
            }
        }
    }

    public void mostrarTablaPosiciones() {
        System.out.println("Tabla de posiciones:");
        for (Map.Entry<Equipo, Integer> entry : tablaPosiciones.entrySet()) {
            System.out.println(entry.getKey().getNombre() + ": " + entry.getValue() + " puntos");
        }
    }

    public void mostrarEstadisticas() {
        mostrarTablaPosiciones();
    }
}