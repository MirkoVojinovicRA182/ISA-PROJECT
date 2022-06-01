package app.dto;

public class RoomDTO {

    private Integer roomId;
    private Integer roomNumber;
    private Integer bedsNumber;
    private boolean bathroom;
    private boolean clime;
    private Integer cottageId;

    public RoomDTO() {
    }

    public RoomDTO(Integer roomId, Integer roomNumber, Integer bedsNumber, boolean bathroom, boolean clime, Integer cottageId) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.bedsNumber = bedsNumber;
        this.bathroom = bathroom;
        this.clime = clime;
        this.cottageId = cottageId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(Integer bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public boolean isClime() {
        return clime;
    }

    public void setClime(boolean clime) {
        this.clime = clime;
    }

    public Integer getCottageId() {
        return cottageId;
    }

    public void setCottageId(Integer cottageId) {
        this.cottageId = cottageId;
    }
}
