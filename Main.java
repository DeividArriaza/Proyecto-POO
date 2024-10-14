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

