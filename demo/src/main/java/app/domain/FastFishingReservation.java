package app.domain;

import java.time.LocalDateTime;
import java.util.List;

public class FastFishingReservation {
    private Long id;
    private LocalDateTime startTime;
    private String place;
    private double duration;
    private int maxCountOfParticipants;
    private List<String> additionalServices;
    private double price;

    public FastFishingReservation() {
    }

    public FastFishingReservation(Long id, LocalDateTime startTime, String place, double duration, int maxCountOfParticipants, List<String> additionalServices, double price) {
        this.id = id;
        this.startTime = startTime;
        this.place = place;
        this.duration = duration;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.additionalServices = additionalServices;
        this.price = price;
    }

    public FastFishingReservation(LocalDateTime startTime, String place, double duration, int maxCountOfParticipants, List<String> additionalServices, double price) {
        this.startTime = startTime;
        this.place = place;
        this.duration = duration;
        this.maxCountOfParticipants = maxCountOfParticipants;
        this.additionalServices = additionalServices;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getMaxCountOfParticipants() {
        return maxCountOfParticipants;
    }

    public void setMaxCountOfParticipants(int maxCountOfParticipants) {
        this.maxCountOfParticipants = maxCountOfParticipants;
    }

    public List<String> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<String> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
