package app.domain;

import app.dto.CottageDTO;
import app.dto.InstructorAdventureDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cottage {
    @Id
    @SequenceGenerator(name = "cottageSeqGen", sequenceName = "cottageSeq", initialValue = 1, allocationSize = 1)
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
    private String pricelist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_owner_id")
    @JsonBackReference
    private CottageOwner cottageOwner;

    @OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<CottageReservation> cottageReservations = new HashSet<>();
    
    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<CottageComplaint> complaints = new HashSet<CottageComplaint>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<CottageImage> images = new HashSet<>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Mark> marks = new HashSet<>();

    public Cottage() {
        super();
    }

    public Cottage(String name, String address, String promotiveDescription, String conductRules, String pricelist, CottageOwner cottageOwner, Set<Room> rooms) {
        super();
        this.name = name;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.cottageOwner = cottageOwner;
        this.rooms = rooms;
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

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
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

    public void update(CottageDTO cottageDTO) {
        setName(cottageDTO.getName());
        setAddress(cottageDTO.getAddress());
        setPromotiveDescription(cottageDTO.getPromotiveDescription());
        setConductRules(cottageDTO.getConductRules());
        setPricelist(cottageDTO.getPricelist());
    }
}
