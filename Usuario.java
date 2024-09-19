import java.util.ArrayList;
public class Usuario {
// Atributos
    private String nombre;
    private String password;
    private ArrayList<Ruta> rutasPreferidas;

// Gets & Sets
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Ruta> getRutasPreferidas() {
        return this.rutasPreferidas;
    }
    public void setRutasPreferidas(ArrayList<Ruta> rutasPreferidas) {
        this.rutasPreferidas = rutasPreferidas;
    }

// Método Constructor
    public Usuario(String nombre, String password, ArrayList<Ruta> rutasPreferidas) {
        this.nombre = nombre;
        this.password = password;
        this.rutasPreferidas = rutasPreferidas;
    }
    
}
