package com.unisys.fairylights.strategy;

import java.util.List;
import java.util.Random;

import com.unisys.fairylights.light.Light;

/**
 * This class provides an example for providing additional display strategy.
 * Displays a single random light.
 */
public class RandomDisplayStrategy extends AbstractDisplayStrategy {

	public static final String NAME = "RANDOM";

	private static final int WAIT_TIME = 500;

	/**
	 *  Displays a single random light.
	 */
	@Override
	public void execute(List<Light> fairyLights, Thread t) {
		
		int nextRandomNumber = new Random().nextInt(fairyLights.size() - 1);

		Light fairyLight = fairyLights.get(nextRandomNumber);
		
		blink(fairyLight, WAIT_TIME,t);
	}


}
