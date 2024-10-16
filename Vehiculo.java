public class Vehiculo {
    // Declaración de atributos
    private String tipoVehiculo;

	// Método constructor
	public Vehiculo() {
        tipoVehiculo = "Carro";
    }
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    // Gets y Sets
    public Vehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    // Método para obtener la velocidad promedio
    public double velocidadPromedio() {
        switch (tipoVehiculo) {
            case "Carro":
                return 60.0; // ejemplo de velocidad promedio en km/h
            case "Moto":
                return 40.0;
            case "Bicicleta":
                return 20.0;
            default:
                return 0.0; // Esta opcion es utilizada cuando el tipo de vehiculo no esta definido. 
        }
    }
}
