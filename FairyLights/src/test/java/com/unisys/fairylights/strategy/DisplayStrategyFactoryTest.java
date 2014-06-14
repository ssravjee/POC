package com.unisys.fairylights.strategy;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class DisplayStrategyFactoryTest {

	@Test(expected=IllegalArgumentException.class)
	public void shouldTrhowExceptionNull() {
		DisplayStrategyFactory.getStrategy( null );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldTrhowExceptionForEmpmtyName() {
		DisplayStrategyFactory.getStrategy( "" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionForBadName() {
		DisplayStrategyFactory.getStrategy( "UnknownStrategy");
	}

	@Test
	public void shouldGetObjectForValidNameSequence() {
		DisplayStrategy instance = DisplayStrategyFactory.getStrategy("SEQUENCE");
		assertNotNull("SequenceDisplayStrategy strategy expected ", instance);
	}
	

	@Test
	public void shouldGetObjectForValidNameColour() {
		DisplayStrategy instance = DisplayStrategyFactory.getStrategy("Colour" );
		assertNotNull("ColourDisplayStrategy strategy expected", instance);
	}
	
	
	@Test
	public void shouldTrimNameOfStrategy() {
		DisplayStrategy instance = DisplayStrategyFactory.getStrategy( ColourDisplayStrategy.NAME + "   ");
		assertNotNull("ColourDisplayStrategy algorithm expected", instance);
	}
	
	@Test
	public void shouldIgnoreCaseWhenMatchingStrategy() {
		DisplayStrategy instance = DisplayStrategyFactory.getStrategy( ColourDisplayStrategy.NAME.toLowerCase());
		assertNotNull("ColourDisplayStrategy algorithm expected", instance);
	}
}
