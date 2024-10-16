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

        // Pantalla de Registro de usuario (Sign Up)
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

        // Acción para guardar los datos del usuario en un archivo CSV al hacer Sign Up
        signupConfirmButton.addActionListener(e -> {
            String username = usernameField.getText();          // Obtener el nombre de usuario ingresado
            String password = new String(passwordField.getPassword());  // Obtener la contraseña ingresada

            // Verificar que ambos campos no estén vacíos
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa ambos campos.");
            } else {
                // Guardar los datos en un archivo CSV
                try (FileWriter writer = new FileWriter("usuarios.csv", true)) {  // "append" para añadir líneas
                    writer.append(username).append(",").append(password).append("\n");
                    writer.flush();
                    JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
                }
            }
        });

        // Acciones de volver al menú principal
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
		
		// Acción para validar las credenciales y acceder a la pantalla de rutas
        signinConfirmButton.addActionListener(e -> {
            String username = signinUsernameField.getText();          // Obtener el nombre de usuario ingresado
            String password = new String(signinPasswordField.getPassword());  // Obtener la contraseña ingresada

            // Validar que ambos campos no estén vacíos
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa ambos campos.");
            } else {
                // Leer el archivo CSV y comprobar los datos
                try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
                    String line;
                    boolean found = false;

                    // Leer línea por línea
                    while ((line = reader.readLine()) != null) {
                        String[] userData = line.split(",");  // Separar la línea en nombre de usuario y contraseña
                        String storedUsername = userData[0];  // Nombre de usuario guardado
                        String storedPassword = userData[1];  // Contraseña guardada

                        // Comparar el nombre de usuario y la contraseña
                        if (username.equals(storedUsername) && password.equals(storedPassword)) {
                            found = true;
                            break;
                        }
                    }

                    // Mostrar mensaje según si el usuario fue encontrado o no
                    if (found) {
                        cardLayout.show(mainPanel, "routePanel");  // Mostrar la pantalla de rutas
                    } else {
                        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al leer los datos.");
                }
            }
        });

        // Acciones de volver al menú principal
        signinBackButton.addActionListener(e -> cardLayout.show(mainPanel, "menuPanel"));  // Vuelve al menú principal

        // Pantalla para ingresar origen y destino (pantalla de rutas)
        JPanel routePanel = new JPanel(new GridLayout(4, 2));  // Panel para ingresar origen y destino
        originField = new JTextField();  // Campo de texto para el origen
        destinationField = new JTextField();  // Campo de texto para el destino
        JButton routeConfirmButton = new JButton("Obtener Ruta");  // Botón para obtener la ruta
        JButton routeBackButton = new JButton("Volver");  // Botón para volver al menú principal

        // Añadir etiquetas y campos de entrada al panel de rutas
        routePanel.add(new JLabel("Origen:"));
        routePanel.add(originField);
        routePanel.add(new JLabel("Destino:"));
        routePanel.add(destinationField);
        routePanel.add(routeConfirmButton);
        routePanel.add(routeBackButton);

        // Acción para obtener la ruta
        routeConfirmButton.addActionListener(e -> {
			String origin = originField.getText();
			String destination = destinationField.getText();

			if (origin.isEmpty() || destination.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor ingresa ambos campos.");
			} else {
				try {
					MapService.RouteInfo routeInfo = mapService.getRouteInfo(origin, destination);
					
					if ("OK".equals(routeInfo.getStatus())) {
						String message = String.format("Información de la ruta:\n" + "Distancia: %s\n" + "Tiempo estimado: %s", routeInfo.getDistance(), routeInfo.getDuration());
						JOptionPane.showMessageDialog(this, message);
					} else { //EN caso no se encuentre la ruta
						JOptionPane.showMessageDialog(this, "No se pudo encontrar la ruta. Estado: " + routeInfo.getStatus(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) { //Cualquier otro tipo de error 
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Error al obtener la ruta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

        // Acción para volver al menú principal desde la pantalla de rutas
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