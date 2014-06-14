package com.unisys.fairylights.strategy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.light.Light;

public class ColourDisplayStrategyTest {

	private MockColourDisplayStrategy colourDisplayStrategy;

	private class MockColourDisplayStrategy extends ColourDisplayStrategy {

		@Override
		protected void delay(long time) {
			super.delay(time);
			// assert
			assertEquals("Delay should be of 1000 milli seconds.", 1000, time);
		}

		@Override
		protected void blink(List<Light> lights, int delay) {
			super.blink(lights, delay);
			blinkListCount++;
		}


		public int getBlinkListCount() {
			return blinkListCount;
		}

		private int blinkListCount;
	}

	@Test
	public void shouldDelayBlinkFor1000() throws Exception {

		// act
		colourDisplayStrategy.execute(FairyLightsFactory.buildFairyLights(1));

		// assert inside delay of Mock
	}

	@Test
	public void shouldCallBlinkMethodTwice() throws Exception {

		// act
		colourDisplayStrategy.execute(FairyLightsFactory.buildFairyLights(2));

		// assert
		assertEquals("Should have called blink twice ", 2, colourDisplayStrategy.getBlinkListCount());
	}

	@Test(timeout = 3080)
	// 80 nano seconds added for thread management
	public void shouldFinishWithinThreeSeconds() throws Exception {

		// act
		colourDisplayStrategy.execute(FairyLightsFactory.buildStandardFairyLights());

		// assert timeout
	}

	@Test(timeout = 2080)
	// 80 nano seconds added for thread management
	public void shouldFinishWithinTwoSeconds() throws Exception {

		// act
		colourDisplayStrategy.execute(FairyLightsFactory.buildFairyLights(2));

		// assert timeout
	}

	@Before
	public void setUp() {

		colourDisplayStrategy = new MockColourDisplayStrategy();
		colourDisplayStrategy.setContinuous(false);
	}

	@After
	public void cleanUp() {
		colourDisplayStrategy = null;
	}
}
