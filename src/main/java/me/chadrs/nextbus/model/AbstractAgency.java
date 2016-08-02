package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Transportaion Agency for Nextbus
 *
 * <body copyright="All data copyright agencies listed below and NextBus Inc 2016.">
 <agency tag="actransit" title="AC Transit" regionTitle="California-Northern"/>
 <agency tag="jhu-apl" title="APL" regionTitle="Maryland"/>
 <agency tag="art" title="Asheville Redefines Transit" regionTitle="North Carolina"/>
 <agency tag="atlanta-sc" title="Atlanta Streetcar - Beta" regionTitle="Georgia"/>
 */
@Value.Style(passAnnotations = {Attribute.class, Root.class}, of = "new", typeImmutable = "*", allParameters = true)
@Value.Immutable
@Root(strict = false)
public abstract class AbstractAgency {
    @Attribute(name = "tag")
    public abstract String getTag();
    @Attribute(name = "title")
    public abstract String getTitle();
    @Attribute(name = "regionTitle")
    public abstract String getRegionTitle();
    //@Attribute(name = "shortTitle", required = false)
    //public abstract Optional<String> getShortTitle();

}
