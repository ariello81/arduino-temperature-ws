package pl.ryzykowski.arduino.arduinotemperaturews.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @CreationTimestamp
    private Timestamp timestamp;

    @OneToMany(mappedBy = "location")
    private List<Temperature> temperatures;

    public Location() {
    }

    public Location(String description) {
        this.description = description;
    }

    public Location(Long id, String description, Timestamp timestamp, List<Temperature> temperatures) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
        this.temperatures = temperatures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }
}
