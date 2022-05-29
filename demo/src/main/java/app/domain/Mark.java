package app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @SequenceGenerator(name = "markSeqGen", sequenceName = "markSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "markSeqGen")
    private Integer id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cottage_id")
    @JsonBackReference
    private Cottage cottage;

    public Mark() {}

    public Mark(Integer id, Integer mark, Integer userId, Cottage cottage) {
        this.id = id;
        this.mark = mark;
        this.userId = userId;
        this.cottage = cottage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }
}
