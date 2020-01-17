package pl.ryzykowski.arduino.arduinotemperaturews.dto;

public class TemperatureDto {
    private String x;
    private double y;

    public TemperatureDto() {
    }

    public TemperatureDto(String x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
