package com.unisys.fairylights.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unisys.fairylights.light.FairyLight;
import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.light.Light;
import com.unisys.fairylights.light.LightColour;
import com.unisys.fairylights.light.LightStatus;

public class AbstractDisplayStrategyTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private SequenceDisplayStrategy strategy;
	private PrintStream original = System.out;

	@Before
	public void setUpStreams() {
		strategy = new SequenceDisplayStrategy();
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		strategy = null;
		System.setOut(original);
	}

	@Test
	public void shouldChangeLightStatus() throws Exception {
		// setup
		Method method = AbstractDisplayStrategy.class.getDeclaredMethod("changeStatus", Light.class, LightStatus.class);
		method.setAccessible(true);
		FairyLight fairyLight = new FairyLight(2, LightColour.RED);

		// act
		method.invoke(strategy, fairyLight, LightStatus.ON);

		// assert
		assertSame(LightStatus.ON, fairyLight.getLightStatus());
	}

	@Test
	public void shouldChangeLightStatusForAList() throws Exception {
		// setup
		Method method = AbstractDisplayStrategy.class.getDeclaredMethod("changeStatus", List.class, LightStatus.class);
		method.setAccessible(true);
		List<Light> fairyLights = FairyLightsFactory.buildFairyLights(15);

		// act
		method.invoke(strategy , fairyLights, LightStatus.ON);

		// assert
		for (Light light : fairyLights) {
			assertSame(LightStatus.ON, light.getLightStatus());
		}

	}

	@Test
	public void shouldBlinkAndChangeStatusTwice() throws Exception {
		// setup
		Method method = AbstractDisplayStrategy.class.getDeclaredMethod("blink", Light.class, int.class);
		FairyLight fairyLight = new FairyLight(2, LightColour.RED);

		// act
		method.invoke(strategy, fairyLight, 0);// no delay required

		// assert
		assertEquals("Light 2 red on\n" + "Light 2 red off\n" , outContent.toString());
	}

	@Test
	public void shouldBlinkAndChangeStatusForEachColour() throws Exception {
		// setup
		Method method = AbstractDisplayStrategy.class.getDeclaredMethod("blink", List.class, int.class);
		List<Light> fairyLights = FairyLightsFactory.buildFairyLights(3);
		StringBuilder str = new StringBuilder();
		str.append("Light 1 red on\n").append("Light 2 green on\n").append("Light 3 white on\n").append("Light 1 red off\n")
				.append("Light 2 green off\n").append("Light 3 white off\n");

		// act
		method.invoke(strategy, fairyLights, 0);// no delay required

		// assert
		assertEquals(str.toString(), outContent.toString());
	}

	@Test(timeout = 1080)
	public void shouldDelayByGivenMilliseconds() throws Exception {
		Method method = AbstractDisplayStrategy.class.getDeclaredMethod("delay", long.class);
		long start = System.currentTimeMillis();
		method.invoke(strategy, 1000l);
		long end = System.currentTimeMillis();
		assertTrue("Should Sleep for one Sec.", (end - start) > 999);
	}

}
