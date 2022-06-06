package app.dto;

import app.domain.InstructorAdventure;

public class InstructorAdventureDTO {
    private Integer id;
    private String name;
    private String address;
    private String promotionalDescription;
    private String instructorBiography;
    private Integer maxCountOfParticipants;
    private String rulesOfConduct;
    private String defaultEquipment;
    private Double price;
    private String termsOfUse;
    private int instructorId;
    private boolean isReserved;
    private Double rating;

    public InstructorAdventureDTO() {
    }

    public InstructorAdventureDTO(InstructorAdventure a) {
        id = a.getId();
        name = a.getName();
        address = a.getAddress();
        promotionalDescription = a.getPromotionalDescription();
        instructorBiography = a.getInstructorBiography();
        maxCountOfParticipants = a.getMaxCountOfParticipants();
        rulesOfConduct = a.getRulesOfConduct();
        defaultEquipment = a.getDefaultEquipment();
        price = a.getPrice();
        termsOfUse = a.getTermsOfUse();
        instructorId = a.getInstructor().getId();
        rating = a.getRating();
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaxCountOfParticipants(Integer maxCountOfParticipants) {
        this.maxCountOfParticipants = maxCountOfParticipants;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
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

    public String getPromotionalDescription() {
        return promotionalDescription;
    }

    public void setPromotionalDescription(String promotionalDescription) {
        this.promotionalDescription = promotionalDescription;
    }

    public String getInstructorBiography() {
        return instructorBiography;
    }

    public void setInstructorBiography(String instructorBiography) {
        this.instructorBiography = instructorBiography;
    }

    public int getMaxCountOfParticipants() {
        return maxCountOfParticipants;
    }

    public void setMaxCountOfParticipants(int maxCountOfParticipants) {
        this.maxCountOfParticipants = maxCountOfParticipants;
    }

    public String getRulesOfConduct() {
        return rulesOfConduct;
    }

    public void setRulesOfConduct(String rulesOfConduct) {
        this.rulesOfConduct = rulesOfConduct;
    }

    public String getDefaultEquipment() {
        return defaultEquipment;
    }

    public void setDefaultEquipment(String defaultEquipment) {
        this.defaultEquipment = defaultEquipment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
