package app.dto;

import app.domain.Cottage;
import app.domain.CottageImage;
import app.domain.Room;

import java.util.HashSet;
import java.util.Set;

public class CottageDTO {
    private Integer cottageId;
    private String name;
    private String address;
    private String promotiveDescription;
    private String conductRules;
    private String pricelist;
    private Integer cottageOwnerId;
    private Set<CottageImage> images;
    private Set<Room> rooms;

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
        this.images = cottage.getImages();
        this.rooms = cottage.getRooms();
    }

    public CottageDTO(Integer cottageId, String name, String address, String promotiveDescription, String conductRules, String pricelist, int cottageOwnerId) {
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

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
    }

    public int getCottageOwnerId() {
        return cottageOwnerId;
    }

    public void setCottageOwnerId(int cottageOwnerId) {
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
}
