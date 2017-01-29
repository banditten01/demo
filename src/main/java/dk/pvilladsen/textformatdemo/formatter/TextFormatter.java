package dk.pvilladsen.textformatdemo.formatter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import dk.pvilladsen.textformatdemo.app.ArgsEnum;
import dk.pvilladsen.textformatdemo.formatter.alignment.AlignFormatter;
import dk.pvilladsen.textformatdemo.formatter.alignment.AlignFormatterFactory;
import dk.pvilladsen.textformatdemo.formatter.linebreaker.LineBreaker;
import dk.pvilladsen.textformatdemo.formatter.linebreaker.LineBreakerFactory;
import dk.pvilladsen.textformatdemo.util.Pair;

/**
 * 
 * TextFormatter:<br />
 * Formats raw text.<br />
 * Alignment  and line breaking.<br />
 *
 * @author Peter Villadsen<br />
 * 
 */
public class TextFormatter {
	private AlignFormatter alignFormatter = null;
	private LineBreaker lineBreaker = null;
	private static final String SYNTAX = "Syntax: -a [left | right | center | justify] -l [hard | wrap] -w output-width";

	/**
	 * A text formatter
	 * 
	 * @param -a [left | right | center | justify] -l [hard | wrap] -w output-width"
	 */
	public TextFormatter(String[] args) {

		String result = validateAndSetOptions(args == null ? new String[0] : args);
		if (result != null) {
			// Refactor to app specific exception
			throw new RuntimeException(validateAndSetOptions(args));
		}

	}

	/**
	 * Formats raw text with alignment and line breaking.<br />
	 * @param rawText
	 * @return formattet text
	 */
	public String formatText(String rawText) {
		// Split raw text into sections
		String[] sections = rawText.split("\n");
		StringBuilder sb = new StringBuilder();
		
		for(String section : sections) {
			sb.append(formatSection(section));
		}
		return sb.toString();
	}

	/**
	 * Format text. Assumed to be one section.<br />
	 * @param rawText
	 * @return the formattet text in section as String
	 */
	private String formatSection(String rawText) {
		StringBuilder sb = new StringBuilder();
		String remainingText = rawText;

		// Keep looping until all text has been formattet.
		while (remainingText != null && remainingText.length() > 0) {
			Pair<String, String> brokenLine = lineBreaker.breakLine(remainingText);
			sb.append(alignFormatter.alignText(brokenLine.getLeft()) + "\n");
			remainingText = brokenLine.getRight();
		}

		return sb.toString();
	}

	/**
	 * @TODO too complex please refactor
	 * @param args
	 * @return
	 */
	private String validateAndSetOptions(String[] args) {
		String alignment = "left";
		String lineBreak = "hard";
		String lineWidthStr = "80";

		// Use iterator. Eases validation of arguments.
		List<String> argsList = Arrays.asList(args);
		Iterator<String> iter = argsList.iterator();

		// Fetch arguments and options
		while (iter.hasNext()) {
			String sarg = iter.next();
			if (!sarg.startsWith("-") || sarg.length() != 2) {
				return "Invalid argument: " + sarg;
			}
			ArgsEnum arg = ArgsEnum.fromValue(sarg.charAt(1));
			switch (arg) {
			case ALIGN:
				alignment = iter.hasNext() ? iter.next() : null;
				break;
			case LINE_BREAK:
				lineBreak = iter.hasNext() ? iter.next() : null;
				break;
			case LINE_WIDTH:
				lineWidthStr = iter.hasNext() ? iter.next() : null;
				break;
			default:
				return "Invalid argument: " + sarg;
			}
		}

		// Set and validate options

		return setFormatters(alignment, lineBreak, lineWidthStr);
	}

	/**
	 * Set formatters. Alignment & lineBreaker
	 * @param alignment
	 * @param lineBreak
	 * @param lineWidthStr
	 * @return
	 */
	private String setFormatters(String alignment, String lineBreak, String lineWidthStr) {
		int lineWidth;
		
		if (isInteger(lineWidthStr)) {
			lineWidth = Integer.parseInt(lineWidthStr);
		} else {
			return "Invalid line width option: " + lineWidthStr;
		}

		alignFormatter = AlignFormatterFactory.getFormatter(alignment, lineWidth);
		if (alignFormatter == null) {
			return "Invalid alignment option: " + alignment;
		}

		lineBreaker = LineBreakerFactory.getLineBreaker(lineBreak, lineWidth);
		if (lineBreaker == null) {
			return "Invalid line break option: " + lineBreak;
		}

		return null;
	}

	/**
	 * Checks if string contains integer. Returns false if not an integer.
	 * Otherwise true
	 * 
	 * Use this check to avoid exception when parsing string to integer
	 * 
	 * @param numericString
	 *            - String containing value to test
	 * @return true if integer else false
	 */
	private static boolean isInteger(String numericString) {
		return numericString.matches("\\d+");
	}

}
