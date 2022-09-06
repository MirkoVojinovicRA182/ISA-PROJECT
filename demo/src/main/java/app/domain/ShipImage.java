package app.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ShipImage {

	@Id
    @SequenceGenerator(name = "shipImgIdSeqGen", sequenceName = "shipImgIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipIdSeqGen")
    private Integer id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
	@JsonBackReference(value = "cottage_images")
    private Ship ship;
    
    public ShipImage() {}
    
    public ShipImage(String url, Ship ship) {
        this.url = url;
        this.ship = ship;
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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
}
