package home.petproject.studentorder.domain;

public class CountryArea {
    private String areaID;
    private String areaName;

    public CountryArea() {
    }

    public CountryArea(String areaID, String areaName) {
        this.areaID = areaID;
        this.areaName = areaName;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "CountryArea{" +
                "areaID='" + areaID + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
