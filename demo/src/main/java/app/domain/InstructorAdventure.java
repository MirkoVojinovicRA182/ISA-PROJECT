package app.domain;

import app.dto.InstructorAdventureDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InstructorAdventure {
    @Id
    @SequenceGenerator(name = "instructorAdventureIdSeqGen", sequenceName = "instructorAdventureIdSeq", initialValue = 6, allocationSize = 1)
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

    @Column(name = "maxCountOfParticipants", unique = false, nullable = false)
    private int maxCountOfParticipants;

    @Column(name = "rulesOfConduct", unique = false, nullable = false)
    private String rulesOfConduct;

    @Column(name = "defaultEquipment", unique = false, nullable = false)
    private String defaultEquipment;

    @Column(name = "price", unique = false, nullable = false)
    private Double price;

    @Column(name = "termsOfUse", unique = false, nullable = false)
    private String termsOfUse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(mappedBy = "adventure", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AdventureAdditionalService> additionalServices;

    @OneToMany(mappedBy = "instructorAdventure", cascade = CascadeType.ALL)
    private Set<AdventureReservation> adventureReservations = new HashSet<>();

    @OneToMany(mappedBy = "adventure", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Image> images;

    @OneToMany(mappedBy = "adventure", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<ActionAdventure> actionAdventures;

    public InstructorAdventure() {}

    public InstructorAdventure(Integer id, String name, String address, String promotionalDescription, String instructorBiography,
                               int maxCountOfParticipants, String rulesOfConduct, String defaultEquipment, Double price,
                               String termsOfUse, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.promotionalDescription = promotionalDescription;
        this.instructorBiography = instructorBiography;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.rulesOfConduct = rulesOfConduct;
        this.defaultEquipment = defaultEquipment;
        this.price = price;
        this.termsOfUse = termsOfUse;
        this.instructor = instructor;
    }

    public InstructorAdventure(String name, String address, String promotionalDescription, String instructorBiography, int maxCountOfParticipants, String rulesOfConduct, String defaultEquipment, Double price, String termsOfUse, Instructor instructor) {
        this.name = name;
        this.address = address;
        this.promotionalDescription = promotionalDescription;
        this.instructorBiography = instructorBiography;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.rulesOfConduct = rulesOfConduct;
        this.defaultEquipment = defaultEquipment;
        this.price = price;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<AdventureAdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<AdventureAdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<AdventureReservation> getAdventureReservations() {
        return adventureReservations;
    }

    public void setAdventureReservations(Set<AdventureReservation> adventureReservations) {
        this.adventureReservations = adventureReservations;
    }

    public Set<ActionAdventure> getActionAdventures() {
        return actionAdventures;
    }

    public void setActionAdventures(Set<ActionAdventure> actionAdventures) {
        this.actionAdventures = actionAdventures;
    }

    public void update(InstructorAdventureDTO dto) {
        setName(dto.getName());
        setAddress(dto.getAddress());
        setPromotionalDescription(dto.getPromotionalDescription());
        setInstructorBiography(dto.getInstructorBiography());
        setMaxCountOfParticipants(dto.getMaxCountOfParticipants());
        setRulesOfConduct(dto.getRulesOfConduct());
        setDefaultEquipment(dto.getDefaultEquipment());
        setPrice(dto.getPrice());
        setTermsOfUse(dto.getTermsOfUse());
    }

}
