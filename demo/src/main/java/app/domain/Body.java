package app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Body {
    @Id
    @SequenceGenerator(name = "bodySeqGen", sequenceName = "bodySeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bodySeqGen")
    private Integer id;

    @Column(name = "description", unique = false, nullable = false)
    private String description;

    @OneToMany(mappedBy = "body", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Organ> organList = new ArrayList<Organ>();

    public Body(String description, List<Organ> organList) {
        this.description = description;
        this.organList = organList;
    }

    public Body() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Organ> getOrganList() {
        return organList;
    }

    public void setOrganList(List<Organ> organList) {
        this.organList = organList;
    }
}
