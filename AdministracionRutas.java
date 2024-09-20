public class AdministracionRutas {
    // Declaración de atributos
    private Ruta ruta;
    private Vehiculo vehiculo;
    private Usuario usuario;
    private String horaInicio;


    // Gets y Sets
    public Ruta getRuta() {
        return this.ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    // Método constructor
    public AdministracionRutas(Ruta ruta, Vehiculo vehiculo, Usuario usuario, String horaInicio) {
        this.ruta = ruta;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.horaInicio = horaInicio;
    }

    // Método para crear una ruta
    public void crearRuta (String punto1, String punto2){
        
    }


    

}
