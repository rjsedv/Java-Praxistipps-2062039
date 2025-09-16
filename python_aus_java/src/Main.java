import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python", "dht11.py");
        Process p = pb.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line = br.readLine();
            if (line != null && !line.equals("ERROR")) {
                String[] parts = line.split(",");
                double temp = Double.parseDouble(parts[0]);
                double hum  = Double.parseDouble(parts[1]);
                System.out.println("Temp: " + temp + "°C, Hum: " + hum + "%");
            } else {
                System.out.println("Fehler beim Lesen vom Sensor.");
            }
        }
    }
}
