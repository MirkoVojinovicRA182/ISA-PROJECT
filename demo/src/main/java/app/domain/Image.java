package app.domain;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @SequenceGenerator(name = "imgIdSeqGen", sequenceName = "imgIdSeq", initialValue = 4, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imgIdSeqGen")
    private Integer id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adventure_id")
    private InstructorAdventure adventure;

    public Image() {
    }

    public Image(String url, InstructorAdventure adventure) {
        this.url = url;
        this.adventure = adventure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InstructorAdventure getAdventure() {
        return adventure;
    }

    public void setAdventure(InstructorAdventure adventure) {
        this.adventure = adventure;
    }
}
