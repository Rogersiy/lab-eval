import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) throws IOException {

        String currentWorkingDirectory = System.getProperty("user.dir");
        String resultFilePath = currentWorkingDirectory +"/python/infer.json";
        String annFilePath = currentWorkingDirectory+ "/python/instances_val2017.json";
        Gson gson = new Gson();

        Map<String, String> data = new HashMap<>();
        data.put("result_file", resultFilePath);
        data.put("ann_file", annFilePath);

        // Create json string
        String jsonString = gson.toJson(data);

        // Send post request
        URL url = new URL("http://127.0.0.1:5000/evaluate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8"); // Set Content-Type to application/json
        conn.setDoOutput(true);
        conn.getOutputStream().write(jsonString.getBytes(StandardCharsets.UTF_8));

        // Get the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = reader.readLine();
        Map<String, Double> result = gson.fromJson(response, Map.class);
        // Print the result
        System.out.println(result);
    }
}
