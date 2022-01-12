package app.domain;

import javax.persistence.*;

@Entity
public class Ship {
    @Id
    @SequenceGenerator(name = "shipSeqGen", sequenceName = "shipSeq", initialValue = 1, allocationSize = 1)
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
    private String pricelist;

    @Column(name = "additionalServicesInfo", unique = false, nullable = false)
    private String additionalServicesInfo;

    @Column(name = "cancellationPolicy", unique = false, nullable = false)
    private String cancellationPolicy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_owner_id")
    private ShipOwner shipOwner;
}

