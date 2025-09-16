from pigpio_dht import DHT11
import time

# Sensor an GPIO4 (Pin 7)
sensor = DHT11(gpio=4, timeout_secs=2)

#print("Starte Diagnosetest…")
while True:
    result = sensor.read()
    timestamp = time.strftime("%H:%M:%S")
    if result['valid']:
        #print(f"[{timestamp}] OK - Temp: {result['temp_c']}°C, Feuchtigkeit: {result['humidity']}%")
        print(f"{result['temp_c']},{result['humidity']}")

   
    time.sleep(4)

#print("Messungen beendet abgeschlossen.")
