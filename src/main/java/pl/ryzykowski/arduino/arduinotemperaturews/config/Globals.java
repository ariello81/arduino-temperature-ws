package pl.ryzykowski.arduino.arduinotemperaturews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Component
public class Globals {

    public static BigDecimal COAL_WEIGHT_PER_RATE;

    @Value("${coal.weight.per.rate}")
    public void setCoalWeightPerRate(BigDecimal coalWeightPerRate) {COAL_WEIGHT_PER_RATE = coalWeightPerRate; }

    public static DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

}
