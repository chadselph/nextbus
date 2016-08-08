@Value.Style(passAnnotations = {Attribute.class, Element.class, ElementList.class, Root.class},
        of = "new", typeImmutable = "*", allParameters = true, visibility = Value.Style.ImplementationVisibility.PUBLIC)
package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;