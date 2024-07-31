

public class Jugador {
    private int id;
    private String nombre;
    private Equipo equipo;
    private int goles;

    public Jugador(int id, String nombre, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.goles = 0;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public int getGoles() {
        return this.goles;
    }

    public void anotarGol() {
        ++this.goles;
    }
}
