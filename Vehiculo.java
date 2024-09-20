public class Vehiculo {
    // Declaración de atributos
    private String tipoVehiculo;

    // Gets y Sets
    public Vehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    // Método constructor
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    // Método para obtener la velocidad promedio
    public double velocidadPromedio() {
        switch (tipoVehiculo) {
            case "Carro":
                return 80.0; // ejemplo de velocidad promedio en km/h
            case "Moto":
                return 50.0;
            case "Bicicleta":
                return 20.0;
            default:
                return 0.0; // Si el tipo de vehículo no está definido
        }
    }
}
