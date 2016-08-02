package me.chadrs.nextbus.responses;

import me.chadrs.nextbus.model.Route;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * <body copyright="All data copyright San Francisco Muni 2016.">
 <route tag="E" title="E-Embarcadero"/>
 <route tag="F" title="F-Market & Wharves"/>
 <route tag="J" title="J-Church"/>
 <route tag="KT" title="KT-Ingleside/Third Street"/>
 <route tag="L" title="L-Taraval"/>
 <route tag="M" title="M-Ocean View"/>
 <route tag="N" title="N-Judah"/>
 <route tag="NX" title="NX-Express"/>
 <route tag="1" title="1-California"/>
 <route tag="1AX" title="1AX-California A Express"/>
 */
@Root(name = "body")
public class RoutesResponse {
    private final String copyright;
    private final List<Route> routes;

    public RoutesResponse(@Attribute(name = "copyright") String copyright,
                          @ElementList(name = "route", inline = true) List<Route> routes) {
        this.copyright = copyright;
        this.routes = routes;
    }

    @Attribute(name = "copyright")
    public String getCopyright() {
        return copyright;
    }

    @ElementList(name = "route", inline = true)
    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        return "RoutesResponse{" +
                "copyright='" + copyright + '\'' +
                ", routes=" + routes +
                '}';
    }
}
