public class Resultado {
    private int golesLocal;
    private int golesVisitante;

    public Resultado(int golesLocal, int golesVisitante) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public boolean esEmpate() {
        return golesLocal == golesVisitante;
    }
}