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

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Equipo getEquipo() { return equipo; }
    public int getGoles() { return goles; }

    public void anotarGol() {
        goles++;
    }
}
