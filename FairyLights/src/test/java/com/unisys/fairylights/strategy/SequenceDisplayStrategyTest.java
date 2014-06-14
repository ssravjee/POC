package com.unisys.fairylights.strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.light.Light;

public class SequenceDisplayStrategyTest {

	private MockSequenceDisplayStrategy sequenceDisplayStrategy;

	private class MockSequenceDisplayStrategy extends SequenceDisplayStrategy {
		
		@Override
		protected void delay(long time) {
			super.delay(time);
			// assert
			assertEquals("Delay should be of 500 milli seconds.", 500, time);
		}

		@Override
		protected void blink(Light light, int delay) {
			super.blink(light, delay);
			blinkCount++;
		}

		public int getBlinkCount() {
			return blinkCount;
		}

		private int blinkCount;

	}

	@Test
	public void shouldDelayBlinkFor500() throws Exception {

		// act
		sequenceDisplayStrategy.execute(FairyLightsFactory.buildFairyLights(1));

		// assert inside delay of Mock
	}

	@Test
	public void shouldCallBlinkMethodTwice() throws Exception {

		// act
		sequenceDisplayStrategy.execute(FairyLightsFactory.buildFairyLights(2));

		// assert
		assertEquals("Should have called blink twice ", 2, sequenceDisplayStrategy.getBlinkCount());
	}

	@Test(timeout = 10080)
	// 80 nano seconds added for thread management
	public void shouldFinishWithinTenSeconds() throws Exception {

		// act
		sequenceDisplayStrategy.execute(FairyLightsFactory.buildStandardFairyLights());

		// assert timeout
	}

	@Before
	public void setUp() {

		sequenceDisplayStrategy = new MockSequenceDisplayStrategy();
		sequenceDisplayStrategy.setContinuous(false);
	}

	@After
	public void cleanUp() {
		sequenceDisplayStrategy = null;
	}

}
