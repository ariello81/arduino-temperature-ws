package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import java.io.StringBufferInputStream;

public class TemperatureDto {

    private Long locationId;
    private double value;

    public TemperatureDto() {
    }

    public TemperatureDto(Long locationId, double value) {
        this.locationId = locationId;
        this.value = value;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
