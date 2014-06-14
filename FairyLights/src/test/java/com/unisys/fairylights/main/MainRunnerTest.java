package com.unisys.fairylights.main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unisys.fairylights.util.Messages;

public class MainRunnerTest {

	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private PrintStream original = System.err;

	@Before
	public void setUpStreams() {
	  System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setErr(original);
	}
	
	@Test
	public void shouldDisplayErrorMessageForNoArguments() {
		MainRunner.main( new String[]{});
		assertEquals(Messages.getString("Exception.NoArgs"), errContent.toString().trim());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionForBadName() {
		MainRunner.main( new String[]{"abc"});
		
	}

}
