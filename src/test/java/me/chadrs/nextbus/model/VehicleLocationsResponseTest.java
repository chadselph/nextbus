package me.chadrs.nextbus.model;

import me.chadrs.nextbus.responses.LastTime;
import me.chadrs.nextbus.responses.VehicleLocationsResponse;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chad on 8/7/16.
 */
public class VehicleLocationsResponseTest extends TestWithSerializer {

    final String locations = "\n" +
            "<body copyright=\"All data copyright San Francisco Muni 2016.\">\n" +
            "<vehicle id=\"1538\" routeTag=\"N\" lat=\"37.76018\" lon=\"-122.50932\" secsSinceReport=\"30\" predictable=\"false\" heading=\"-4\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1411\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.7912899\" lon=\"-122.39053\" secsSinceReport=\"33\" predictable=\"true\" heading=\"145\" speedKmHr=\"0\" leadingVehicleId=\"1536\"/>\n" +
            "<vehicle id=\"1454\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.7641599\" lon=\"-122.46379\" secsSinceReport=\"33\" predictable=\"true\" heading=\"218\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1494\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76215\" lon=\"-122.46703\" secsSinceReport=\"3\" predictable=\"true\" heading=\"267\" speedKmHr=\"9\"/>\n" +
            "<vehicle id=\"1461\" routeTag=\"N\" lat=\"37.76038\" lon=\"-122.50687\" secsSinceReport=\"87\" predictable=\"false\" heading=\"-4\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1478\" routeTag=\"N\" lat=\"37.77596\" lon=\"-122.39349\" secsSinceReport=\"37\" predictable=\"true\" heading=\"219\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1547\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.78369\" lon=\"-122.4086\" secsSinceReport=\"2\" predictable=\"true\" heading=\"225\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1537\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.76035\" lon=\"-122.50791\" secsSinceReport=\"13\" predictable=\"true\" heading=\"218\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1517\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.76015\" lon=\"-122.5093\" secsSinceReport=\"25\" predictable=\"true\" heading=\"218\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1416\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.79257\" lon=\"-122.39711\" secsSinceReport=\"9\" predictable=\"true\" heading=\"44\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1422\" routeTag=\"N\" dirTag=\"N____I_E30\" lat=\"37.79333\" lon=\"-122.39615\" secsSinceReport=\"2\" predictable=\"true\" heading=\"46\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1476\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76111\" lon=\"-122.49012\" secsSinceReport=\"30\" predictable=\"true\" heading=\"266\" speedKmHr=\"12\"/>\n" +
            "<vehicle id=\"1437\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76413\" lon=\"-122.46375\" secsSinceReport=\"3\" predictable=\"true\" heading=\"267\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1451\" routeTag=\"N\" lat=\"37.7604\" lon=\"-122.5064\" secsSinceReport=\"14\" predictable=\"false\" heading=\"-4\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1527\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.77461\" lon=\"-122.39613\" secsSinceReport=\"48\" predictable=\"true\" heading=\"46\" speedKmHr=\"18\"/>\n" +
            "<vehicle id=\"1442\" routeTag=\"N\" dirTag=\"N____I_E30\" lat=\"37.79333\" lon=\"-122.39615\" secsSinceReport=\"2\" predictable=\"true\" heading=\"46\" speedKmHr=\"0\" leadingVehicleId=\"1422\"/>\n" +
            "<vehicle id=\"1549\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.76113\" lon=\"-122.48943\" secsSinceReport=\"52\" predictable=\"true\" heading=\"87\" speedKmHr=\"5\"/>\n" +
            "<vehicle id=\"1492\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76115\" lon=\"-122.48941\" secsSinceReport=\"34\" predictable=\"true\" heading=\"266\" speedKmHr=\"12\"/>\n" +
            "<vehicle id=\"1408\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.7879\" lon=\"-122.38789\" secsSinceReport=\"3\" predictable=\"true\" heading=\"173\" speedKmHr=\"35\"/>\n" +
            "<vehicle id=\"1545\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.76036\" lon=\"-122.50765\" secsSinceReport=\"71\" predictable=\"true\" heading=\"218\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1448\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76101\" lon=\"-122.49242\" secsSinceReport=\"46\" predictable=\"true\" heading=\"267\" speedKmHr=\"0\" leadingVehicleId=\"1450\"/>\n" +
            "<vehicle id=\"1536\" routeTag=\"N\" dirTag=\"N____I_F00\" lat=\"37.7912899\" lon=\"-122.39053\" secsSinceReport=\"33\" predictable=\"true\" heading=\"145\" speedKmHr=\"0\"/>\n" +
            "<vehicle id=\"1482\" routeTag=\"N\" lat=\"37.7749\" lon=\"-122.39579\" secsSinceReport=\"30\" predictable=\"true\" heading=\"45\" speedKmHr=\"5\" leadingVehicleId=\"1527\"/>\n" +
            "<vehicle id=\"1412\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.76218\" lon=\"-122.46636\" secsSinceReport=\"10\" predictable=\"true\" heading=\"278\" speedKmHr=\"0\" leadingVehicleId=\"1494\"/>\n" +
            "<vehicle id=\"1543\" routeTag=\"N\" dirTag=\"N____O_F00\" lat=\"37.78369\" lon=\"-122.4086\" secsSinceReport=\"2\" predictable=\"true\" heading=\"225\" speedKmHr=\"0\" leadingVehicleId=\"1547\"/>\n" +
            "<lastTime time=\"1470627432829\"/>\n" +
            "</body>\n";

