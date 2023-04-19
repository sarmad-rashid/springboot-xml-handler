package se.atg.service.harrykart.java.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.model.HarryKartModel;
import se.atg.service.harrykart.java.model.RankingModel;
import se.atg.service.harrykart.java.xml_models.HarryKart;
import se.atg.service.harrykart.java.xml_models.Lane;
import se.atg.service.harrykart.java.xml_models.Loop;
import se.atg.service.harrykart.java.xml_models.Participant;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class HarryKartService {

    public List<RankingModel> getWinnersList(HarryKart harryKart){

        //get information from input model
        int numberOfLoops = harryKart.getNumberOfLoops();
        List<Participant> participants = harryKart.getStartList().getParticipantList();
        List<Loop> loops = harryKart.getPowerUps().getLoopList();

        //add all participants to harryKartModelList based on number of participants
        List<HarryKartModel> modelList = new ArrayList<HarryKartModel>();

        //add name, lane, speed from input to model
        for (Participant participant:participants) {
            modelList.add(new HarryKartModel(
                    participant.getLane(),
                    participant.getName(),
                    participant.getBaseSpeed(),
                    participant.getBaseSpeed()*1000));
        }

        for (Loop loop:loops) {
            for (Lane lane:loop.getLanes()) {

                //get model basespeed
                int tempBasespeed = modelList.get(lane.getNumber() - 1).basespeed;
                //set new basespeed
                modelList.get(lane.getNumber() - 1).basespeed += lane.getLane();

                //calculate finishTime
                int tempFinishTime = (tempBasespeed + lane.getLane()) * 1000;
                //set model finishTime
                modelList.get(lane.getNumber() - 1).finishTime += tempFinishTime;
            }
        }

        Comparator<HarryKartModel> sorter = Comparator.comparingInt(a -> a.finishTime);
        //List.sort(modelList, sorter);
        modelList.sort(sorter);

        List<RankingModel> rankings = new ArrayList<>();

        //adding relevant information to output model
        int counter = 1;
        for (HarryKartModel model:modelList) {
            rankings.add(new RankingModel(counter,model.name));
            counter++;
            if (counter == 4){
                break;
            }
        }

        return rankings;
    }
    public List<RankingModel> getWinnersListLocalTest(){
        HarryKart harryKart;
        try {
            //parsing xml file
            File file = new File("src\\main\\resources\\input_0.xml");
            //File file2 = new File("src\\main\\resources\\input.xsd");
            JAXBContext jaxbContext = JAXBContext.newInstance(HarryKart.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//			Schema schema = schemaFactory.newSchema(file2);
//			unmarshaller.setSchema(schema);
            harryKart = (HarryKart) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } //catch (SAXException e) {
//			throw new RuntimeException(e);
//		}

        //get information from input model
        int numberOfLoops = harryKart.getNumberOfLoops();
        List<Participant> participants = harryKart.getStartList().getParticipantList();
        List<Loop> loops = harryKart.getPowerUps().getLoopList();

        //add all participants to harryKartModelList based on number of participants
        List<HarryKartModel> modelList = new ArrayList<>();

        //add name, lane, speed from input to model
        for (Participant participant:participants) {
            modelList.add(new HarryKartModel(
                    participant.getLane(),
                    participant.getName(),
                    participant.getBaseSpeed(),
                    participant.getBaseSpeed()*1000));
        }

        for (Loop loop:loops) {
            for (Lane lane:loop.getLanes()) {

                //get model basespeed
                int tempBasespeed = modelList.get(lane.getNumber() - 1).basespeed;
                //set new basespeed
                modelList.get(lane.getNumber() - 1).basespeed += lane.getLane();

                //calculate finishTime
                int tempFinishTime = (tempBasespeed + lane.getLane()) * 1000;
                //set model finishTime
                modelList.get(lane.getNumber() - 1).finishTime += tempFinishTime;
            }
        }

        Comparator<HarryKartModel> sorter = (a, b) -> Integer.compare(b.finishTime, a.finishTime);
        Collections.sort(modelList, sorter);

        List<RankingModel> rankings = new ArrayList<>();

        //adding relevant information to output model
        int counter = 1;
        for (HarryKartModel model:modelList) {
            rankings.add(new RankingModel(counter,model.name));
            counter++;
            if (counter == 4){
                break;
            }
        }

        return rankings;
    }
}
