package dk.pvilladsen.textformatdemo.formatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import dk.pvilladsen.textformatdemo.formatter.TextFormatter;

public class TextFormatterArgTest {
	
	@BeforeClass
	public static void startTest() {
		System.out.println("Starting argument test...");
	}
	
	@Test
	/**
	 * Test with fully valid arguments
	 */
	public void testJustiArguments() {
		String[] args = {"-a", "justify", "-l", "wrap", "-w", "80"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	/**
	 * Test left align argument
	 */
	public void testLeftAlignArguments() {
		String[] args = {"-a", "left", "-l", "wrap", "-w", "80"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	/**
	 * Test right align argument
	 */
	public void testRightAlignArguments() {
		String[] args = {"-a", "right", "-l", "wrap", "-w", "80"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	/**
	 * Test center align argument
	 */
	public void testCenterAlignArguments() {
		String[] args = {"-a", "center", "-l", "wrap", "-w", "80"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	/**
	 * Test center align argument
	 */
	public void testHardLineBreakArguments() {
		String[] args = {"-a", "center", "-l", "hard", "-w", "80"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}
	
	@Test
	/**
	 * Test invalid argument.
	 * 
	 */
	public void testInvalidArgument() {
		String[] args = {"-x"};
		boolean errorCaught = false;
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertTrue(errorCaught);
	}

	@Test
	/**
	 * Test argument is null
	 */
	public void testNullArgument() {
		boolean errorCaught = false;
		try {
			new TextFormatter(null);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		// Formatter uses default arguments.
		// No arguments is ok.
		assertFalse(errorCaught);
	}
	
	@Test
	/**
	 * Test no arguments
	 */
	public void testNoArgument() {
		boolean errorCaught = false;
		String[] args = {};
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		// Formatter uses default arguments.
		// No arguments is ok.
		assertFalse(errorCaught);
	}

	@Test
	/**
	 * Test invalid width
	 */
	public void testWidthArgument() {
		boolean errorCaught = false;
		String[] args = {"-w", "-90"};
		try {
			new TextFormatter(args);
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertTrue(errorCaught);
	}
}
