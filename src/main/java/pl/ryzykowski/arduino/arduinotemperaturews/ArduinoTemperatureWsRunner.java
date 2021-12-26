package pl.ryzykowski.arduino.arduinotemperaturews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Location;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;
import pl.ryzykowski.arduino.arduinotemperaturews.service.LocationService;
import pl.ryzykowski.arduino.arduinotemperaturews.service.TemperatureService;

@Service
public class ArduinoTemperatureWsRunner implements CommandLineRunner {

    private LocationService locationService;
    private TemperatureService temperatureService;

    @Autowired
    public ArduinoTemperatureWsRunner(LocationService locationService, TemperatureService temperatureService) {
        this.locationService = locationService;
        this.temperatureService = temperatureService;
    }

    @Override
    public void run(String... args) throws Exception {
        locationService.addLocation(new Location("dwor"));
        locationService.addLocation(new Location("kotlownia"));

        /*    locationService.addLocation(new Location("gabinet"));

        temperatureService.addTemperature(new Temperature(1L, 22.3));
        temperatureService.addTemperature(new Temperature(2L, 15.3));
        temperatureService.addTemperature(new Temperature(3L, -1.3));
        Thread.sleep(5000);
        temperatureService.addTemperature(new Temperature(1L, 24.7));
        temperatureService.addTemperature(new Temperature(2L, 17.1));
        temperatureService.addTemperature(new Temperature(3L, 0.0));
        Thread.sleep(5000);
        temperatureService.addTemperature(new Temperature(1L, 21.9));
        temperatureService.addTemperature(new Temperature(2L, 16.2));
        temperatureService.addTemperature(new Temperature(3L, -2.4));*/
    }
}
