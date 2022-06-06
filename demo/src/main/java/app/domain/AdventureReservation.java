package app.domain;

import app.dto.AdventureReservationDTO;
import app.dto.CottageReservationDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AdventureReservation {
    @Id
    @SequenceGenerator(name = "adventureReservationIdSeqGen", sequenceName = "adventureReservationIdSeq", initialValue = 16, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventureReservationIdSeqGen")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column
    private LocalDateTime endTime;

    @Column
    private Integer price;

    @OneToMany(mappedBy = "adventureReservation", cascade = CascadeType.ALL)
    private Set<AdventureAdditionalService> adventureAdditionalServices = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public AdventureReservation(){}

    public AdventureReservation(LocalDateTime startTime, LocalDateTime endTime, Client client,
                                InstructorAdventure instructorAdventure, Integer price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.adventure = instructorAdventure;
        this.price = price;
    }

    public AdventureReservation(AdventureReservationDTO dto, InstructorAdventure adventure, Client client) {
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.price = dto.getPrice();
        this.client = client;
        this.adventure = adventure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Column
    private Double bill;

    @Column
    private Double systemSallary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_id")
    private InstructorAdventure adventure;

    public AdventureReservation(LocalDateTime startTime, LocalDateTime endTime, Client client, InstructorAdventure adventure, Double bill, Double systemSallary) {
        this.startTime = startTime;
        this.endTime = endTime.plusHours(1);
        this.client = client;
        this.adventure = adventure;
        this.bill = bill;
        this.systemSallary = systemSallary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id;}

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Set<AdventureAdditionalService> getAdventureAdditionalServices() {
        return adventureAdditionalServices;
    }

    public void setAdventureAdditionalServices(Set<AdventureAdditionalService> adventureAdditionalServices) {
        this.adventureAdditionalServices = adventureAdditionalServices;
    }

    public InstructorAdventure getAdventure() {
        return adventure;
    }

    public void setAdventure(InstructorAdventure adventure) {
        this.adventure = adventure;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Double getSystemSallary() {
        return systemSallary;
    }

    public void setSystemSallary(Double systemSallary) {
        this.systemSallary = systemSallary;
    }
}
