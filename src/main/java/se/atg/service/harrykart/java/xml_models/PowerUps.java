package se.atg.service.harrykart.java.xml_models;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class PowerUps {
    private List<Loop> loopList;

    public PowerUps(){}
    public PowerUps(List<Loop> loopList) {
        super();
        this.loopList = loopList;
    }

    @XmlElement(name = "loop")
    public List<Loop> getLoopList() {
        return loopList;
    }
    public void setLoopList(List<Loop> loopList) {
        this.loopList = loopList;
    }
}
