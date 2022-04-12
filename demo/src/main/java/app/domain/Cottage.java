package app.domain;

import app.dto.CottageDTO;
import app.dto.InstructorAdventureDTO;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "roomsNumber", unique = false, nullable = false)
    private int roomsNumber;

    @Column(name = "bedsNumber", unique = false, nullable = false)
    private int bedsNumber;

    @Column(name = "conductRules", unique = false, nullable = false)
    private String conductRules;

    @Column(name = "pricelist", unique = false, nullable = false)
    private String pricelist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_owner_id")
    private CottageOwner cottageOwner;

    @OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL)
    private Set<CottageReservation> cottageReservations = new HashSet<>();
    
    @OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<CottageComplaint> complaints = new HashSet<CottageComplaint>();


    public Cottage() {
        super();
    }

    public Cottage(String name, String address, String promotiveDescription, int roomsNumber, int bedsNumber, String conductRules, String pricelist, CottageOwner cottageOwner) {
        super();
        this.name = name;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.roomsNumber = roomsNumber;
        this.bedsNumber = bedsNumber;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.cottageOwner = cottageOwner;
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

    public String getPromotiveDescription() {
        return promotiveDescription;
    }

    public void setPromotiveDescription(String promotiveDescription) {
        this.promotiveDescription = promotiveDescription;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(int bedsNumber) {
        this.bedsNumber = bedsNumber;
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

    public void update(CottageDTO cottageDTO) {
        setName(cottageDTO.getName());
        setAddress(cottageDTO.getAddress());
        setPromotiveDescription(cottageDTO.getPromotiveDescription());
        setRoomsNumber(cottageDTO.getRoomsNumber());
        setBedsNumber(cottageDTO.getBedsNumber());
        setConductRules(cottageDTO.getConductRules());
        setPricelist(cottageDTO.getPricelist());
    }
}
