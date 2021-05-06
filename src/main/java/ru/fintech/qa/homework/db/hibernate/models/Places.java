package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public final class Places {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"row\"")
    private int row;
    @Column(name = "place_num")
    private int placeNum;

    public  int getId() {
        return id;
    }

    public  void setId(final int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public  void setName(final String name) {
        this.name = name;
    }

    public  int getRow() {
        return row;
    }

    public  void setRow(final int row) {
        this.row = row;
    }

    public  int getPlaceNum() {
        return placeNum;
    }

    public  void setPlacNum(final int placeN) {
        this.placeNum = placeN;
    }
}