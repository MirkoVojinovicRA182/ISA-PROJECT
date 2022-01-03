package app.dto;

import app.domain.AdventureAdditionalService;

public class AdventureAdditionalServiceDTO {
    private Integer id;
    private String name;
    private Long price;
    private Integer adventureId;

    public AdventureAdditionalServiceDTO() {
    }

    public AdventureAdditionalServiceDTO(AdventureAdditionalService additionalService){
        id = additionalService.getId();
        name = additionalService.getName();
        price = additionalService.getPrice();
        adventureId = additionalService.getAdventure().getId();
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
    }
}
