package dk.pvilladsen.textformatdemo.formatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import dk.pvilladsen.textformatdemo.formatter.TextFormatter;

public class TextAlignmentTest {
	private static final String LORUM_IPSUM =  "primis arcu libero fusce dolor vel sit semper ut lectus libero massa senectus augue venenatis eu mus felis amet erat nunc lobortis tincidunt ac mattis elit proin pellentesque malesuada amet ultrices ullamcorper nascetur turpis pede in diam tellus nunc torquent non dolor platea vel lorem felis sit pellentesque ante mi fusce vivamus eros ipsum torquent quis pellentesque leo dolor donec cras porttitor consequat hendrerit elit feugiat aliquet habitasse ultricies eu ultricies pellentesque senectus pulvinar volutpat mi orci non netus.";
	private static final String QUICK_FOX = "A quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog.";
	private static final String SHORT_TEXT = "Short text with some wording, but only some.";
	
	@BeforeClass
	public static void alignmentTest() {
		System.out.println("Starting alignment test...");
	}
	
	@Test
	public void testLeftAlign() {
		String[] args = {"-a", "left", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(SHORT_TEXT);
			assertTrue(text.charAt(0) != ' ');
			assertTrue(text.contains(SHORT_TEXT));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}
	
	@Test
	public void testRightAlign() {
		String[] args = {"-a", "right", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(SHORT_TEXT);
			assertTrue(text.charAt(text.length() - 1) != ' ');
			assertTrue(text.startsWith("      " + SHORT_TEXT));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	public void testCenterAlign() {
		String[] args = {"-a", "center", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(SHORT_TEXT);
			assertTrue(text.startsWith("   " + SHORT_TEXT + "   "));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	public void testJustifyAlign() {
		String[] args = {"-a", "justify", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(SHORT_TEXT);
			assertTrue(text.startsWith("Short  text  with  some  wording,  but  only some."));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}
}
