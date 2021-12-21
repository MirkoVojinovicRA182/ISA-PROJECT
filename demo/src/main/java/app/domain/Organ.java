package app.domain;

import javax.persistence.*;

@Entity
public class Organ {
    @Id
    @SequenceGenerator(name = "organSeqGen", sequenceName = "organSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organSeqGen")
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "body_id")
    private Body body;

    public Organ(String name, Body body) {
        this.name = name;
        this.body = body;
    }

    public Organ() {

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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
