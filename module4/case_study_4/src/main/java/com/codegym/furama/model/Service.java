package com.codegym.furama.model;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenient;
    private Double poolArea;
    private Integer numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    public Service() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenient() {
        return descriptionOtherConvenient;
    }

    public void setDescriptionOtherConvenient(String descriptionOtherConvenient) {
        this.descriptionOtherConvenient = descriptionOtherConvenient;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }


}
