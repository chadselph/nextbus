package me.chadrs.nextbus.model;

import org.junit.Test;

/**
 * Test Agency
 <agency tag="jhu-apl" title="APL" regionTitle="Maryland"/>
 <agency tag="art" title="Asheville Redefines Transit" regionTitle="North Carolina"/>
 <agency tag="atlanta-sc" title="Atlanta Streetcar - Beta" regionTitle="Georgia"/>
 */
public class AgencyTest extends TestWithSerializer {

    @Test
    public void testAgency() throws Exception {
        assertDeserialized(
                "<agency tag=\"atlanta-sc\" title=\"Atlanta Streetcar - Beta\" regionTitle=\"Georgia\"/>",
                Agency.builder()
                        .regionTitle("Georgia")
                        .title("Atlanta Streetcar - Beta")
                        .tag("atlanta-sc")
                        .build(),
                Agency.class);

    }

    @Test
    public void testAgencyWithOptionalShortTitle() throws Exception {
        final String test = "<agency tag=\"nova-se\" title=\"Nova Southeastern University\" " +
                "shortTitle=\"Nova\" regionTitle=\"Florida\"/>\n";
        assertDeserialized(test,
                Agency.builder()
                        .tag("nova-se")
                        .title("Nova Southeastern University")
                        .regionTitle("Florida")
                        .shortTitleOrNull("Nova")
                        .build(),
                Agency.class);
    }

}