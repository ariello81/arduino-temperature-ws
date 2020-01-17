package pl.ryzykowski.arduino.arduinotemperaturews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Long locationId;

    @CreationTimestamp
    private Timestamp timestamp;

    private double value;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    public Temperature() {
    }

    public Temperature(double value, Location location) {
        this.value = value;
        this.location = location;
    }

    public Temperature(Long locationId, double value) {
        this.locationId = locationId;
        this.value = value;
    }

    public Temperature(Long id, double value, Timestamp timestamp, Location location) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
