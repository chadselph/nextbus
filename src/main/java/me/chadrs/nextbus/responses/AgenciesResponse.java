package me.chadrs.nextbus.responses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import me.chadrs.nextbus.model.Agency;

/**
 * Created by chad on 7/24/16.
 */
@Root(name = "body")
public class AgenciesResponse {
    private final List<Agency> agencies;
    private final String copyright;

    public AgenciesResponse(@ElementList(name = "agency", inline = true) List<Agency> agencies,
                            @Attribute(name = "copyright") String copyright) {
        this.agencies = agencies;
        this.copyright = copyright;
    }

    @ElementList(name = "agency", inline = true)
    public List<Agency> getAgencies() {
        return agencies;
    }

    @Attribute(name = "copyright")
    public String getCopyright() {
        return copyright;
    }

    @Override
    public String toString() {
        return "AgenciesResponse{" +
                "agencies=" + agencies +
                ", copyright='" + copyright + '\'' +
                '}';
    }
}
