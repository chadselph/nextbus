package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Not a full stop object, just a reference to one
 */
@Root(name = "stop")
@Value.Immutable
abstract class AbstractStopRef {

    @Attribute(name = "tag")
    public abstract String getTag();

}
