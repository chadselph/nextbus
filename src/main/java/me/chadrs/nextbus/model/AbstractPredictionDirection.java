package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Collections;

/**
 * Created by chad on 8/7/16.
 */
@Root(name = "direction")
@Value.Immutable
abstract class AbstractPredictionDirection {

    @Attribute(name = "title")
    public abstract String getTitle();

    @ElementList(name = "prediction", inline = true, required = false, empty = false)
    @Value.Default
    public Iterable<Prediction> getPredictions() {
        return Collections.emptyList();
    }
}
