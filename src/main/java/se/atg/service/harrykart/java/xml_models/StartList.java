package se.atg.service.harrykart.java.xml_models;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class StartList {
    private List<Participant> participantList;

    public StartList(){}
    public StartList(List<Participant> participantList) {
        super();
        this.participantList = participantList;
    }

    @XmlElement(name = "participant")
    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }
}
