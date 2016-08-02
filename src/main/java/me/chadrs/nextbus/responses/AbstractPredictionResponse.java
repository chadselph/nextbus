package me.chadrs.nextbus.responses;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import me.chadrs.nextbus.model.PredictionList;


/**
 * Created by chad on 7/26/16.
 */
@Root(name = "body")
@Value.Style(passAnnotations = {Attribute.class, Element.class, ElementList.class, Root.class},
        of = "new", typeImmutable = "*")
@Value.Immutable
public abstract class AbstractPredictionResponse {

    @Value.Parameter @Element(name = "predictions")
    public abstract PredictionList getPredictions();
    @Value.Parameter @Attribute(name = "copyright")
    public abstract String getCopyright();

}
