package com.unisys.fairylights.light;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FairyLightTest {

	@Test
	public void shouldPrintFormattedStatusofRedLight() {
		FairyLight fairyLight = new FairyLight(0, LightColour.RED);
		assertEquals( "Light 0 red off\n", fairyLight.toString());
		
		fairyLight.setLightStatus(LightStatus.ON);
		assertEquals( "Light 0 red on\n", fairyLight.toString());
	}
	
	
	@Test
	public void shouldPrintFormattedStatusofGreenLight() {
		FairyLight fairyLight = new FairyLight(30, LightColour.GREEN);
		assertEquals( "Light 30 green off\n", fairyLight.toString());
		
		fairyLight.setLightStatus(LightStatus.ON);
		assertEquals( "Light 30 green on\n", fairyLight.toString());
	}
	
	
	@Test
	public void shouldPrintFormattedStatusofWhiteLight() {
		FairyLight fairyLight = new FairyLight(10, LightColour.WHITE);
		assertEquals( "Light 10 white off\n", fairyLight.toString());
		
		fairyLight.setLightStatus(LightStatus.ON);
		assertEquals( "Light 10 white on\n", fairyLight.toString());
	}
}
