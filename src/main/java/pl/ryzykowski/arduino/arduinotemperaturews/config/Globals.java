package pl.ryzykowski.arduino.arduinotemperaturews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Globals {

    public static int COAL_SUPPLY_MAX_KG;
    public static int COAL_SUPPLY_DISTANCE_THRESHOLD;
    public static double COAL_SUPPLY_COEFFICIENT;

    @Value("${coal.supply.max.kg}")
    public void setCoalSupplyMaxKg(int coalSupplyMaxKg) {
        COAL_SUPPLY_MAX_KG = coalSupplyMaxKg;
    }

    @Value("${coal.supply.distance.threshold}")
    public void setCoalSupplyDistanceThreshold(int coalSupplyDistanceThreshold) { COAL_SUPPLY_DISTANCE_THRESHOLD = coalSupplyDistanceThreshold; }

    @Value("${coal.supply.coefficient}")
    public void setCoalSupplyCoefficient(double coalSupplyCoefficient) { COAL_SUPPLY_COEFFICIENT = coalSupplyCoefficient; }

}
