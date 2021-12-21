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
    private String pricelist;
    private String termsOfUse;
    private int instructorId;

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
        pricelist = a.getPricelist();
        termsOfUse = a.getTermsOfUse();
        instructorId = a.getInstructor().getId();
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

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
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
}
