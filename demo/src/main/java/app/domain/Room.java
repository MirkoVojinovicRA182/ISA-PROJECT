package app.domain;


import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @SequenceGenerator(name = "roomSeqGen", sequenceName = "roomSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomSeqGen")
    private Integer id;

    @Column(name = "roomNumber", unique = false, nullable = false)
    private Integer roomNumber;

    @Column(name = "bedsNumber", unique = false, nullable = false)
    private Integer bedsNumber;

    @Column(name = "bathroom", unique = false, nullable = false)
    private boolean bathroom;

    @Column(name = "clime", unique = false, nullable = false)
    private boolean clime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    private Cottage cottage;


    public Room(){}

    public Room(Integer id, Integer roomNumber, Integer bedsNumber, boolean bathroom, boolean clime, Cottage cottage) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.bedsNumber = bedsNumber;
        this.bathroom = bathroom;
        this.clime = clime;
        this.cottage = cottage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(Integer bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public boolean isClime() {
        return clime;
    }

    public void setClime(boolean clime) {
        this.clime = clime;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }
}
