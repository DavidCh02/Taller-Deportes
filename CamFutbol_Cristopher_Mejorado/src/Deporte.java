public abstract class Deporte {
    private String nombre;

    public Deporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract void jugarPartido(Partido var1);
}
