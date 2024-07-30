import java.util.Date;

public class Partido {
    private int id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Date fechaHora;
    private Marcador marcador;

    public Partido(int id, Equipo equipoLocal, Equipo equipoVisitante, Date fechaHora, Date hora) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaHora = fechaHora;
        this.marcador = new Marcador();
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

    public Marcador getMarcador() {
        return marcador;
    }

    public void registrarMarcador(int golesLocal, int golesVisitante) {
        marcador.setGolesLocal(golesLocal);
        marcador.setGolesVisitante(golesVisitante);
    }
}
