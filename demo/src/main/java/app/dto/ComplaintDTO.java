package app.dto;

public class ComplaintDTO {
    private  Integer clientId;
    private  Integer entityId;
    private Integer ownerId;
    private String text;

    public ComplaintDTO() {
    }

    public ComplaintDTO(Integer clientId, Integer entityId, Integer ownerId, String text) {
        this.clientId = clientId;
        this.entityId = entityId;
        this.ownerId = ownerId;
        this.text = text;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
