package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Route for a transportation agency
 */
@Value.Immutable
@Root(name = "route")
public abstract class AbstractRoute {
    @Attribute(name = "tag")
    public abstract String getTag();

    @Attribute(name = "title")
    public abstract String getTitle();

    @Attribute(name = "shortTitle", required = false) @Nullable
    protected abstract String getShortTitleOrNull();

    @Value.Auxiliary
    public Optional<String> getShortTitle() {
        return Optional.ofNullable(getShortTitleOrNull());
    }

}
