package pl.ryzykowski.arduino.arduinotemperaturews.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class CoalSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    private int distance;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private double supplyValue;

    public CoalSupply() {
    }

    public CoalSupply(int distance) {
        this.distance = distance;
    }

    public CoalSupply(Long id, Timestamp timestamp, int distance, double supplyValue) {
        this.id = id;
        this.timestamp = timestamp;
        this.distance = distance;
        this.supplyValue = supplyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getSupplyValue() {
        return supplyValue;
    }

    public void setSupplyValue(double supplyValue) {
        this.supplyValue = supplyValue;
    }

}
