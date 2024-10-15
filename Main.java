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

        // Pantalla del menú principal
        JPanel menuPanel = new JPanel();  // Panel para el menú principal
        menuPanel.setLayout(new GridLayout(3, 1));  // Organiza los botones en 3 filas
        JButton signUpButton = new JButton("Sign Up");  // Botón para "Sign Up"
        JButton signInButton = new JButton("Sign In");  // Botón para "Sign In"
        JButton exitButton = new JButton("Salir");      // Botón para salir de la aplicación

        // Acciones de los botones del menú principal
        signUpButton.addActionListener(e -> cardLayout.show(mainPanel, "signupPanel"));  // Muestra el panel de "Sign Up"
        signInButton.addActionListener(e -> cardLayout.show(mainPanel, "signinPanel"));  // Muestra el panel de "Sign In"
        exitButton.addActionListener(e -> System.exit(0));  // Sale de la aplicación

        // Añadir los botones al panel del menú principal
        menuPanel.add(signUpButton);
        menuPanel.add(signInButton);
        menuPanel.add(exitButton);

        // Pantalla de Registro de usuario llamada sing up 
        JPanel signupPanel = new JPanel(new GridLayout(3, 2));  // Panel con 3 filas y 2 columnas
        usernameField = new JTextField();  // Campo de texto para ingresar el nombre de usuario
        passwordField = new JPasswordField();  // Campo de texto para ingresar la contraseña
        JButton signupConfirmButton = new JButton("Registrarse");  // Botón para confirmar el registro
        JButton signupBackButton = new JButton("Volver");  // Botón para volver al menú principal

        // Añadir etiquetas y campos de entrada al panel de "Sign Up"
        signupPanel.add(new JLabel("Nombre de usuario:"));
        signupPanel.add(usernameField);
        signupPanel.add(new JLabel("Contraseña:"));
        signupPanel.add(passwordField);
        signupPanel.add(signupConfirmButton);
        signupPanel.add(signupBackButton);


    }
}
