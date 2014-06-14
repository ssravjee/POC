package com.unisys.fairylights.strategy;

import java.util.List;

import com.unisys.fairylights.light.Light;
import com.unisys.fairylights.light.LightStatus;

/**
 * Provides basic functionality, such as delay, blink and change of status.
 * 
 * @author Shahjahan
 *
 */
public abstract class AbstractDisplayStrategy implements DisplayStrategy  {

	/**
	 *  Wrapper around {@link Thread#sleep(long)} 
	 * @param time
	 */
	protected void delay(long time, Thread t) {
		try {
			System.out.println(t.getName());
			t.sleep(time);
		} catch (InterruptedException e) {
			//No other thread exists - just restore the status
			t.interrupt(); 
		}
	}

	/**
	 * Blinks all provided lights for the given time.
	 * @param lights 
	 * @param delay
	 */
	protected void blink(List<Light> lights, int delay, Thread t) {
		changeStatus(lights, LightStatus.ON);
		delay(delay, t);
		changeStatus(lights, LightStatus.OFF);
	}

	/**
	 * Blinks the light for the given delay.
	 * @param light
	 * @param delay
	 */
	protected void blink(Light light, int delay, Thread t) {
		changeStatus(light, LightStatus.ON);
		delay(delay,t);
		changeStatus(light, LightStatus.OFF);
	}

	//Change status of all lights to the given status
	private void changeStatus(List<Light> lights, LightStatus lightStatus) {
		for (Light light : lights) {
			changeStatus(light, lightStatus);
		}
	}

	//Change status for the light to the given status
	private void changeStatus(Light light, LightStatus lightStatus) {
		light.changeLightStatus(lightStatus);
		System.out.print(light);
	}
	
}