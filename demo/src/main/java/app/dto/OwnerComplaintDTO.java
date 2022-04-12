package app.dto;

public class OwnerComplaintDTO {
    private String ownerName;
    private String ownerEmail;
    private String ownerEntityName;
    private String clientName;
    private String clientEmail;
    private String complaintText;

    public OwnerComplaintDTO() {
    }

    public OwnerComplaintDTO(String ownerName,
                             String ownerEmail,
                             String ownerEntityName,
                             String clientName,
                             String clientEmail,
                             String complaintText){
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerEntityName = ownerEntityName;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.complaintText = complaintText;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getOwnerEntityName() {
        return ownerEntityName;
    }

    public void setOwnerEntityName(String ownerEntityName) {
        this.ownerEntityName = ownerEntityName;
    }
}
