package sfitproject.mcc.newgeofenceapp;

public class LocModel {
    private Integer Latitude;
    private Integer Longitude;
    private Integer Radius;
    private String Time;

    private LocModel(){}

    private LocModel(Integer Latitude,Integer Longitude, Integer Radius, String Time){
        this.Latitude=Latitude;
        this.Longitude=Longitude;
        this.Radius=Radius;
        this.Time=Time;
    }

    public Integer getLatitude() {
        return Latitude;
    }

    public void setLatitude(Integer latitude) {
        this.Latitude = latitude;
    }

    public Integer getLongitude() {
        return Longitude;
    }

    public void setLongitude(Integer longitude) {
        this.Longitude = longitude;
    }

    public Integer getRadius() {
        return Radius;
    }

    public void setRadius(Integer Radius) {
        this.Radius = Radius;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

}
