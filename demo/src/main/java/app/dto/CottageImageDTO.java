package app.dto;

public class CottageImageDTO {
    private Integer cottageImageid;
    private String url;
    private String base64;
    private Integer cottageId;

    public CottageImageDTO() {
    }

    public CottageImageDTO(Integer cottageImageid, String url, String base64, Integer cottageId) {
        this.cottageImageid = cottageImageid;
        this.url = url;
        this.base64 = base64;
        this.cottageId = cottageId;
    }

    public Integer getCottageImageid() {
        return cottageImageid;
    }

    public void setCottageImageid(Integer cottageImageid) {
        this.cottageImageid = cottageImageid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Integer getCottageId() {
        return cottageId;
    }

    public void setCottageId(Integer cottageId) {
        this.cottageId = cottageId;
    }
}
