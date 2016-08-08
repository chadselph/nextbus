package me.chadrs.nextbus.model;

import org.junit.Test;

/**
 * can we read a prediction?!
 */
public class PredictionTest extends TestWithSerializer {

    @Test
    public void testPrediction() throws Exception {
        final String t = "<prediction epochTime=\"1470618799755\" " +
                "seconds=\"355\" minutes=\"5\" isDeparture=\"false\" " +
                "dirTag=\"N____O_F00\" vehicle=\"438\" vehiclesInConsist=\"2\" " +
                "block=\"9704\" tripTag=\"7219300\" />";
        assertDeserialized(t, Prediction.builder()
                        .epochTime(1470618799755L)
                        .seconds(355)
                        .minutes(5)
                        .isDeparture(false)
                        .dirTag("N____O_F00")
                        .vehicle("438")
                        .vehiclesInConsist("2")
                        .block("9704")
                        .tripTag("7219300")
                        .build(),
                Prediction.class);
    }


}