package com.unisys.fairylights.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.unisys.fairylights.light.Light;
import com.unisys.fairylights.light.LightColour;

/**
 * Provides colour display strategy as described in the assignment document.
 * <p/>
 * <b>colour : all of the red lights are turned on for 1 second, 
 * then all the green for 1 second then all the white for 1 second
 * As soon as the algorithm completes, it should start again.</b>
 * <p/>
 */
public class ColourDisplayStrategy extends AbstractDisplayStrategy {

	public static final String NAME = "COLOUR";

	private boolean continuous = true;

	private static final int WAIT_TIME = 1000; // 1 second

	private interface FilterPredicate<E> {
		boolean apply(E type);
	}

	@Override
	public void execute(List<Light> fairyLights, Thread t) {

		// available colours
		List<LightColour> colours = Arrays.asList(LightColour.values());
		
		//ordered list of coloured lights
		List<List<Light>> sortedLights = new ArrayList<List<Light>>();
		
		for (final LightColour colour : colours) {
			List<Light> colouredLights = findLights(fairyLights, new FilterPredicate<Light>() {

				@Override
				public boolean apply(Light light) {
					return light.getLightColour() == colour;
				}
			});

			if (!colouredLights.isEmpty())
				sortedLights.add(colouredLights);
		}
		
		do{
			for (List<Light> list : sortedLights) {
				blink(list, WAIT_TIME, t);
			}
		}while(continuous);
	}

	private List<Light> findLights(List<Light> fairyLights, FilterPredicate<Light> predicate) {
		List<Light> coloredLights = new ArrayList<Light>();

		for (Light light : fairyLights) {
			if (predicate.apply(light)) {
				coloredLights.add(light);
			}
		}

		return coloredLights;
	}
	
	void setContinuous(boolean cont){
		this.continuous = cont;
	}

	

}