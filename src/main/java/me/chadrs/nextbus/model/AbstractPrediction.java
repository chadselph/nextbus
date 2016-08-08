package me.chadrs.nextbus.model;

import org.immutables.value.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import javax.annotation.Nullable;

/**
 /*   <prediction epochTime="1470618799755" seconds="355" minutes="5" isDeparture="false" dirTag="N____O_F00" vehicle="438" vehiclesInConsist="2" block="9704" tripTag="7219300" />
 */
@Root(name = "prediction")
@Value.Immutable
abstract class AbstractPrediction {

    @Attribute(name = "epochTime")
    public abstract long getEpochTime();
    @Attribute(name = "seconds")
    public abstract int getSeconds();
    @Attribute(name = "minutes")
    public abstract int getMinutes();
    @Attribute(name = "isDeparture")
    public abstract boolean getIsDeparture();
    @Attribute(name = "dirTag")
    public abstract String getDirTag();
    @Attribute(name = "vehicle")
    public abstract String getVehicle();
    @Attribute(name = "vehiclesInConsist", required = false) @Nullable
    public abstract String getVehiclesInConsist();
    @Attribute(name = "block")
    public abstract String getBlock();
    @Attribute(name = "tripTag")
    public abstract String getTripTag();
    @Attribute(name = "affectedByLayover", required = false) @Nullable
    public abstract Boolean getAffectedByLayover();


}
