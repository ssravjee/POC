package com.unisys.fairylights.strategy;

import java.util.List;

import com.unisys.fairylights.light.Light;

/**
 * Implementing classes of this interface are suppose to provide a strategy by implementing execute method. <p/>
 * This interface doesn't force or suggest how to handle fairy lights display.
 * 
 * @author Shahjahan
 */
public interface DisplayStrategy {
	public abstract void execute(List<Light> fairyLights, Thread t);
}