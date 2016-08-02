package me.chadrs.nextbus.responses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import me.chadrs.nextbus.model.RouteConfig;

/**
 *
 <body copyright="All data copyright San Francisco Muni 2016.">
 <route tag="N" title="N-Judah" color="003399" oppositeColor="ffffff" latMin="37.7602999" latMax="37.7932299" lonMin="-122.50868" lonMax="-122.38798">
     <stop tag="4447" title="Duboce Ave & Church St" lat="37.7694699" lon="-122.42941" stopId="14447"/>
     <stop tag="7252" title="Sunset Tunnel East Portal" lat="37.7693899" lon="-122.43369" stopId="17252"/>
     <stop tag="3909" title="Carl St & Cole St" lat="37.7658599" lon="-122.4497999" stopId="13909"/>
     <direction tag="N____I_F00" title="Inbound to Caltrain/Ball Park" name="Inbound" useForUI="true">
         <stop tag="5223"/>
         <stop tag="5216"/>
     </direction>
     <path>
         <point lat="37.765" lon="-122.45656"/>
         <point lat="37.76482" lon="-122.45771"/>
    </path>
 */
public class RouteConfigResponse {
    private final String copyright;
    private final RouteConfig routeConfig;

    public RouteConfigResponse(
            @Attribute(name = "copyright")
            String copyright,
            @Element(name = "route")
            RouteConfig routeConfig) {
        this.copyright = copyright;
        this.routeConfig = routeConfig;
    }

    @Element(name = "route")
    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    @Attribute(name = "copyright")
    public String getCopyright() {
        return copyright;
    }

    @Override
    public String toString() {
        return "RouteConfigResponse{" +
                "copyright='" + copyright + '\'' +
                ", routeConfig=" + routeConfig +
                '}';
    }
}
