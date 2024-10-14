import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    // Declaración de las variables que usaremos
    private JTextField usernameField;        // Campo de texto para el nombre de usuario
    private JPasswordField passwordField;    // Campo de texto para la contraseña
    private CardLayout cardLayout;           // Layout para cambiar entre pantallas
    private JPanel mainPanel;                // Panel principal donde cambiarán las pantallas

    public Main() {
        initUI();  // Método que inicializa la interfaz gráfica
    }
    private void initUI() {
         // Configura la ventana principal
         setTitle("Administración de Rutas");  // Título de la ventana
         setSize(400, 300);                    // Tamaño de la ventana
         setDefaultCloseOperation(EXIT_ON_CLOSE);  // Comportamiento al cerrar la ventana
         setLocationRelativeTo(null);          // Centra la ventana en la pantalla

          // Usar CardLayout para gestionar los diferentes paneles
        cardLayout = new CardLayout();  // Inicializa el CardLayout
        mainPanel = new JPanel(cardLayout);  // Panel principal que contendrá las diferentes pantallas
    }
}
