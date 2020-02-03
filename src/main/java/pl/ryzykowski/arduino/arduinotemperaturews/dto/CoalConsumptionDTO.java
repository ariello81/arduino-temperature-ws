package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CoalConsumptionDTO {

    @JsonProperty("x")
    private Timestamp date;

    @JsonProperty("y")
    private BigDecimal consumptionValue;

    public CoalConsumptionDTO() {
    }

    public CoalConsumptionDTO(Timestamp date, BigDecimal consumptionValue) {
        this.date = date;
        this.consumptionValue = consumptionValue;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public BigDecimal getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(BigDecimal consumptionValue) {
        this.consumptionValue = consumptionValue;
    }
}
