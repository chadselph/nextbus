package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

/**
 * A direction of a route, such as "inbound" or "outbound"
 <direction tag="N____I_F00" title="Inbound to Caltrain/Ball Park" name="Inbound" useForUI="true">
     <stop tag="5223"/>
     <stop tag="5216"/>
 </direction>
 */

@Value.Immutable
abstract class AbstractDirection {
    @Attribute(name = "tag")
    public abstract String getTag();
    @Attribute(name = "title")
    public abstract String getTitle();
    @Attribute(name = "name")
    public abstract String getName();
    @Attribute(name = "useForUI")
    public abstract boolean getUseForUI();
    @ElementList(name = "stop", inline = true)
    public abstract Iterable<StopRef> getStops();

}
