package se.atg.service.harrykart.java.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.atg.service.harrykart.java.model.RankingModel;
import se.atg.service.harrykart.java.service.HarryKartService;
import se.atg.service.harrykart.java.xml_models.HarryKart;

import java.util.List;

@RestController
@RequestMapping("/java/api")
public class HarryKartController {
    private final HarryKartService harryKartService;

    @Autowired
    public HarryKartController(HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WinnerRankings playHarryKart(@RequestBody HarryKart harryKart) {

        List<RankingModel> winnersList = harryKartService.getWinnersList(harryKart);
        WinnerRankings rankings = new WinnerRankings(winnersList);

        return rankings;
    }
    record WinnerRankings(List<RankingModel> ranking){}
}
