/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.designpattern.observer;

/**
 *
 * @author ralph
 */
import java.util.ArrayList;
import java.util.List;

// Subject-Interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Observer-Interface
interface Observer {
    void update(float temperature, float humidity);
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity);
        }
    }

    // Wetterdaten aktualisieren
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers(); // alle Beobachter informieren
    }
}

// Concrete Observer
class Display implements Observer {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + " Anzeige aktualisiert: Temperatur = " 
                           + temperature + "°C, Luftfeuchtigkeit = " + humidity + "%");
    }
}

// Demo
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Display display1 = new Display("Wohnzimmer");
        Display display2 = new Display("Küche");

        station.registerObserver(display1);
        station.registerObserver(display2);

        station.setMeasurements(25.5f, 60f);  // Updates an alle Beobachter
        station.setMeasurements(26.0f, 55f);  // Updates erneut
    }
}
