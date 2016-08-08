package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * sample
 * <vehicle id="1411" routeTag="N" dirTag="N____I_F00" lat="37.7912899" lon="-122.39053" secsSinceReport="33" predictable="true" heading="145" speedKmHr="0" leadingVehicleId="1536"/>
 */
@Root(name = "vehicle")
@Value.Immutable
public abstract class AbstractVehicle {

    @Attribute(name = "id")
    public abstract String getId();
    @Attribute(name = "routeTag")
    public abstract String getRouteTag();
    @Attribute(name = "dirTag", required = false) @Nullable @Value.Auxiliary
    public abstract String getDirTagOrNull();
    @Attribute(name = "lat")
    public abstract double getLat();
    @Attribute(name = "lon")
    public abstract double getLon();
    @Attribute(name = "secsSinceReport")
    public abstract int getSecsSinceReport();
    @Attribute(name = "predictable")
    public abstract boolean getPredictable();
    @Attribute(name = "heading")
    public abstract int getHeading();
    @Attribute(name = "speedKmHr")
    public abstract int getSpeedKmHr();
    @Attribute(name = "leadingVehicleId", required = false) @Nullable @Value.Auxiliary
    public abstract String getLeadingVehicleIdOrNull();


    @Value.Derived
    public Optional<String> getLeadingVehicleId() {
        return Optional.ofNullable(getLeadingVehicleIdOrNull());
    }

    @Value.Derived
    public Optional<String> getDirTag() {
        return Optional.ofNullable(getDirTagOrNull());
    }
}
