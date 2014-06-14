How To Run:

Copy FairyLightsController.jar to a local folder and type the following command.
java -jar FairyLightsController.jar Sequence
or 
java -jar FairyLightsController.jar Colour

How to modify:
Add colour:
Modify Enum com.unisys.fairylights.light.LightColour

e.g. to add a new colour 'yellow'

public enum LightColour {
	//don't change the order
	RED, GREEN, WHITE, YELLOW;
}

Add additional lights
provide additional command line argument for a different length of fairy lights
e.g.  java -jar FairyLightsController.jar Colour 30
java -jar FairyLightsController.jar Colour 15

Add new Algorithm/Strategy
This involves two steps:
Create a new strategy by extending AbstractDisplayStrategy e.g. RandomDisplayStrategy.java
Add strategy to the available strategies map inside DisplayStrategyFactory class
Testing: 
Testing is provided only for proof of concept.

Deliverables: 

1. FairyLightsController.zip contains source code.
2. FairyLightsController.jar (Runnable Jar)

