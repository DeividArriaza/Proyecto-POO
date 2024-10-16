import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; //Importa el paquete io para almacenamiento de datos

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

        // Añadir etiquetas y campos de entrada al panel de "Sign Up" para que así se vean los datos a ingresar
        signupPanel.add(new JLabel("Nombre de usuario:"));
        signupPanel.add(usernameField);
        signupPanel.add(new JLabel("Contraseña:"));
        signupPanel.add(passwordField);
        signupPanel.add(signupConfirmButton);
        signupPanel.add(signupBackButton);
		
		//Esta acción es para guardar los datos del ususario en un archivo CSV
		signupConfirmButton.addActionListener(e -> { //-> es un lambda, donde la e es el parametro para el error y lo de adentro de llaves es el cuerpo de lo que se realiza
			String username = usernameField.getText();          // Obtener el nombre de usuario ingresado en el JtextField
			String password = new String(passwordField.getPassword());  // Obtener la contraseña ingresada en el passwordfield

			// Este if es por si username o password no tienen ningún valor alguno de los dos
			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor ingresa ambos campos.");
			} else {
				// Guardar los datos en un archivo CSV
				try (FileWriter writer = new FileWriter("usuarios.csv", true)) {  // Modo "append" para añadir líneas
					writer.append(username).append(",").append(password).append("\n");
					writer.flush();
					JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
				}
			}
		});
        // Acciones de Sign Up por el momento
        signupBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));  // Vuelve al menú principal

        // Pantalla de Sign In / Inicio de sesión
        JPanel signinPanel = new JPanel(new GridLayout(3, 2));  // Panel con 3 filas y 2 columnas
        JTextField signinUsernameField = new JTextField();  // Campo de texto para el nombre de usuario
        JPasswordField signinPasswordField = new JPasswordField();  // Campo de texto para la contraseña
        JButton signinConfirmButton = new JButton("Iniciar Sesión");  // Botón para iniciar sesión
        JButton signinBackButton = new JButton("Volver");  // Botón para volver al menú principal

        // Añadir etiquetas y campos de entrada al panel de "Sign In"
        signinPanel.add(new JLabel("Nombre de usuario:"));
        signinPanel.add(signinUsernameField);
        signinPanel.add(new JLabel("Contraseña:"));
        signinPanel.add(signinPasswordField);
        signinPanel.add(signinConfirmButton);
        signinPanel.add(signinBackButton);

        // Acciones de Sign In hasta el momento:
        signinBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));  // Vuelve al menú principal
		
		 // Añadir todos los paneles al panel principal (mainPanel) usando el CardLayout
        mainPanel.add(menuPanel, "menuPanel");  // Menú principal
        mainPanel.add(signupPanel, "signupPanel");  // Pantalla de Sign Up
        mainPanel.add(signinPanel, "signinPanel");  // Pantalla de Sign In

        // Muestra el menú principal al iniciar la aplicación
        add(mainPanel);  // Añadir el panel principal al JFrame
        cardLayout.show(mainPanel, "menuPanel");  // Mostrar el menú principal
		
    }
	 public static void main(String[] args) {
        // Ejecuta la interfaz gráfica en el hilo de eventos de Swing
        EventQueue.invokeLater(() -> {
            Main ex = new Main();  // Crea una instancia de la aplicación
            ex.setVisible(true);  // Hace visible la ventana
        });
    }


}
