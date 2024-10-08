public class Ruta {
    // Atributos
    private String puntoInicial;
    private String puntoFinal;

    public Ruta(String puntoInicial, String puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    // gets y sets
    public String getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(String puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public String getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(String puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    // Rutas disponibles
    public String[] rutasDisponibles() {
        String[] rutas = {"Ruta1", "Ruta2", "Ruta3"};
        return rutas;
    }

    // Calcular la distancia de una ruta
    public double distancia(String elegirRutaDisponible) {
        switch (elegirRutaDisponible) {
            case "Ruta1":
                return 10.5; // ejemplo de una distancia
            case "Ruta2":
                return 15.0;
            case "Ruta3":
                return 7.8;
            default:
                return 0.0; // Si la ruta no existe en la lista de opciones. 
        }
    }
}
