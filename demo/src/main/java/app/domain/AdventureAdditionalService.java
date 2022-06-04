package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class AdventureAdditionalService {

    @Id
    @SequenceGenerator(name = "addSerIdSeqGen", sequenceName = "addSerIdSeq", initialValue = 4, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addSerIdSeqGen")
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "price", unique = false, nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_id")
    @JsonBackReference
    private InstructorAdventure adventure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_reservation_id")
    private AdventureReservation adventureReservation;

    public AdventureAdditionalService() {
    }

    public AdventureAdditionalService(String name, Long price, InstructorAdventure adventure) {
        this.name = name;
        this.price = price;
        this.adventure = adventure;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public InstructorAdventure getAdventure() {
        return adventure;
    }

    public void setAdventure(InstructorAdventure adventure) {
        this.adventure = adventure;
    }
}
