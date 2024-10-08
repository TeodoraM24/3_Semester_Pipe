import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DogTestAPI {

    private static final String BASE_URL = "http://localhost:7007/api/dogs";

    public static void main(String[] args) {
        try {
            getAllDogs();
            createDog();
            getDogById(1); // Replace with the actual ID you want to fetch
            updateDog(1);   // Replace with the actual ID you want to update
            deleteDog(1);   // Replace with the actual ID you want to delete
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
        }
    }

    private static void getAllDogs() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("GET /dogs Response: " + response.toString());
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }

    private static void createDog() throws IOException {
        URL url = new URL(BASE_URL.replace("/dogs", "/dog"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"name\": \"Buddy\", \"breed\": \"Beagle\", \"gender\": \"MALE\", \"age\": 4}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("POST /dog Response: " + response.toString());
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }

    private static void getDogById(int id) throws IOException {
        URL url = new URL(BASE_URL.replace("/dogs", "/dog/" + id));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("GET /dog/" + id + " Response: " + response.toString());
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }

    private static void updateDog(int id) throws IOException {
        URL url = new URL(BASE_URL.replace("/dogs", "/dog/" + id));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"name\": \"Rex\", \"breed\": \"Labrador\", \"gender\": \"MALE\", \"age\": 5}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("PUT /dog/" + id + " Response: " + response.toString());
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }

    private static void deleteDog(int id) throws IOException {
        URL url = new URL(BASE_URL.replace("/dogs", "/dog/" + id));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("DELETE /dog/" + id + " Response: " + response.toString());
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}
