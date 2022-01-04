package app.dto;

import app.domain.Image;

public class ImageDTO {
    private Integer id;
    private String url;
    private Integer adventureId;

    public ImageDTO() {
    }

    public ImageDTO(Image image){
        id = image.getId();
        url = image.getUrl();
        adventureId = image.getAdventure().getId();
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

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
    }
}
