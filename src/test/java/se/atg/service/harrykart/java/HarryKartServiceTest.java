package se.atg.service.harrykart.java;

import org.junit.jupiter.api.Test;
import se.atg.service.harrykart.java.model.RankingModel;
import se.atg.service.harrykart.java.service.HarryKartService;
import se.atg.service.harrykart.java.xml_models.HarryKart;

import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;


public class HarryKartServiceTest {

    HarryKartService harryKartService = new HarryKartService();
    @Test
    void shouldPass1() {
        //Arrange

        //Act
        var result = harryKartService.getWinnersListLocalTest();

        //Assert
        assertThat(result, notNullValue());
    }
    @Test
    void shouldPass2() {
        //Arrange

        //Act
        List<RankingModel> result = harryKartService.getWinnersListLocalTest();

        //Assert
        assertThat(result, everyItem(notNullValue()));
    }
    @Test
    void shouldPass3() {
        //Arrange

        //Act
        List<RankingModel> result = harryKartService.getWinnersListLocalTest();

        //Assert
        assertThat(result, hasSize(3));
    }
    @Test
    void shouldFail() {
        //Arrange

        //Act
        List<RankingModel> result = harryKartService.getWinnersListLocalTest();

        //Assert
        assertThat(result, empty());
    }
}
