import javax.swing.*; //Java swing para interfaz grafica
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; // Importa el paquete io para almacenamiento de datos
import javax.swing.border.LineBorder;
import java.awt.Color;

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
 private void initUI() {
		// Configura la ventana principal
		setTitle("Map Service UVG"); // Título de la ventana
		setSize(600, 500); // Tamaño de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Comportamiento al cerrar la ventana
		setLocationRelativeTo(null); // Centra la ventana en la pantalla

		// Usar CardLayout para gestionar los diferentes paneles
		cardLayout = new CardLayout(); // Inicializa el CardLayout
		mainPanel = new JPanel(cardLayout); // Panel principal que contendrá las diferentes pantallas

		// Configuración general para los paneles
		Font commonFont = new Font("Dotum", Font.PLAIN, 16);

		// Pantalla del menú principal
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(3, 1, 10, 10)); // Espaciado entre botones
		menuPanel.setBackground(new Color(128, 92, 74)); // Color de fondo
		menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

		JButton signUpButton = new JButton("Registrar usuario");
		signUpButton.setFont(commonFont);

		JButton signInButton = new JButton("Iniciar Sesión");
		signInButton.setFont(commonFont);

		JButton exitButton = new JButton("Salir");
		exitButton.setFont(commonFont);

		// Acciones de los botones del menú principal
		signUpButton.addActionListener(e -> cardLayout.show(mainPanel, "signupPanel"));
		signInButton.addActionListener(e -> cardLayout.show(mainPanel, "signinPanel"));
		exitButton.addActionListener(e -> System.exit(0));
		
		signUpButton.setBackground(new Color(188,146,127)); //Color cafe claro registrar usuario
		signUpButton.setForeground(Color.BLACK);          // Texto negro
		signInButton.setBackground(new Color(188,146,127));  // Color cafe claro
		signInButton.setForeground(Color.BLACK);          // Texto negro
		exitButton.setBackground(new Color(188,146,127));  // Color cafe claro
		exitButton.setForeground(Color.BLACK);            // Texto negro
		signUpButton.setBorder(new LineBorder(Color.BLACK, 2));
		signInButton.setBorder(new LineBorder(Color.BLACK, 2));
		exitButton.setBorder(new LineBorder(Color.BLACK, 2));
		
		// Añadir los botones al panel del menú principal
		menuPanel.add(signUpButton);
		menuPanel.add(signInButton);
		menuPanel.add(exitButton);

		// Pantalla de Registro de usuario (Sign Up)
		JPanel signupPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Espaciado entre elementos
		signupPanel.setBackground(new Color(128,92,74)); // Color de fondo
		signupPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		usernameField.setFont(commonFont);
		usernameField.setBackground(new Color(236,196,178));
		usernameField.setForeground(Color.BLACK); 
		
		passwordField.setFont(commonFont);
		passwordField.setBackground(new Color(236,196,178));
		passwordField.setForeground(Color.BLACK); 
		
		
		JButton signupConfirmButton = new JButton("Registrarse");
		signupConfirmButton.setFont(commonFont);
		signupConfirmButton.setBackground(new Color(188,146,127));
		signupConfirmButton.setForeground(Color.BLACK); 
		signupConfirmButton.setBorder(new LineBorder(Color.BLACK, 2));
				
		JButton signupBackButton = new JButton("Regresar");
		signupBackButton.setFont(commonFont);
		signupBackButton.setBackground(new Color(188,146,127));
		signupBackButton.setForeground(Color.BLACK); 
		signupBackButton.setBorder(new LineBorder(Color.BLACK, 2));
		
		signupPanel.add(new JLabel("Usuario:", JLabel.RIGHT));
		signupPanel.add(usernameField);
		signupPanel.add(new JLabel("Contraseña:", JLabel.RIGHT));
		signupPanel.add(passwordField);
		signupPanel.add(signupConfirmButton);
		signupPanel.add(signupBackButton);

		signupConfirmButton.addActionListener(e -> {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, ingrese ambos campos.");
			} else {
				try (FileWriter writer = new FileWriter("usuarios.csv", true)) {
					writer.append(username).append(",").append(password).append("\n");
					writer.flush();
					JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "ERROR: Datos no guardados.");
				}
			}
		});

		signupBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));

		// Pantalla de Sign In / Inicio de sesión
		JPanel signinPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Espaciado entre elementos
		signinPanel.setBackground(new Color(128, 92, 74)); // Color de fondo
		signinPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

		JTextField signinUsernameField = new JTextField();
		signinUsernameField.setFont(commonFont);
		signinUsernameField.setBackground(new Color(236,196,178));
		signinUsernameField.setForeground(Color.BLACK); 
		
		
		JPasswordField signinPasswordField = new JPasswordField();
		signinPasswordField.setFont(commonFont);
		signinPasswordField.setBackground(new Color(236,196,178));
		signinPasswordField.setForeground(Color.BLACK); 
		
		JButton signinConfirmButton = new JButton("Iniciar Sesión");
		signinConfirmButton.setFont(commonFont);
		signinConfirmButton.setBackground(new Color(188,146,127));
		signinConfirmButton.setForeground(Color.BLACK); 
		signinConfirmButton.setBorder(new LineBorder(Color.BLACK, 2));
		
		
		JButton signinBackButton = new JButton("Regresar");
		signinBackButton.setFont(commonFont);
		signinBackButton.setBackground(new Color(188,146,127));
		signinBackButton.setForeground(Color.BLACK); 
		signinBackButton.setBorder(new LineBorder(Color.BLACK, 2));

		signinPanel.add(new JLabel("Usuario:", JLabel.RIGHT));
		signinPanel.add(signinUsernameField);
		signinPanel.add(new JLabel("Contraseña:", JLabel.RIGHT));
		signinPanel.add(signinPasswordField);
		signinPanel.add(signinConfirmButton);
		signinPanel.add(signinBackButton);

		signinConfirmButton.addActionListener(e -> {
			String username = signinUsernameField.getText();
			String password = new String(signinPasswordField.getPassword());
			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, ingrese ambos campos.");
			} else {
				try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
					String line;
					boolean found = false;
					while ((line = reader.readLine()) != null) {
						String[] userData = line.split(",");
						if (username.equals(userData[0]) && password.equals(userData[1])) {
							found = true;
							break;
						}
					}
					if (found) {
						cardLayout.show(mainPanel, "routePanel");
					} else {
						JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "ERROR: Lectura de datos fallida.");
				}
			}
		});

		signinBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));

		// Pantalla de rutas
		JPanel routePanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Espaciado entre elementos
		routePanel.setBackground(new Color(128,92,74)); // Color de fondo
		routePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

		originField = new JTextField();
		originField.setFont(commonFont);
		originField.setBackground(new Color(236,196,178));
		originField.setForeground(Color.BLACK); 
		
		destinationField = new JTextField();
		destinationField.setFont(commonFont);
		destinationField.setBackground(new Color(236,196,178));
		destinationField.setForeground(Color.BLACK); 
		
		JButton routeConfirmButton = new JButton("Buscar Ruta");
		routeConfirmButton.setFont(commonFont);
		routeConfirmButton.setBackground(new Color(188,146,127));
		routeConfirmButton.setForeground(Color.BLACK); 
		routeConfirmButton.setBorder(new LineBorder(Color.BLACK, 2));
		
		
		JButton routeBackButton = new JButton("Regresar");
		routeBackButton.setFont(commonFont);
		routeBackButton.setBackground(new Color(188,146,127));
		routeBackButton.setForeground(Color.BLACK); 
		routeBackButton.setBorder(new LineBorder(Color.BLACK, 2));
		

		routePanel.add(new JLabel("Su ubicación:", JLabel.RIGHT));
		routePanel.add(originField);
		routePanel.add(new JLabel("Destino:", JLabel.RIGHT));
		routePanel.add(destinationField);
		routePanel.add(routeConfirmButton);
		routePanel.add(routeBackButton);

		routeConfirmButton.addActionListener(e -> {
			String origin = originField.getText();
			String destination = destinationField.getText();
			if (origin.isEmpty() || destination.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, ingrese ambos campos.");
			} else {
				try {
					MapService.RouteInfo routeInfo = mapService.getRouteInfo(origin, destination);
					if ("OK".equals(routeInfo.getStatus())) {
						String message = String.format("Información de la ruta:\nDistancia: %s\nTiempo estimado: %s",
								routeInfo.getDistance(), routeInfo.getDuration());
						JOptionPane.showMessageDialog(this, message);
					} else {
						JOptionPane.showMessageDialog(this, "No se pudo encontrar la ruta. Estado: " + routeInfo.getStatus(),
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "ERROR: ruta no encontrada: " + ex.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		routeBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));

		// Añadir todos los paneles al panel principal
		mainPanel.add(menuPanel, "menuPanel");
		mainPanel.add(signupPanel, "signupPanel");
		mainPanel.add(signinPanel, "signinPanel");
		mainPanel.add(routePanel, "routePanel");

		// Añadir el panel principal a la ventana
		add(mainPanel);

		// Mostrar el menú principal inicialmente
		cardLayout.show(mainPanel, "menuPanel");
	}

}