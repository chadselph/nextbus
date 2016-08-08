package me.chadrs.nextbus.model;


import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

/**
 * An individual stop on a route direction.
 <stop tag="3909" title="Carl St & Cole St" lat="37.7658599" lon="-122.4497999" stopId="13909"/>
 */
@Value.Style(passAnnotations = {ElementList.class, Attribute.class}, of = "new",
        typeImmutable = "*", allParameters = true, visibility = Value.Style.ImplementationVisibility.PUBLIC)
@Value.Immutable
abstract class AbstractStop {
    @Attribute(name = "tag")
    public abstract String getTag();
    @Attribute(name = "title")
    public abstract String getTitle();
    @Attribute(name = "lat")
    public abstract double getLat();
    @Attribute(name = "lon")
    public abstract double getLon();
    @Attribute(name = "stopId")
    public abstract String getStopId();

}
