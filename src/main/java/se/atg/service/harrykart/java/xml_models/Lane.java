package se.atg.service.harrykart.java.xml_models;


import jakarta.xml.bind.annotation.*;

public class Lane {
    private int lane;
    private int number;

    public Lane(){}
    public Lane(int lane, int number) {
        super();
        this.lane = lane;
        this.number = number;
    }

    @XmlValue
    public int getLane() {
        return lane;
    }
    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }
    public void setLane(int lane) {
        this.lane = lane;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
