package app.domain;

import app.dto.ShipDTO;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {
    @Id
    @SequenceGenerator(name = "shipSeqGen", sequenceName = "shipSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipSeqGen")
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "type", unique = false, nullable = false)
    private String type;

    @Column(name = "length", unique = false, nullable = false)
    private double length;

    @Column(name = "engineNumber", unique = false, nullable = false)
    private Integer engineNumber;

    @Column(name = "enginePower", unique = false, nullable = false)
    private double enginePower;

    @Column(name = "maxSpeed", unique = false, nullable = false)
    private double maxSpeed;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "promotiveDescription", unique = false, nullable = false)
    private String promotiveDescription;

    @Column(name = "capacity", unique = false, nullable = false)
    private Integer capacity;

    @Column(name = "conductRules", unique = false, nullable = false)
    private String conductRules;

    @Column(name = "pricelist", unique = false, nullable = false)
    private Double pricelist;

    @Column(name = "additionalServicesInfo", unique = false, nullable = false)
    private String additionalServicesInfo;

    @Column(name = "cancellationPolicy", unique = false, nullable = false)
    private String cancellationPolicy;

    @Column(name = "rating", unique = false, nullable = false)
    private Double rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_owner_id")
    private ShipOwner shipOwner;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private Set<ShipReservation> shipReservations = new HashSet<>();
    
    @OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<ShipComplaint> complaints = new HashSet<ShipComplaint>();
    
    @OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "ship_images")
    private Set<ShipImage> images = new HashSet<>();

    @OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "ship_ship_availability")
    private Set<ShipAvailability> shipAvailability = new HashSet<>();

    @OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<ActionShip> actionShips;

    public Ship() {
        super();
    }

    public Ship(String name, String type, double length, Integer engineNumber, double enginePower, double maxSpeed, String address, String promotiveDescription, Integer capacity, String conductRules, Double pricelist, String additionalServicesInfo, String cancellationPolicy, ShipOwner shipOwner) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.engineNumber = engineNumber;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.address = address;
        this.promotiveDescription = promotiveDescription;
        this.capacity = capacity;
        this.conductRules = conductRules;
        this.pricelist = pricelist;
        this.additionalServicesInfo = additionalServicesInfo;
        this.cancellationPolicy = cancellationPolicy;
        this.shipOwner = shipOwner;
    }

    public Set<ActionShip> getActionShips() {
        return actionShips;
    }

    public void setActionShips(Set<ActionShip> actionShips) {
        this.actionShips = actionShips;
    }

    public Set<ShipAvailability> getShipAvailability() {
        return shipAvailability;
    }

    public void setShipAvailability(Set<ShipAvailability> shipAvailability) {
        this.shipAvailability = shipAvailability;
    }

    public Set<ShipImage> getImages() {
		return images;
	}

	public void setImages(Set<ShipImage> images) {
		this.images = images;
	}

	public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setShipReservations(Set<ShipReservation> shipReservations) {
        this.shipReservations = shipReservations;
    }

    public Set<ShipComplaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<ShipComplaint> complaints) {
        this.complaints = complaints;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public String getAdditionalServicesInfo() {
        return additionalServicesInfo;
    }

    public void setAdditionalServicesInfo(String additionalServicesInfo) {
        this.additionalServicesInfo = additionalServicesInfo;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public ShipOwner getShipOwner() {
        return shipOwner;
    }

    public void setShipOwner(ShipOwner shipOwner) {
        this.shipOwner = shipOwner;
    }

    public Set<ShipReservation> getShipReservations() { return shipReservations; }

    public void update(ShipDTO shipDTO){
        setAdditionalServicesInfo(shipDTO.getAdditionalServicesInfo());
        setAddress(shipDTO.getAddress());
        setConductRules(shipDTO.getConductRules());
        setCapacity(shipDTO.getCapacity());
        setPricelist(shipDTO.getPricelist());
        setCancellationPolicy(shipDTO.getCancellationPolicy());
        setEngineNumber(shipDTO.getEngineNumber());
        setEnginePower(shipDTO.getEnginePower());
        setLength(shipDTO.getLength());
        setMaxSpeed(shipDTO.getMaxSpeed());
        setName(shipDTO.getName());
        setPromotiveDescription(shipDTO.getPromotiveDescription());
        setType(shipDTO.getType());
    }

}

