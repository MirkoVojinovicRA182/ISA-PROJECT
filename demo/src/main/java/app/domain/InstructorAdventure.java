package app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InstructorAdventure {
    @Id
    @SequenceGenerator(name = "instructorAdventureIdSeqGen", sequenceName = "instructorAdventureIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructorAdventureIdSeqGen")

    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "promotionalDescription", unique = false, nullable = false)
    private String promotionalDescription;

    @Column(name = "instructorBiography", unique = false, nullable = false)
    private String instructorBiography;

    //private List<String> images;

    @Column(name = "maxCountOfParticipants", unique = false, nullable = false)
    private int maxCountOfParticipants;

    @Column(name = "rulesOfConduct", unique = false, nullable = false)
    private String rulesOfConduct;

    @Column(name = "defaultEquipment", unique = false, nullable = false)
    private String defaultEquipment;

    @Column(name = "pricelist", unique = false, nullable = false)
    private String pricelist;

    @Column(name = "termsOfUse", unique = false, nullable = false)
    private String termsOfUse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public InstructorAdventure() {
    }

    public InstructorAdventure(String name, String address, String promotionalDescription, String instructorBiography, int maxCountOfParticipants, String rulesOfConduct, String defaultEquipment, String pricelist, String termsOfUse, Instructor instructor) {
        this.name = name;
        this.address = address;
        this.promotionalDescription = promotionalDescription;
        this.instructorBiography = instructorBiography;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.rulesOfConduct = rulesOfConduct;
        this.defaultEquipment = defaultEquipment;
        this.pricelist = pricelist;
        this.termsOfUse = termsOfUse;
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    /*public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }*/

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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
