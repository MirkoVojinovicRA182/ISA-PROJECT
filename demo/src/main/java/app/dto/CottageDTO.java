package app.dto;

import app.domain.*;

import java.util.HashSet;
import java.util.Set;

public class CottageDTO {
    private Integer cottageId;
    private String name;
    private String address;
    private String promotiveDescription;
    private String conductRules;
    private Double pricelist;
    private Integer cottageOwnerId;
    private Set<CottageImage> images;
    private Set<Room> rooms;
    private Set<Mark> marks;
    private Set<CottageAvailability> cottageAvailability;

    public CottageDTO(){
        super();
    }

    public CottageDTO(Cottage cottage){
        this.cottageId = cottage.getId();
        this.name = cottage.getName();
        this.address = cottage.getAddress();
        this.promotiveDescription = cottage.getPromotiveDescription();
        this.conductRules = cottage.getConductRules();
        this.pricelist = cottage.getPricelist();
        this.cottageOwnerId = cottage.getCottageOwner().getId();
        this.images = (cottage.getImages()  != null) ? cottage.getImages() : new HashSet<>();
        this.rooms = (cottage.getRooms()  != null) ? cottage.getRooms() : new HashSet<>();
        this.marks = (cottage.getMarks()  != null) ? cottage.getMarks() : new HashSet<>();
        this.cottageAvailability = (cottage.getCottageAvailability()  != null) ? cottage.getCottageAvailability() : new HashSet<>();
    }

    public CottageDTO(Integer cottageId, String name, String address, String promotiveDescription, String conductRules, Double pricelist, int cottageOwnerId) {
        super();
        this.cottageId = cottageId;
        this.name = name;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.cottageOwnerId = cottageOwnerId;
        this.images = new HashSet<>();
        this.rooms = new HashSet<>();
        this.marks = new HashSet<>();
        this.cottageAvailability = new HashSet<>();
    }

    public Integer getCottageId() {
        return cottageId;
    }

    public void setCottageId(Integer cottageId) {
        this.cottageId = cottageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCottageOwnerId() {
        return cottageOwnerId;
    }

    public void setCottageOwnerId(Integer cottageOwnerId) {
        this.cottageOwnerId = cottageOwnerId;
    }

    public Set<CottageImage> getImages() {
        return images;
    }

    public void setImages(Set<CottageImage> images) {
        this.images = images;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Set<CottageAvailability> getCottageAvailability() {
        return cottageAvailability;
    }

    public void setCottageAvailability(Set<CottageAvailability> cottageAvailability) {
        this.cottageAvailability = cottageAvailability;
    }
}
