package app.dto;

import app.domain.InstructorComplaint;

public class InstructorComplaintDTO {
    private String instructorName;
    private String instructorEmail;
    private String clientName;
    private String clientEmail;
    private String complaintText;

    public InstructorComplaintDTO() {
    }

    public InstructorComplaintDTO(InstructorComplaint complaint){
        instructorName = complaint.getInstructor().getName() + " " + complaint.getInstructor().getLastName();
        instructorEmail = complaint.getInstructor().getEmail();
        clientName = complaint.getClient().getName() + " " + complaint.getClient().getLastName();
        clientEmail = complaint.getClient().getEmail();
        complaintText = complaint.getText();
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
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
}
