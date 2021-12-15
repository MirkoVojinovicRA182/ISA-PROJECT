package app.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "test")
public class DatabaseTestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "someStringTest", unique = true, nullable = false)
    private String someString;


    public DatabaseTestClass() {
    }

    public DatabaseTestClass(Integer id, String someString) {
        this.id = id;
        this.someString = someString;
    }

    public DatabaseTestClass(String someString) {
        this.someString = someString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }
}