    @Test
    public void testLocations() throws Exception {
        assertDeserialized(locations, VehicleLocationsResponse.builder()
                .vehicles(Arrays.asList(
                        Vehicle.builder().id("1538").routeTag("N").lat(37.76018).lon(-122.50932).secsSinceReport(30).predictable(false).heading(-4).speedKmHr(0).build(),
                        Vehicle.builder().id("1411").routeTag("N").dirTagOrNull("N____I_F00").lat(37.7912899).lon(-122.39053).secsSinceReport(33).predictable(true).heading(145).speedKmHr(0).leadingVehicleIdOrNull("1536").build(),
                        Vehicle.builder().id("1454").routeTag("N").dirTagOrNull("N____I_F00").lat(37.7641599).lon(-122.46379).secsSinceReport(33).predictable(true).heading(218).speedKmHr(0).build(),
                        Vehicle.builder().id("1494").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76215).lon(-122.46703).secsSinceReport(3).predictable(true).heading(267).speedKmHr(9).build(),
                        Vehicle.builder().id("1461").routeTag("N").lat(37.76038).lon(-122.50687).secsSinceReport(87).predictable(false).heading(-4).speedKmHr(0).build(),
                        Vehicle.builder().id("1478").routeTag("N").lat(37.77596).lon(-122.39349).secsSinceReport(37).predictable(true).heading(219).speedKmHr(0).build(),
                        Vehicle.builder().id("1547").routeTag("N").dirTagOrNull("N____O_F00").lat(37.78369).lon(-122.4086).secsSinceReport(2).predictable(true).heading(225).speedKmHr(0).build(),
                        Vehicle.builder().id("1537").routeTag("N").dirTagOrNull("N____I_F00").lat(37.76035).lon(-122.50791).secsSinceReport(13).predictable(true).heading(218).speedKmHr(0).build(),
                        Vehicle.builder().id("1517").routeTag("N").dirTagOrNull("N____I_F00").lat(37.76015).lon(-122.5093).secsSinceReport(25).predictable(true).heading(218).speedKmHr(0).build(),
                        Vehicle.builder().id("1416").routeTag("N").dirTagOrNull("N____I_F00").lat(37.79257).lon(-122.39711).secsSinceReport(9).predictable(true).heading(44).speedKmHr(0).build(),
                        Vehicle.builder().id("1422").routeTag("N").dirTagOrNull("N____I_E30").lat(37.79333).lon(-122.39615).secsSinceReport(2).predictable(true).heading(46).speedKmHr(0).build(),
                        Vehicle.builder().id("1476").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76111).lon(-122.49012).secsSinceReport(30).predictable(true).heading(266).speedKmHr(12).build(),
                        Vehicle.builder().id("1437").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76413).lon(-122.46375).secsSinceReport(3).predictable(true).heading(267).speedKmHr(0).build(),
                        Vehicle.builder().id("1451").routeTag("N").lat(37.7604).lon(-122.5064).secsSinceReport(14).predictable(false).heading(-4).speedKmHr(0).build(),
                        Vehicle.builder().id("1527").routeTag("N").dirTagOrNull("N____I_F00").lat(37.77461).lon(-122.39613).secsSinceReport(48).predictable(true).heading(46).speedKmHr(18).build(),
                        Vehicle.builder().id("1442").routeTag("N").dirTagOrNull("N____I_E30").lat(37.79333).lon(-122.39615).secsSinceReport(2).predictable(true).heading(46).speedKmHr(0).leadingVehicleIdOrNull("1422").build(),
                        Vehicle.builder().id("1549").routeTag("N").dirTagOrNull("N____I_F00").lat(37.76113).lon(-122.48943).secsSinceReport(52).predictable(true).heading(87).speedKmHr(5).build(),
                        Vehicle.builder().id("1492").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76115).lon(-122.48941).secsSinceReport(34).predictable(true).heading(266).speedKmHr(12).build(),
                        Vehicle.builder().id("1408").routeTag("N").dirTagOrNull("N____O_F00").lat(37.7879).lon(-122.38789).secsSinceReport(3).predictable(true).heading(173).speedKmHr(35).build(),
                        Vehicle.builder().id("1545").routeTag("N").dirTagOrNull("N____I_F00").lat(37.76036).lon(-122.50765).secsSinceReport(71).predictable(true).heading(218).speedKmHr(0).build(),
                        Vehicle.builder().id("1448").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76101).lon(-122.49242).secsSinceReport(46).predictable(true).heading(267).speedKmHr(0).leadingVehicleIdOrNull("1450").build(),
                        Vehicle.builder().id("1536").routeTag("N").dirTagOrNull("N____I_F00").lat(37.7912899).lon(-122.39053).secsSinceReport(33).predictable(true).heading(145).speedKmHr(0).build(),
                        Vehicle.builder().id("1482").routeTag("N").lat(37.7749).lon(-122.39579).secsSinceReport(30).predictable(true).heading(45).speedKmHr(5).leadingVehicleIdOrNull("1527").build(),
                        Vehicle.builder().id("1412").routeTag("N").dirTagOrNull("N____O_F00").lat(37.76218).lon(-122.46636).secsSinceReport(10).predictable(true).heading(278).speedKmHr(0).leadingVehicleIdOrNull("1494").build(),
                        Vehicle.builder().id("1543").routeTag("N").dirTagOrNull("N____O_F00").lat(37.78369).lon(-122.4086).secsSinceReport(2).predictable(true).heading(225).speedKmHr(0).leadingVehicleIdOrNull("1547").build()
                ))
                .copyright("All data copyright San Francisco Muni 2016.")
                .lastTime(new LastTime(1470627432829L))
                .build(), VehicleLocationsResponse.class);
    }

}