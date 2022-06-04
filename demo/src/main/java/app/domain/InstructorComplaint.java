package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class InstructorComplaint {

    @Id
    @SequenceGenerator(name = "iComplIdSeqGen", sequenceName = "iComplIdSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iComplIdSeqGen")
    private Integer id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    @JsonBackReference
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public InstructorComplaint() {
    }

    public InstructorComplaint(String text, Instructor instructor, Client client) {
        this.text = text;
        this.instructor = instructor;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
