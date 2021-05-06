package ru.fintech.qa.homework.db.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Positions {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "salary")
    private int salary;

    public  int getId() {
        return id;
    }

    public  void setId( int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public  void setName( String name) {
        this.name = name;
    }

    public  int getSalary() {
        return salary;
    }

    public  void setSalary( int salary) {
        this.salary = salary;
    }
}