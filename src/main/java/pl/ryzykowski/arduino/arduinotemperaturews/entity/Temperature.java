package pl.ryzykowski.arduino.arduinotemperaturews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("x")
    @CreationTimestamp
    private Timestamp timestamp;

    @JsonProperty("y")
    private double celsiusValue;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    public Temperature() {
    }

    public Temperature(double celsiusValue, Location location) {
        this.celsiusValue = celsiusValue;
        this.location = location;
    }

    public Temperature(Long locationId, double celsiusValue) {
        this.locationId = locationId;
        this.celsiusValue = celsiusValue;
    }

    public Temperature(Long id, double celsiusValue, Timestamp timestamp, Location location) {
        this.id = id;
        this.celsiusValue = celsiusValue;
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

    public double getCelsiusValue() {
        return celsiusValue;
    }

    public void setCelsiusValue(double celsiusValue) {
        this.celsiusValue = celsiusValue;
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
