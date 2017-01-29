package dk.pvilladsen.textformatdemo.formatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import dk.pvilladsen.textformatdemo.formatter.TextFormatter;

public class LineBreakTest {
	private static final String LORUM_IPSUM =  "primis arcu libero fusce dolor vel sit semper ut lectus libero massa senectus augue venenatis eu mus felis amet erat nunc lobortis tincidunt ac mattis elit proin pellentesque malesuada amet ultrices ullamcorper nascetur turpis pede in diam tellus nunc torquent non dolor platea vel lorem felis sit pellentesque ante mi fusce vivamus eros ipsum torquent quis pellentesque leo dolor donec cras porttitor consequat hendrerit elit feugiat aliquet habitasse ultricies eu ultricies pellentesque senectus pulvinar volutpat mi orci non netus.";
	private static final String QUICK_FOX = "A quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog a quick brown fox jumps over the lazy dog.";
	private static final String SHORT_TEXT = "Short text with some wording, but only some.";
	
	@BeforeClass
	public static void alignmentTest() {
		System.out.println("Starting line break test...");
	}
	
	@Test
	public void testNoLineBreak() {
		String[] args = {"-a", "left", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(SHORT_TEXT);
			assertTrue(text.equals(SHORT_TEXT + "\n"));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	public void testHardLineBreak() {
		String shouldBe = 	"primis arcu libero fusce dolor vel sit semper ut l\n" +
							"ectus libero massa senectus augue venenatis eu mus\n" +
							"felis amet erat nunc lobortis tincidunt ac mattis\n" +
							"elit proin pellentesque malesuada amet ultrices ul\n" +
							"lamcorper nascetur turpis pede in diam tellus nunc\n" +
							"torquent non dolor platea vel lorem felis sit pell\n" +
							"entesque ante mi fusce vivamus eros ipsum torquent\n" +
							"quis pellentesque leo dolor donec cras porttitor c\n" +
							"onsequat hendrerit elit feugiat aliquet habitasse\n" +
							"ultricies eu ultricies pellentesque senectus pulvi\n" +
							"nar volutpat mi orci non netus.\n";
		String[] args = {"-a", "left", "-l", "hard", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(LORUM_IPSUM);
			assertTrue(text.equals(shouldBe));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}

	@Test
	public void testWrapLineBreak() {
		String shouldBe =	"A quick brown fox jumps over the lazy dog a quick\n" + 
							"brown fox jumps over the lazy dog a quick brown\n" + 
							"fox jumps over the lazy dog a quick brown fox\n" + 
							"jumps over the lazy dog a quick brown fox jumps\n" + 
							"over the lazy dog a quick brown fox jumps over\n" + 
							"the lazy dog.\n"; 	
		String[] args = {"-a", "left", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(QUICK_FOX);
			assertTrue(text.equals(shouldBe));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}
	
	@Test
	public void testSectionWrapLineBreak() {
		String shouldBe =	"A quick brown fox jumps over the lazy dog a quick\n" + 
							"brown fox jumps over the lazy dog a quick brown\n" + 
							"fox jumps over the lazy dog a quick brown fox\n" + 
							"jumps over the lazy dog a quick brown fox jumps\n" + 
							"over the lazy dog a quick brown fox jumps over\n" + 
							"the lazy dog.\n" +
							"primis arcu libero fusce dolor vel sit semper ut\n" +
							"lectus libero massa senectus augue venenatis eu\n" +
							"mus felis amet erat nunc lobortis tincidunt ac\n" +
							"mattis elit proin pellentesque malesuada amet\n" +
							"ultrices ullamcorper nascetur turpis pede in diam\n" +
							"tellus nunc torquent non dolor platea vel lorem\n" +
							"felis sit pellentesque ante mi fusce vivamus eros\n" +
							"ipsum torquent quis pellentesque leo dolor donec\n" +
							"cras porttitor consequat hendrerit elit feugiat\n" +
							"aliquet habitasse ultricies eu ultricies\n" +
							"pellentesque senectus pulvinar volutpat mi orci\n" +
							"non netus.\n";							
		String[] args = {"-a", "left", "-l", "wrap", "-w", "50"};
		boolean errorCaught = false;
		try {
			TextFormatter tf = new TextFormatter(args);
			String text = tf.formatText(QUICK_FOX + "\n" + LORUM_IPSUM);
			assertTrue(text.equals(shouldBe));
		} catch (RuntimeException ex) {
			errorCaught = true;
		}
		
		assertFalse(errorCaught);
	}	
}
