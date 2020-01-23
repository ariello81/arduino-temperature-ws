package pl.ryzykowski.arduino.arduinotemperaturews.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class CoalConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    private int kgValue;

    public CoalConsumption() {
    }

    public CoalConsumption(Long id, Timestamp timestamp, int kgValue) {
        this.id = id;
        this.timestamp = timestamp;
        this.kgValue = kgValue;
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

    public int getKgValue() {
        return kgValue;
    }

    public void setKgValue(int kgValue) {
        this.kgValue = kgValue;
    }
}
