public class Ruta {
    // Declaración de atributos
    private String puntoInicial;
    private String puntoFinal;

    // Método constructor
	public Ruta(){
		puntoInicial = "Zona 16";
		puntoFinal = "Zona 16";
	}
	
    public Ruta(String puntoInicial, String puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    // Gets y Sets
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

    // Método para obtener rutas disponibles
    public String[] rutasDisponibles() {
        String[] rutas = {"Ruta1", "Ruta2", "Ruta3"};
        return rutas;
    }

    // Método para calcular la distancia de una ruta
    public double distancia(String elegirRutaDisponible) {
        switch (elegirRutaDisponible) {
            case "Ruta1":
                return 10.5; // Distancia en kilómetros, por ejemplo
            case "Ruta2":
                return 15.0;
            case "Ruta3":
                return 7.8;
            default:
                return 0.0; // Si la ruta no está en la lista
        }
    }
}
