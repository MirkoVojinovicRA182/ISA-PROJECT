package app.domain;

//import app.domain.enums.UserType;

import app.dto.UserProfileDTO;

import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class ApplicationUser {

    @Id
    @SequenceGenerator(name = "userIdSeqGen", sequenceName = "userIdSeq", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeqGen")
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "lastName", unique = false, nullable = false)
    private String lastName;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "city", unique = false, nullable = false)
    private String city;

    @Column(name = "country", unique = false, nullable = false)
    private String country;

    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;


    public ApplicationUser() {
    }

    public ApplicationUser(Integer id, String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public ApplicationUser(String email, String password, String name, String lastName, String address, String city, String country, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updatePersonalInfo(UserProfileDTO dto){
        setName(dto.getName());
        setLastName(dto.getLastName());
        setAddress(dto.getAddress());
        setCity(dto.getCity());
        setCountry(dto.getCountry());
        setPhoneNumber(dto.getPhoneNumber());
    }
}
