package me.chadrs.nextbus.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Prediction list tests
 */
public class PredictionListTest extends TestWithSerializer {

    @Test
    public void testPrediectionList() throws Exception {
        final String oneDirection = "<predictions agencyTitle=\"San Francisco Muni\" routeTitle=\"N-Judah\" routeTag=\"N\" stopTitle=\"Duboce Ave &amp; Church St\" stopTag=\"4447\">\n" +
                "<direction title=\"Outbound to Ocean Beach\">\n" +
                "<prediction epochTime=\"1470618495354\" seconds=\"586\" minutes=\"9\" isDeparture=\"false\" dirTag=\"N____O_F00\" vehicle=\"1441\" vehiclesInConsist=\"2\" block=\"9709\" tripTag=\"7219337\"/>\n" +
                "<prediction epochTime=\"1470618671872\" seconds=\"762\" minutes=\"12\" isDeparture=\"false\" dirTag=\"N____O_F00\" vehicle=\"1454\" vehiclesInConsist=\"2\" block=\"9703\" tripTag=\"7219340\"/>\n" +
                "<prediction epochTime=\"1470619280822\" seconds=\"1371\" minutes=\"22\" isDeparture=\"false\" affectedByLayover=\"true\" dirTag=\"N____O_F00\" vehicle=\"1448\" vehiclesInConsist=\"2\" block=\"9705\" tripTag=\"7219301\"/>\n" +
                "</direction>\n" +
                "<message text=\"We're on Twitter: @sfmta_muni\" priority=\"Low\"/>\n" +
                "<message text=\"Headed to Outside Lands? Use the MuniMobile app for easy fare payment\" priority=\"Low\"/>\n" +
                "<message text=\"Extra N service for Outside Lands today from 2pm to 11:30pm.\" priority=\"Normal\"/>\n" +
                "<message text=\"Sign up for email &amp; text service alerts at sfmta.com.\" priority=\"Low\"/>\n" +
                "<message text=\"BART closures btwn Glen Park &amp; Daly City, select wknds thru Octbr.\" priority=\"Low\"/>\n" +
                "</predictions>\n" +
                "</body>";
        assertDeserialized(oneDirection,
                PredictionList.builder()
                        .agencyTitle("San Francisco Muni")
                        .routeTitle("N-Judah")
                        .routeTag("N")
                        .stopTitle("Duboce Ave & Church St")
                        .stopTag("4447")
                        .directions(Collections.singletonList(
                                new PredictionDirection("Outbound to Ocean Beach", Arrays.asList(
                                        Prediction.builder().epochTime(1470618495354L).seconds(586).minutes(9).isDeparture(false).dirTag("N____O_F00")
                                                .vehicle("1441").vehiclesInConsist("2").block("9709").tripTag("7219337").build(),
                                        Prediction.builder().epochTime(1470618671872L).seconds(762).minutes(12).isDeparture(false).dirTag("N____O_F00")
                                                .vehicle("1454").vehiclesInConsist("2").block("9703").tripTag("7219340").build(),
                                        Prediction.builder().epochTime(1470619280822L).seconds(1371).minutes(22).isDeparture(false).affectedByLayover(true)
                                                .dirTag("N____O_F00").vehicle("1448").vehiclesInConsist("2").block("9705").tripTag("7219301").build()
                                ))
                        ))
                        .messages(Arrays.asList(
                                new PredictionMessage("We're on Twitter: @sfmta_muni", "Low"),
                                new PredictionMessage("Headed to Outside Lands? Use the MuniMobile app for easy fare payment", "Low"),
                                new PredictionMessage("Extra N service for Outside Lands today from 2pm to 11:30pm.", "Normal"),
                                new PredictionMessage("Sign up for email & text service alerts at sfmta.com.", "Low"),
                                new PredictionMessage("BART closures btwn Glen Park & Daly City, select wknds thru Octbr.", "Low")
                        ))
                        .build(),
                PredictionList.class);
    }

    @Test
    public void testPredictionList38Geary() throws Exception {
        final String threeDirections = "<predictions agencyTitle=\"San Francisco Muni\" routeTitle=\"38-Geary\" routeTag=\"38\" stopTitle=\"Geary Blvd &amp; Collins St\" stopTag=\"4290\">\n" +
                "  <direction title=\"Outbound to Balboa + 33rd Avenue\">\n" +
                "  </direction>\n" +
                "  <direction title=\"Outbound to V. A. Hospital\">\n" +
                "  </direction>\n" +
                "  <direction title=\"Outbound to Lands End - 48th Avenue\">\n" +
                "  </direction>\n" +
                "<message text=\"We&apos;re on Twitter: @sfmta_muni\" priority=\"Low\"/>\n" +
                "<message text=\"Headed to Outside Lands? Use the MuniMobile app for easy fare payment\" priority=\"Low\"/>\n" +
                "<message text=\"Sign up for email &amp; text service alerts at sfmta.com.\" priority=\"Low\"/>\n" +
                "<message text=\"BART closures btwn Glen Park &amp; Daly City, select wknds thru Octbr.\" priority=\"Low\"/>\n" +
                "</predictions>";
        assertDeserialized(threeDirections,
                PredictionList.builder()
                        .agencyTitle("San Francisco Muni")
                        .routeTitle("38-Geary")
                        .routeTag("38")
                        .stopTitle("Geary Blvd & Collins St")
                        .stopTag("4290")
                        .directions(Arrays.asList(
                                PredictionDirection.builder().title("Outbound to Balboa + 33rd Avenue").build(),
                                PredictionDirection.builder().title("Outbound to V. A. Hospital").build(),
                                PredictionDirection.builder().title("Outbound to Lands End - 48th Avenue").build()
                        ))
                        .messages(Arrays.asList(
                                new PredictionMessage("We're on Twitter: @sfmta_muni", "Low"),
                                new PredictionMessage("Headed to Outside Lands? Use the MuniMobile app for easy fare payment", "Low"),
                                new PredictionMessage("Sign up for email & text service alerts at sfmta.com.", "Low"),
                                new PredictionMessage("BART closures btwn Glen Park & Daly City, select wknds thru Octbr.", "Low")
                        ))
                        .build(),
                PredictionList.class);
    }

    @Test
    public void testNoPredictions() throws Exception {
        final String noPredictions = "<predictions agencyTitle=\"San Francisco Muni\" routeTitle=\"N-Owl\" " +
                " routeTag=\"N_OWL\" stopTitle=\"4th St &amp; Townsend St\" stopTag=\"3164\" dirTitleBecauseNoPredictions=\"Outbound to Ocean Beach\">\n" +
                "</predictions>\n" +
                "</body>";
        assertDeserialized(noPredictions, PredictionList.builder()
                .agencyTitle("San Francisco Muni")
                .routeTitle("N-Owl")
                .routeTag("N_OWL")
                .stopTitle("4th St & Townsend St")
                .stopTag("3164")
                .dirTitleBecauseNoPredictionsOrNull("Outbound to Ocean Beach")
                .build(), PredictionList.class
        );
    }

}