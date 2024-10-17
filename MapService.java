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
    
}