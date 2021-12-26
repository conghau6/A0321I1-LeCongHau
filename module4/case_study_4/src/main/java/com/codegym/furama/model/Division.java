package com.codegym.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;

    @Column(columnDefinition = "VARCHAR(45)")
    private String divisionName;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Division() {
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer id) {
        this.divisionId = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
