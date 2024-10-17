import javax.swing.*; //Java swing para interfaz grafica
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; // Importa el paquete io para almacenamiento de datos

public class ControlPanel extends JFrame {
    // Declaración de las variables que usaremos
    private JTextField usernameField;        // nombre del usuario
    private JPasswordField passwordField;    // contraseña
    private CardLayout cardLayout;           // cambiar la pantalla
    private JPanel mainPanel;                // este es el panel principal
    private JTextField originField;          // Campo de texto para el origen de la ruta
    private JTextField destinationField;     // Campo de texto para el destino de la ruta
	private MapService mapService;			 // Se llama a la clase que tiene acceso a la API

    public ControlPanel() { //Metodo constructor
		mapService = new MapService("AIzaSyC2Iql41jg8d7hT0uNxendWvwnvNcUqsLA");
        initUI();  // Método que inicializa la interfaz gráfica
    }
