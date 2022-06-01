package app.dto;

import app.domain.Cottage;

import java.util.HashSet;

public class ChangeCottageDTO {

    private Integer cottageId;
    private String name;
    private String address;
    private String promotiveDescription;
    private String conductRules;
    private String pricelist;
    private Integer cottageOwnerId;

    public ChangeCottageDTO(){
        super();
    }

    public ChangeCottageDTO(Cottage cottage){
        this.cottageId = cottage.getId();
        this.name = cottage.getName();
        this.address = cottage.getAddress();
        this.promotiveDescription = cottage.getPromotiveDescription();
        this.conductRules = cottage.getConductRules();
        this.pricelist = cottage.getPricelist();
        this.cottageOwnerId = cottage.getCottageOwner().getId();
    }

    public ChangeCottageDTO(Integer cottageId, String name, String address, String promotiveDescription, String conductRules, String pricelist, int cottageOwnerId) {
        super();
        this.cottageId = cottageId;
        this.name = name;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.cottageOwnerId = cottageOwnerId;
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

    public Integer getCottageOwnerId() {
        return cottageOwnerId;
    }

    public void setCottageOwnerId(Integer cottageOwnerId) {
        this.cottageOwnerId = cottageOwnerId;
    }
}
