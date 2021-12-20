package app.dto;

public class OrganDTO {
    private String name;
    private int bodyId;

    public OrganDTO() {
    }

    public OrganDTO(String name, int bodyId) {
        this.name = name;
        this.bodyId = bodyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBodyId() {
        return bodyId;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }
}
