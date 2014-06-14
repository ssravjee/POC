package com.unisys.fairylights;

import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.strategy.DisplayStrategy;
import com.unisys.fairylights.strategy.DisplayStrategyFactory;

/**
 * FairyLightsController responsible for displaying fairy lights as per the {@link DisplayStrategy}.
 * @see DisplayStrategy
 */
public class FairyLightsController {

	/**
	 * Execute the given strategy for displaying fairy lights
	 * @param displayStrategyName the name of the strategy
	 */
	public void run(String displayStrategyName, int numberOfLights, Thread t) {
		run(DisplayStrategyFactory.getStrategy(displayStrategyName), numberOfLights, t);
	}
	

	/**
	 * @param displayStrategy
	 * @param numberOfLights length of fairy lights
	 */
	public void run(DisplayStrategy displayStrategy, int numberOfLights, Thread t) {
		displayStrategy.execute(FairyLightsFactory.buildFairyLights(numberOfLights), t);
	}
}
