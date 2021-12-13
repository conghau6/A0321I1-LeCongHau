package com.codegym.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "status")
    private Set<Code> codeAvailableSet;

    public Status() {
    }

    public Status(Integer id) {
        this.id = id;
    }

    public Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Code> getCodeAvailableSet() {
        return codeAvailableSet;
    }

    public void setCodeAvailableSet(Set<Code> codeAvailableSet) {
        this.codeAvailableSet = codeAvailableSet;
    }
}
