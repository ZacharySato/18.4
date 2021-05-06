package ru.fintech.qa.homework.db.hibernate.models;


import jakarta.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "zoo_animal")
public class ZooAnimal {
    @Id
    private int id;
    @Column(name = "animal_id")
    @NotNull
    private int animalId;
    @Column(name = "workman")
    private int workman;
    @Column(name = "time_apperance")
    private java.sql.Timestamp timeApperance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getWorkman() {
        return workman;
    }

    public void setWorkman(int workman) {
        this.workman = workman;
    }

    public Timestamp getTimeApperance() {
        return timeApperance;
    }

    public void setTimeApperance(Timestamp timeApperance) {
        this.timeApperance = timeApperance;
    }
}