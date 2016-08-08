package me.chadrs.nextbus.model;


import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

/**
 * <path>
 <point lat="37.765" lon="-122.45656"/>
 <point lat="37.76482" lon="-122.45771"/>
 <point lat="37.76456" lon="-122.45769"/>
 <point lat="37.76444" lon="-122.45864"/>
 <point lat="37.76437" lon="-122.4588"/>
 <point lat="37.7643" lon="-122.46082"/>
 <point lat="37.7641599" lon="-122.46403"/>
 <point lat="37.76411" lon="-122.46616"/>
 <point lat="37.76404" lon="-122.46631"/>
 <point lat="37.76217" lon="-122.46617"/>
 <point lat="37.76223" lon="-122.46669"/>
 <point lat="37.76207" lon="-122.46932"/>
 <point lat="37.76208" lon="-122.47033"/>
 <point lat="37.76191" lon="-122.47378"/>
 <point lat="37.76174" lon="-122.47692"/>
 </path>
 */
@Value.Style(passAnnotations = {ElementList.class}, of = "new",
        typeImmutable = "*", allParameters = true, visibility = Value.Style.ImplementationVisibility.PUBLIC)
@Value.Immutable
public abstract class AbstractPath {
    @ElementList(name = "point", inline = true)
    public abstract Iterable<Point> getPoints();


    @Value.Style(passAnnotations = {Attribute.class}, of = "new", typeImmutable = "*",
            allParameters = true, visibility = Value.Style.ImplementationVisibility.PUBLIC)
    @Value.Immutable
    static abstract class AbstractPoint {
        @Attribute(name = "lat")
        public abstract double getLat();
        @Attribute(name = "lon")
        public abstract double getLon();
    }
}
