package se.atg.service.harrykart.java.xml_models;


import jakarta.xml.bind.annotation.XmlElement;

public class Participant {
    private int lane;
    private String name;
    private int baseSpeed;

    public Participant(){}
    public Participant(int lane, String name, int baseSpeed) {
        super();
        this.lane = lane;
        this.name = name;
        this.baseSpeed = baseSpeed;
    }

    @XmlElement(name = "lane")
    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "baseSpeed")
    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }
}
