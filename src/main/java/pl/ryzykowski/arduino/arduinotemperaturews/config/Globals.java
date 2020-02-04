package pl.ryzykowski.arduino.arduinotemperaturews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Globals {

    public static BigDecimal COAL_WEIGHT_PER_RATE;

    @Value("${coal.weight.per.rate}")
    public void setCoalWeightPerRate(BigDecimal coalWeightPerRate) {COAL_WEIGHT_PER_RATE = coalWeightPerRate; }

}
