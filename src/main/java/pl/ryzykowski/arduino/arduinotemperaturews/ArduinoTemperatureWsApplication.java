package pl.ryzykowski.arduino.arduinotemperaturews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ArduinoTemperatureWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArduinoTemperatureWsApplication.class, args);
	}

}
