package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "\"type\"")
    private int type;
    @Column(name = "sex")
    private int sex;
    @Column(name = "place")
    private int place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

}