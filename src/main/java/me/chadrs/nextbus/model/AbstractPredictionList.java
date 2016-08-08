package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Optional;

/**
 <body>
 <predictions agencyTitle="San Francisco Muni, CA" routeTag="N"
 routeCode="1" routeTitle="N - Judah" stopTitle="Civic Center Station
 Outbound" stopTag="4447">
 */
@Root(name = "prediction", strict = false)
@Value.Immutable
abstract class AbstractPredictionList {

    @Attribute(name = "agencyTitle")
    public abstract String getAgencyTitle();

    @Attribute(name = "routeTag")
    public abstract String getRouteTag();

    @Attribute(name = "routeCode", required = false) @Nullable @Value.Auxiliary
    protected abstract String getRouteCodeOrNull();

    @Attribute(name = "routeTitle")
    public abstract String getRouteTitle();

    @Attribute(name = "stopTitle")
    public abstract String getStopTitle();

    @Attribute(name = "stopTag")
    public abstract String getStopTag();

    @Attribute(name = "dirTitleBecauseNoPredictions", required = false) @Nullable @Value.Auxiliary
    protected abstract String getDirTitleBecauseNoPredictionsOrNull();

    @ElementList(name = "direction", inline = true, empty = false, required = false)
    @Value.Default
    public Iterable<PredictionDirection> getDirections() {
        return Collections.emptyList();
    }

    @ElementList(name = "message", inline = true, empty = false, required = false)
    @Value.Default
    public Iterable<PredictionMessage> getMessages() {
        return Collections.emptyList();
    }

    @Value.Derived
    public Optional<String> getRouteCode() {
        return Optional.ofNullable(getRouteCodeOrNull());
    }

    @Value.Derived
    public Optional<String> getDirTitleBecauseNoPredictions() {
        return Optional.ofNullable(getDirTitleBecauseNoPredictionsOrNull());
    }


}
