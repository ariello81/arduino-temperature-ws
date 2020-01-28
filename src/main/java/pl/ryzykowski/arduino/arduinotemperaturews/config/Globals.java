package pl.ryzykowski.arduino.arduinotemperaturews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Globals {

    public static int COAL_SUPPLY_MAX_KG;
    public static int COAL_SUPPLY_THRESHOLD_DISTANCE;
    public static double COAL_SUPPLY_COEFFICIENT;
    public static double COAL_WEIGHT_PER_RATE;

    @Value("${coal.supply.max.kg}")
    public void setCoalSupplyMaxKg(int coalSupplyMaxKg) {
        COAL_SUPPLY_MAX_KG = coalSupplyMaxKg;
    }

    @Value("${coal.supply.threshold.distance}")
    public void setCoalSupplyThresholdDistance(int coalSupplyThresholdDistance) { COAL_SUPPLY_THRESHOLD_DISTANCE = coalSupplyThresholdDistance; }

    @Value("${coal.supply.coefficient}")
    public void setCoalSupplyCoefficient(double coalSupplyCoefficient) { COAL_SUPPLY_COEFFICIENT = coalSupplyCoefficient; }

    @Value("${coal.weight.per.rate}")
    public void setCoalWeightPerRate(double coalWeightPerRate) {COAL_WEIGHT_PER_RATE = coalWeightPerRate; }

}
