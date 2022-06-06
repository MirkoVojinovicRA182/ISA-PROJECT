package app.domain;

import app.dto.ChangeCottageDTO;
import app.dto.CottageDTO;
import app.dto.InstructorAdventureDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cottage {
    @Id
    @SequenceGenerator(name = "cottageSeqGen", sequenceName = "cottageSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cottageSeqGen")
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "promotiveDescription", unique = false, nullable = false)
    private String promotiveDescription;

    @Column(name = "conductRules", unique = false, nullable = false)
    private String conductRules;

    @Column(name = "pricelist", unique = false, nullable = false)
    private Double pricelist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_owner_id")
    @JsonBackReference(value = "cottage_owner")
    private CottageOwner cottageOwner;

    @OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL)
    @JsonBackReference(value = "cottage_reservations")
    private Set<CottageReservation> cottageReservations = new HashSet<>();
    
    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "cottage_complaints")
    private Set<CottageComplaint> complaints = new HashSet<CottageComplaint>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "cottage_images")
    private Set<CottageImage> images = new HashSet<>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "cottage_rooms")
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "cottage_marks")
    private Set<Mark> marks = new HashSet<>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "cottage_cottage_availability")
    private Set<CottageAvailability> cottageAvailability = new HashSet<>();

    public Cottage() {
        super();
    }

    public Cottage(String name, String address, String promotiveDescription, String conductRules, Double pricelist, CottageOwner cottageOwner) {
        super();
        this.name = name;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.cottageOwner = cottageOwner;
    }

    public Integer getId() {
        return id;
    }

    public Set<CottageImage> getImages() {
        return images;
    }

    public void setImages(Set<CottageImage> images) {
        this.images = images;
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

    public CottageOwner getCottageOwner() {
        return cottageOwner;
    }

    public void setCottageOwner(CottageOwner cottageOwner) {
        this.cottageOwner = cottageOwner;
    }

    public Set<CottageReservation> getCottageReservations() {
        return cottageReservations;
    }

    public void setCottageReservations(Set<CottageReservation> cottageReservations) {
        this.cottageReservations = cottageReservations;
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

    public boolean addImage(CottageImage image) {
        return images.add(image);
    }

    public void rateCottage(Mark mark) {
        marks.add(mark);
    }

    public Integer getRating() {
        Integer sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMark();
        }
        return sum / marks.size();
    }

    public Integer getBedsNumber(){
        Integer bedsNumber = 0;
        for(Room room : getRooms()){
            bedsNumber += room.getBedsNumber();
        }
        return bedsNumber;
    }

    public void update(ChangeCottageDTO cottageDTO) {
        setName(cottageDTO.getName());
        setAddress(cottageDTO.getAddress());
        setPromotiveDescription(cottageDTO.getPromotiveDescription());
        setConductRules(cottageDTO.getConductRules());
        setPricelist(cottageDTO.getPricelist());
    }

    public Set<CottageAvailability> getCottageAvailability() {
        return cottageAvailability;
    }

    public void setCottageAvailability(Set<CottageAvailability> cottageAvailability) {
        this.cottageAvailability = cottageAvailability;
    }
}
