package app.dto;

public class EjectRegistrationRequestDTO {
    private Integer requestId;
    private String clientEmail;
    private String ejectExplanation;

    public EjectRegistrationRequestDTO() {
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getEjectExplanation() {
        return ejectExplanation;
    }

    public void setEjectExplanation(String ejectExplanation) {
        this.ejectExplanation = ejectExplanation;
    }
}
