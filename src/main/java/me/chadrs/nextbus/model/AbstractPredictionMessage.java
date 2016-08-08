package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * <message text="Headed to Outside Lands? Use the MuniMobile app for easy fare payment" priority="Low"/>
 */
@Value.Immutable
@Root(name = "message")
public abstract class AbstractPredictionMessage {
    @Attribute(name = "text")
    public abstract String getText();
    @Attribute(name = "priority")
    public abstract String getPriority();
}
