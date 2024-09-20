import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        AdministracionRutas adminRutas = new AdministracionRutas();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {  // Control del menú principal
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Salir");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 1) {
                    // Sign Up
                    System.out.println("\n--- SIGN UP ---");
                    System.out.print("Ingrese un nombre de usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese una contraseña: ");
                    String contrasena = scanner.nextLine();
                    adminRutas.crearUsuario(nombre, contrasena);
                } else if (opcion == 2) {
                    // Sign In
                    System.out.println("\n--- SIGN IN ---");
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.nextLine();

                    Usuario usuario = adminRutas.getUsuario();  // Obtén el usuario registrado
                    if (usuario != null && usuario.getNombre().equals(nombre) && usuario.getPassword().equals(contrasena)) {
                        System.out.println("Bienvenido " + nombre + "!");
                        int opcionGo = 0;
                        while (opcionGo != 5) {  // Control del submenú 'Go'
                            System.out.println("\n--- GO ---");
                            System.out.println("1. Ver rutas disponibles");
                            System.out.println("2. Mostrar tráfico");
                            System.out.println("3. Ver tiempo estimado");
                            System.out.println("4. Ver rutas favoritas");
                            System.out.println("5. Regresar");

                            try {
                                opcionGo = Integer.parseInt(scanner.nextLine());
                                if (opcionGo == 1){
                                    adminRutas.mostrarRutas();
                                } 
								else if (opcionGo == 2){
                                    System.out.println("Mostrando tráfico...");
                                    // Implementar Lógica para mostrar tráfico
                                }
								else if (opcionGo == 3){
                                    System.out.println("Mostrando tiempo estimado...");
                                    // Implementar Lógica para mostrar tiempo estimado
                                } 
								else if (opcionGo == 4){
                                    System.out.println("Mostrando rutas favoritas...");
                                    // Implementar ------------------Lógica para mostrar rutas favoritas
                                } 
								else if (opcionGo != 5){
                                    System.out.println("Opción no válida.");
                                }
                            } 
							catch (NumberFormatException e){
                                System.out.println("Error: Debe ingresar un número válido.");
                            }
                        }
                    } 
					else {
                        System.out.println("Error: Nombre de usuario o contraseña incorrectos.");
                    }
                } 
				else if (opcion != 3) {
                    System.out.println("Opción no válida, por favor seleccione una opción entre 1 y 3.");
                }
            } 
			catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
        System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
    }
}
