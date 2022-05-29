package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CottageImage {

    @Id
    @SequenceGenerator(name = "ctgImgIdSeqGen", sequenceName = "ctgImgIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imgIdSeqGen")
    private Integer id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    @JsonBackReference
    private Cottage cottage;

    public CottageImage() {
    }

    public CottageImage(String url, Cottage cottage) {
        this.url = url;
        this.cottage = cottage;
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

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }
}
