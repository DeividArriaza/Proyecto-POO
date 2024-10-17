import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder; //codificador de URL
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Duration;
public class MapService {
    private final String API_KEY;
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json"; //Esto es para conectar con la URL de la API de distancematrix de googleApis
    private final HttpClient httpClient; //debido a que la respuesta de la api es de manera HTTP, como si fuera para usar con HTML, se necesita un cliente de este servicio que conecte con HTTP
    public MapService(String apiKey) { //Constructor donde se toma el parametro de la api
        this.API_KEY = apiKey;
        this.httpClient = HttpClient.newBuilder().build(); //Se construye el cliente http que permtiráhacer el response
    }

    public class RouteInfo {
        private final String duration; //duracion del recorrido desde el punto inicio a finla
        private final String distance; //distancia total recorrid 
        private final String status; //estado de la respuesta de la api, "OK" si se obtuvo una respuesta adecuada, de lo contrario ocurrió un error

        public RouteInfo(String duration, String distance, String status) {
            this.duration = duration;
            this.distance = distance;
            this.status = status;
        }
        
        public String getDuration() {
            return duration;
        }

        public String getDistance() {
            return distance;
        }

        public String getStatus() {
            return status;
        }
    }

    public RouteInfo getRouteInfo(String origin, String destination) throws Exception { //Se crea el metodo getRouteInfo para devolver un RouteInfo que permita extraer "duration", "distance" y "status" en controlPanel
    //Se codifican los parámetros de la URL para que así sea legible para la API
    String encodedOrigin = URLEncoder.encode(origin, StandardCharsets.UTF_8); //Esto es para aceptar cualquier entrada en el origen
    String encodedDestination = URLEncoder.encode(destination, StandardCharsets.UTF_8); //Esto es para aceptar cualquier entrada en el destinto

    
}