package nomina.konecta;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FestivoUtils {
    public static List<LocalDate> cargarFestivos(String archivo) {
        List<LocalDate> festivos = new ArrayList<>();
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONArray array = new JSONArray(contenido);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                festivos.add(LocalDate.parse(obj.getString("fecha")));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de festivos.");
        }
        return festivos;
    }
}