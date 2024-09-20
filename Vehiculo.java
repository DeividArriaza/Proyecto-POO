public class Vehiculo {
    private String tipoVehiculo;

    public Vehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    // Método para obtener la velocidad promedio
    public double velocidadPromedio() {
        switch (tipoVehiculo) {
            case "Carro":
                return 80.0; // ejemplo de velocidad promedio en km/h
            case "Moto":
                return 40.0;
            case "Bicicleta":
                return 20.0;
            default:
                return 0.0; // Esta opcion es utilizada cuando el tipo de vehiculo no esta definido. 
        }
    }
}
