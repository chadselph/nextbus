package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 <body>
 <predictions agencyTitle="San Francisco Muni, CA" routeTag="N"
 routeCode="1" routeTitle="N - Judah" stopTitle="Civic Center Station
 Outbound">
 */
@Root(name = "prediction")
@Value.Immutable
@Value.Style(passAnnotations = {Attribute.class, Root.class}, of = "new", typeImmutable = "*")
public abstract class AbstractPredictionList {

  @Value.Parameter @Attribute(name = "agencyTitle") public abstract String getAgencyTitle();
  @Value.Parameter @Attribute(name = "routeTag") public abstract String getRouteTag();
  @Value.Parameter @Attribute(name = "routeCode", required = false) public abstract String getRouteCode();
  @Value.Parameter @Attribute(name = "routeTitle") public abstract String getRouteTitle();
  @Value.Parameter @Attribute(name = "stopTitle") public abstract String getStopTitle();
  @Value.Parameter @Attribute(name = "stopTag") public abstract String getStopTag();

}
