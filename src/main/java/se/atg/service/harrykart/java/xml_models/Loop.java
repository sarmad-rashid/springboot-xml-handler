package se.atg.service.harrykart.java.xml_models;

import jakarta.xml.bind.annotation.*;
import java.util.List;

public class Loop {
    private int number;
    private List<Lane> lanes;

    public Loop(){}
    public Loop(int number, List<Lane> lanes) {
        super();
        this.number = number;
        this.lanes = lanes;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }
    @XmlElement(name = "lane")
    public List<Lane> getLanes() {
        return lanes;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setLanes(List<Lane> lanes) {
        this.lanes = lanes;
    }
}
