package app.dto;

public class SallaryByDayDTO {
    private String date;
    private double sallaryValue;

    public SallaryByDayDTO() {
    }

    public SallaryByDayDTO(String date, double sallaryValue) {
        this.date = date;
        this.sallaryValue = sallaryValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSallaryValue() {
        return sallaryValue;
    }

    public void setSallaryValue(double sallaryValue) {
        this.sallaryValue = sallaryValue;
    }
}
