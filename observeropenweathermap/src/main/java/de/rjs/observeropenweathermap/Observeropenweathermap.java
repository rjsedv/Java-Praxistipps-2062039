/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de.rjs.observeropenweathermap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// -------- Observer Pattern Interfaces --------

interface WeatherObserver {
    void update(WeatherData data);
}

class WeatherData {
    private float temperature;
    private float humidity;
    private String description;

    public WeatherData(float temperature, float humidity, String description) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("Temp: %.2f°C, Humidity: %.2f%%, Condition: %s",
                             temperature, humidity, description);
    }
}

interface WeatherSubject {
    void registerObserver(WeatherObserver o);
    void removeObserver(WeatherObserver o);
    void notifyObservers();
}

// -------- OpenWeatherMap-Subject --------

class OpenWeatherMapSubject implements WeatherSubject, Runnable {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private WeatherData lastData;
    private final String apiKey;
    private final String city;
    private final long intervalMillis;

    public OpenWeatherMapSubject(String city, String apiKey, long intervalMillis) {
        this.city = city;
        this.apiKey = apiKey;
        this.intervalMillis = intervalMillis;
    }

    @Override
    public void registerObserver(WeatherObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(WeatherObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (lastData == null) return;
        for (WeatherObserver o : observers) {
            o.update(lastData);
        }
    }

    private WeatherData fetchWeather() {
        try {
            String urlString = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
                city, apiKey);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // JSON parsen
            JsonObject json = JsonParser.parseString(content.toString()).getAsJsonObject();
            JsonObject main = json.getAsJsonObject("main");
            float temp = main.get("temp").getAsFloat();
            float humidity = main.get("humidity").getAsFloat();
            String description = json.getAsJsonArray("weather")
                                     .get(0).getAsJsonObject()
                                     .get("description").getAsString();

            return new WeatherData(temp, humidity, description);

        } catch (Exception e) {
            System.err.println("Fehler beim Abruf der Wetterdaten: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void run() {
        while (true) {
            WeatherData data = fetchWeather();
            if (data != null && hasChanged(data)) {
                lastData = data;
                notifyObservers();
            }
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private boolean hasChanged(WeatherData newData) {
        if (lastData == null) return true;
        if (Math.abs(lastData.getTemperature() - newData.getTemperature()) > 0.5f) return true;
        if (Math.abs(lastData.getHumidity() - newData.getHumidity()) > 2.0f) return true;
        if (!lastData.getDescription().equals(newData.getDescription())) return true;
        return false;
    }
}

// -------- Realistische Observer --------

// Gibt Daten einfach in die Konsole aus
class ConsoleDisplay implements WeatherObserver {
    @Override
    public void update(WeatherData data) {
        System.out.println("[Console] Neues Wetter: " + data);
    }
}

// Loggt Daten (z. B. in eine Datei, hier nur Demo mit System.out)
class LoggerObserver implements WeatherObserver {
    @Override
    public void update(WeatherData data) {
        System.out.println("[Logger] Wetter geloggt: " + data);
        // In der Praxis: in Datei oder Datenbank schreiben
    }
}

// -------- Demo --------

public class Observeropenweathermap {
    public static void main(String[] args) {
        String apiKey = "b0a17f4a476d2bcffc555e925a93fc3e"; // <- hier deinen OpenWeatherMap Key eintragen
        String city = "Mainz,de";

        OpenWeatherMapSubject subject = new OpenWeatherMapSubject(city, apiKey, 5 * 60 * 1000); // alle 5 Minuten

        subject.registerObserver(new ConsoleDisplay());
        subject.registerObserver(new LoggerObserver());

        Thread t = new Thread(subject);
        t.start();
    }
}

