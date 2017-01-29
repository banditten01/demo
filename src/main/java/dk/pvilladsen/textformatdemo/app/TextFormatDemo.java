package dk.pvilladsen.textformatdemo.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dk.pvilladsen.textformatdemo.formatter.TextFormatter;

/**
 * Demo of a text formatter.<br />
 * Program reads text from stdin and output the formattet text to stdout.<br />
 * <br /><br />
 * Error handling design is simple and is not adequate for production systems<br />
 * But should be ok for demo purposes<br />
 * 
 * Arguments and options:<br />
 * -a is aligment. Can be one of left, right, center or justify<br />
 * -l is line break. Options are either hard or wrap. Defaults to wrap.<br />
 * -w is output width and takes and integer as value.<br />
 *
 * @author Peter Villadsen<br /><br />
 * 
 */
public class TextFormatDemo {
	private static final String SYNTAX = "Syntax: TextFormatDemo -a [left | right | center | justify] -l [hard | wrap] -w output-width";

	// Hide constructor
	private TextFormatDemo() {
	}

	public static void main(String[] args) {
		String result = new TextFormatDemo().textProcessor(args);

		if(result != null) {
			System.err.println("Failed, result: " + result);
			System.out.println(SYNTAX);
		}
		
	}
	
	/**
	 * Format text processor.<br />
	 * @param -a [left | right | center | justify] -l [hard | wrap] -w output-width<br />
	 * @return Null if success ortherwise error as string.
	 */
	private String textProcessor(String[] args) {
		
		try {
			// New textformatter with command line arguments as parameters.
			TextFormatter textFormatter = new TextFormatter(args);
			
			// Get input from stdin.
			String rawText = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			
			// Format raw text and output to stdout.
			System.out.println(textFormatter.formatText(rawText));
		} catch (RuntimeException ex) {
			return "Error formatting raw text: " + ex.getMessage();
		} catch (IOException ex) {
			return "Error reading from stdin: " + ex.getMessage();
		}
		
		return null;
	}
	

}
