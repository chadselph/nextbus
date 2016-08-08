package me.chadrs.nextbus.responses;

import me.chadrs.nextbus.model.Vehicle;
import org.immutables.value.Value;
import org.simpleframework.xml.*;

/**
 * Response for NextBus Vehicle locations API
 */
@Root(name = "body", strict = false)
@Value.Style(passAnnotations = {Attribute.class, Element.class, ElementList.class, Root.class},
        allParameters = true, of = "new", typeImmutable = "*", visibility = Value.Style.ImplementationVisibility.PUBLIC)
@Value.Immutable
abstract class AbstractVehicleLocationsResponse {

    @Element(name = "lastTime") @Value.Auxiliary
    protected abstract LastTime getLastTime();

    @Attribute(name = "copyright")
    public abstract String getCopyright();

    @ElementList(name = "vehicle", inline = true, required = false, empty = false)
    public abstract Iterable<Vehicle> getVehicles();


    @Value.Style(passAnnotations = {Attribute.class}, of = "new", typeImmutable = "*",
            visibility = Value.Style.ImplementationVisibility.PUBLIC)
    @Value.Immutable
    static abstract class AbstractLastTime {
        @Attribute(name = "time") @Value.Parameter
        public abstract long getTime();
    }
}
