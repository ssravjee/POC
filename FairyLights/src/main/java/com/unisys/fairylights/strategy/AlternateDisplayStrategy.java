package com.unisys.fairylights.strategy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.unisys.fairylights.light.Light;

/**
 * This class provides an example for providing additional display strategy.
 * Displays a single random light.
 */
public class AlternateDisplayStrategy extends AbstractDisplayStrategy {

	public static final String NAME = "ALTERNATE";

	private long waitTime;

	public AlternateDisplayStrategy(long waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * Displays a single random light.
	 */
	@Override
	public void execute(List<Light> fairyLights, Thread t) {
		
	}// end of execute


}
