package com.unisys.fairylights.light;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FairyLightFactoryTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNoLights() {
		FairyLightsFactory.buildFairyLights(0);
	}

	@Test
	public void shouldSetupStandardFairyLights() {
		// act
		List<Light> standardFairyLights = FairyLightsFactory.buildStandardFairyLights();

		// assert
		assertEquals("Size of Standard Fairy Lights should be " + FairyLightsFactory.DEFAULT_LIGHTS_COUNT, FairyLightsFactory.DEFAULT_LIGHTS_COUNT,
				standardFairyLights.size());
	}

	@Test
	public void shouldSetupLightsInAlternatingColours() {
		final int numberOfLights = 32;
		// act
		List<Light> fairyLights = FairyLightsFactory.buildFairyLights(numberOfLights);

		//assert
		assertEquals(numberOfLights, fairyLights.size());

		// assert
		for (int i = 0; i < numberOfLights; i++) {
			assertEquals(LightColour.RED, fairyLights.get(i++).getLightColour());

			if (i < numberOfLights) {
				assertEquals(LightColour.GREEN, fairyLights.get(i++).getLightColour());
			}

			if (i < numberOfLights) {
				assertEquals(LightColour.WHITE, fairyLights.get(i).getLightColour());
			}
		}

	}
}
