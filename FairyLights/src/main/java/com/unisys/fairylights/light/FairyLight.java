package com.unisys.fairylights.light;


/**
 * Simple implementation of {@link Light} 
 * @author Shahjahan
 *
 */
public class FairyLight implements Light {

	private LightStatus lightStatus;
	private LightColour colour;
	private int id;

	public FairyLight(int id,LightColour lightColour) {
		this.colour = lightColour;
		this.id = id;
		this.lightStatus = LightStatus.OFF;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void changeLightStatus(LightStatus newStatus) {
		this.setLightStatus(newStatus);
	}
	
	public LightStatus getLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(LightStatus lightStatus) {
		this.lightStatus = lightStatus;
	}

	@Override
	public LightColour getLightColour() {
		return colour;
	}

	public void setLightColour(LightColour colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return String.format("Light %s %s %s\n", this.id, this.colour.name().toLowerCase(), this.lightStatus.name().toLowerCase());
	}


}
