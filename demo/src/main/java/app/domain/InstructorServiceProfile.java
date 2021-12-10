package app.domain;

import java.util.List;

public class InstructorServiceProfile {
    private Long id;
    private String name;
    private String address;
    private String promotionalDescription;
    private String instructorBiography;
    private List<String> images;
    private int maxCountOfParticipants;
    private List<FastFishingReservation> fastFishingReservations;
    private String rulesOfConduct;
    private String defaultEquipment;
    private String pricelist;
    private String termsOfUse;

    public InstructorServiceProfile() {
    }

    public InstructorServiceProfile(Long id, String name, String address, String promotionalDescription, String instructorBiography, List<String> images, int maxCountOfParticipants, List<FastFishingReservation> fastFishingReservations, String rulesOfConduct, String defaultEquipment, String pricelist, String termsOfUse) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.promotionalDescription = promotionalDescription;
        this.instructorBiography = instructorBiography;
        this.images = images;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.fastFishingReservations = fastFishingReservations;
        this.rulesOfConduct = rulesOfConduct;
        this.defaultEquipment = defaultEquipment;
        this.pricelist = pricelist;
        this.termsOfUse = termsOfUse;
    }

    public InstructorServiceProfile(String name, String address, String promotionalDescription, String instructorBiography, List<String> images, int maxCountOfParticipants, List<FastFishingReservation> fastFishingReservations, String rulesOfConduct, String defaultEquipment, String pricelist, String termsOfUse) {
        this.name = name;
        this.address = address;
        this.promotionalDescription = promotionalDescription;
        this.instructorBiography = instructorBiography;
        this.images = images;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.fastFishingReservations = fastFishingReservations;
        this.rulesOfConduct = rulesOfConduct;
        this.defaultEquipment = defaultEquipment;
        this.pricelist = pricelist;
        this.termsOfUse = termsOfUse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getMaxCountOfParticipants() {
        return maxCountOfParticipants;
    }

    public void setMaxCountOfParticipants(int maxCountOfParticipants) {
        this.maxCountOfParticipants = maxCountOfParticipants;
    }

    public List<FastFishingReservation> getFastFishingReservations() {
        return fastFishingReservations;
    }

    public void setFastFishingReservations(List<FastFishingReservation> fastFishingReservations) {
        this.fastFishingReservations = fastFishingReservations;
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
}
