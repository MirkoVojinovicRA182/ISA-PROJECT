package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CottageComplaint {
    @Id
    @SequenceGenerator(name = "cComplIdSeqGen", sequenceName = "cComplIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cComplIdSeqGen")
    private Integer id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    private Cottage cottage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_owner_id")
    private CottageOwner cottageOwner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public CottageComplaint() {
    }

    public CottageComplaint(String text, Cottage cottage, CottageOwner cottageOwner, Client client) {
        this.text = text;
        this.cottage = cottage;
        this.cottageOwner = cottageOwner;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }

    public CottageOwner getCottageOwner() {
        return cottageOwner;
    }

    public void setCottageOwner(CottageOwner cottageOwner) {
        this.cottageOwner = cottageOwner;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
