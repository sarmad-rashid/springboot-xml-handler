package se.atg.service.harrykart.java.xml_models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "harryKart")
public class HarryKart {
    private int numberOfLoops;
    private StartList startList;
    private PowerUps powerUps;

    public HarryKart(){}
    public HarryKart(int numberOfLoops, StartList startList, PowerUps powerUps) {
        super();
        this.numberOfLoops = numberOfLoops;
        this.startList = startList;
        this.powerUps = powerUps;
    }

    @XmlElement(name = "numberOfLoops")
    public int getNumberOfLoops() {
        return numberOfLoops;
    }

    public void setNumberOfLoops(int numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }

    @XmlElement(name = "startList")
    public StartList getStartList() {
        return startList;
    }

    public void setStartList(StartList startList) {
        this.startList = startList;
    }

    @XmlElement(name = "powerUps")
    public PowerUps getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(PowerUps powerUps) {
        this.powerUps = powerUps;
    }
}
