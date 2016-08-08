package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 <body>
 <predictions agencyTitle="San Francisco Muni, CA" routeTag="N"
 routeCode="1" routeTitle="N - Judah" stopTitle="Civic Center Station
 Outbound" stopTag="4447">
 */
@Root(name = "prediction", strict = false)
@Value.Immutable
@Value.Style(passAnnotations = {Attribute.class, Root.class, ElementList.class}, of = "new", typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC, optionalAcceptNullable = true)
abstract class AbstractPredictionList {

    @Value.Parameter @Attribute(name = "agencyTitle")
    public abstract String getAgencyTitle();

    @Value.Parameter @Attribute(name = "routeTag")
    public abstract String getRouteTag();

    @Value.Parameter @Attribute(name = "routeCode", required = false) @Nullable
    protected abstract String getRouteCodeOrNull();

    @Value.Parameter @Attribute(name = "routeTitle")
    public abstract String getRouteTitle();

    @Value.Parameter @Attribute(name = "stopTitle")
    public abstract String getStopTitle();

    @Value.Parameter @Attribute(name = "stopTag")
    public abstract String getStopTag();

    @Value.Parameter @ElementList(name = "direction", inline = true, empty = false, required = false)
    public abstract Iterable<Direction> getDirections();

    @Value.Auxiliary
    public Optional<String> getRouteCode() {
        return Optional.ofNullable(getRouteCodeOrNull());
    }


}
