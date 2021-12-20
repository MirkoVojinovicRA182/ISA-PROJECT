package app.domain;

import javax.persistence.*;

@Entity
public class ClassForDelete {
    @Id
    @SequenceGenerator(name = "classSeqGen", sequenceName = "classSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classSeqGen")
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "lastName", unique = false, nullable = false)
    private String lastName;

    public ClassForDelete() {
    }

    public ClassForDelete(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
