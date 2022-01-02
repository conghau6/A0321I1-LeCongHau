package com.codegym.furama.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(columnDefinition = "VARCHAR(45)")
    private String positionName;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Integer positionId) {
        this.positionId = positionId;
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer id) {
        this.positionId = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
