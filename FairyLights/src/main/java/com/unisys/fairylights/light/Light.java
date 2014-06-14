package com.unisys.fairylights.light;

/**
 * Represents a light with a serial number, colour and can be turned on/off
 * @see LightColour
 * @see LightStatus 
 * @author Shahjahan
 */
public interface Light {

	public abstract int getId();

	public abstract void setLightStatus(LightStatus lightStatus);
	
	public abstract LightStatus getLightStatus();

	public abstract void changeLightStatus(LightStatus newStatus);

	public abstract LightColour getLightColour();
	
	public abstract void setLightColour(LightColour newColour);

}