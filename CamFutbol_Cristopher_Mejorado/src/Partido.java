import java.util.Date;

public class Partido {
    private int id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Date fechaHora;
    private Resultado resultado;
    private Resultado resultadoPenales;

    public Partido(int id, Equipo equipoLocal, Equipo equipoVisitante, Date fechaHora) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaHora = fechaHora;
        this.resultado = null;
        this.resultadoPenales = null;
    }

    public int getId() {
        return id;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public Resultado getResultadoPenales() {
        return resultadoPenales;
    }

    public void registrarResultado(int golesLocal, int golesVisitante) {
        this.resultado = new Resultado(golesLocal, golesVisitante);
    }

    public void registrarResultadoPenales(int golesPenalesLocal, int golesPenalesVisitante) {
        this.resultadoPenales = new Resultado(golesPenalesLocal, golesPenalesVisitante);
    }
}