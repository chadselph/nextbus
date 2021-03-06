package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import me.chadrs.nextbus.model.Stop;
import me.chadrs.nextbus.model.Direction;
import me.chadrs.nextbus.model.Path;

import java.util.List;

/**
 <route tag="N" title="N-Judah" color="003399" oppositeColor="ffffff" latMin="37.7602999" latMax="37.7932299" lonMin="-122.50868" lonMax="-122.38798">
 */

@Root(strict = false, name = "route")
@Value.Style(passAnnotations = {ElementList.class, Root.class}, of = "new", typeImmutable = "*", allParameters = true)
@Value.Immutable
public abstract class AbstractRouteConfig {

    @ElementList(name = "stop", inline = true)
    public abstract Iterable<Stop> getStops();
    @ElementList(name = "direction", inline = true)
    public abstract Iterable<Direction> getDirections();
    @ElementList(name = "path", inline = true)
    public abstract Iterable<Path> getPaths();

}
