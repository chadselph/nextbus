package me.chadrs.nextbus.model;

import org.simpleframework.xml.Attribute;

import java.util.Optional;

/**
 * Route for a transportation agency
 */
public class Route {
    private final String tag;
    private final String title;
    private final Optional<String> shortTitle;

    public Route(@Attribute(name = "tag") String tag,
                 @Attribute(name = "title") String title,
                 @Attribute(name = "shortTitle", required = false) String shortTitle) {
        this.tag = tag;
        this.title = title;
        this.shortTitle = Optional.ofNullable(shortTitle);
    }

    @Attribute(name = "tag")
    public String getTag() {
        return tag;
    }

    @Attribute(name = "title")
    public String getTitle() {
        return title;
    }

    @Attribute(name = "shortTitle", required = false)
    public String getShortTitle() {
        return shortTitle.orElse(title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (tag != null ? !tag.equals(route.tag) : route.tag != null) return false;
        if (title != null ? !title.equals(route.title) : route.title != null) return false;
        return shortTitle != null ? shortTitle.equals(route.shortTitle) : route.shortTitle == null;

    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (shortTitle != null ? shortTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", shortTitle=" + shortTitle +
                '}';
    }
}
