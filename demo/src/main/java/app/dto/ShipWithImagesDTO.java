package app.dto;

import app.domain.Ship;
import app.domain.ShipImage;

import java.util.HashSet;
import java.util.Set;

public class ShipWithImagesDTO {

    private Integer shipId;
    private String name;
    private String type;
    private double length;
    private Integer engineNumber;
    private double enginePower;
    private double maxSpeed;
    private String address;
    private String promotiveDescription;
    private Integer capacity;
    private String conductRules;
    private Double pricelist;
    private String additionalServicesInfo;
    private String cancellationPolicy;
    private Integer shipOwnerId;
    private Double rating;

    private Set<ShipImage> images;

    public ShipWithImagesDTO(){
        super();
    }

    public ShipWithImagesDTO(Integer shipId, String name, String type, double length, Integer engineNumber,
                   double enginePower, double maxSpeed, String address, String promotiveDescription,
                   Integer capacity, String conductRules, Double pricelist, String additionalServicesInfo,
                   String cancellationPolicy, Integer shipOwnerId) {
        this.shipId = shipId;
        this.name = name;
        this.type = type;
        this.length = length;
        this.engineNumber = engineNumber;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.capacity = capacity;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.additionalServicesInfo = additionalServicesInfo;
        this.cancellationPolicy = cancellationPolicy;
        this.shipOwnerId = shipOwnerId;
        this.images = new HashSet<>();
    }

    public ShipWithImagesDTO(Ship ship) {
        this.shipId = ship.getId();
        this.name = ship.getName();
        this.type = ship.getType();
        this.length = ship.getLength();
        this.engineNumber = ship.getEngineNumber();
        this.enginePower = ship.getEnginePower();
        this.maxSpeed = ship.getMaxSpeed();
        this.address = ship.getAddress();
        this.promotiveDescription = ship.getPromotiveDescription();
        this.capacity = ship.getCapacity();
        this.conductRules = ship.getConductRules();
        this.pricelist = ship.getPricelist();
        this.additionalServicesInfo = ship.getAdditionalServicesInfo();
        this.cancellationPolicy = ship.getCancellationPolicy();
        this.shipOwnerId = ship.getShipOwner().getId();
        this.rating = ship.getRating();
        this.images = (ship.getImages()  != null) ? ship.getImages() : new HashSet<>();
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromotiveDescription() {
        return promotiveDescription;
    }

    public void setPromotiveDescription(String promotiveDescription) {
        this.promotiveDescription = promotiveDescription;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getConductRules() {
        return conductRules;
    }

    public void setConductRules(String conductRules) {
        this.conductRules = conductRules;
    }

    public Double getPricelist() {
        return pricelist;
    }

    public void setPricelist(Double pricelist) {
        this.pricelist = pricelist;
    }

    public String getAdditionalServicesInfo() {
        return additionalServicesInfo;
    }

    public void setAdditionalServicesInfo(String additionalServicesInfo) {
        this.additionalServicesInfo = additionalServicesInfo;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public Integer getShipOwnerId() {
        return shipOwnerId;
    }

    public void setShipOwnerId(Integer shipOwnerId) {
        this.shipOwnerId = shipOwnerId;
    }

    public Set<ShipImage> getImages() {
        return images;
    }

    public void setImages(Set<ShipImage> images) {
        this.images = images;
    }
}
