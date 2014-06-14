package com.unisys.fairylights.light;

import java.util.ArrayList;
import java.util.List;

import com.unisys.fairylights.util.Messages;

/**
 * Factory to build fairy lights.
 * 
 * @see FairyLight
 */
public class FairyLightsFactory {

	public static final int DEFAULT_LIGHTS_COUNT = 20;

	private static final String ZERO_LIGHTS = "Exception.ZeroLights";

	/**
	 * Builds fairy lights of the given size
	 * 
	 * @param numberOfLights
	 *            size
	 * @return List of fairy lights
	 */
	public static List<Light> buildFairyLights(int numberOfLights) {
		if (numberOfLights < 1)
			throw new IllegalArgumentException(Messages.getString(ZERO_LIGHTS));

		LightColour[] availableColours = LightColour.values();

		List<Light> fairyLights = new ArrayList<Light>();

		for (int j = 0; j < numberOfLights; j++) {
			fairyLights.add(new FairyLight(j + 1, availableColours[j % availableColours.length]));
		}

		return fairyLights;
	}

	/**
	 * Builds fairy lights of the standard size
	 * 
	 * @return List of fairy lights
	 */
	public static List<Light> buildStandardFairyLights() {
		return buildFairyLights(DEFAULT_LIGHTS_COUNT);
	}
}
