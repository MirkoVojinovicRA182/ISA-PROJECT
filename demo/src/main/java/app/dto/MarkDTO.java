package app.dto;

public class MarkDTO {
    private Integer markId;
    private Integer mark;
    private Integer userId;
    private Integer cottageId;

    public MarkDTO() {
    }

    public MarkDTO(Integer markId, Integer mark, Integer userId, Integer cottageId) {
        this.markId = markId;
        this.mark = mark;
        this.userId = userId;
        this.cottageId = cottageId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCottageId() {
        return cottageId;
    }

    public void setCottageId(Integer cottageId) {
        this.cottageId = cottageId;
    }
}
