package com.unisys.fairylights.main;

import com.unisys.fairylights.FairyLightsController;
import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.strategy.AlternateDisplayStrategy;
import com.unisys.fairylights.util.Messages;


/**
 * Main Runner class.
 * @author Shahjahan
 *
 */
public class MainRunner {

	private static final String EXCEPTION_MAIN_NO_ARGS = "Exception.NoArgs";

	public static void main(String[] args) {
		String algorithmName = null;
		int lengthOfLights = FairyLightsFactory.DEFAULT_LIGHTS_COUNT;
		if( args.length == 0){
			System.err.println(Messages.getString(EXCEPTION_MAIN_NO_ARGS));
			return;
		} 
		
		if( args.length == 2 && isInteger(args[1])){
			lengthOfLights = Integer.parseInt(args[1]);
		}
		
		algorithmName = args[0];
		FairyLightsController fairyLightsController = new FairyLightsController();
		fairyLightsController.run(algorithmName, lengthOfLights, Thread.currentThread());
	}
	
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	    	//ignore
	    }
	    return false;
	}

}
