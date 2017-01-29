package dk.pvilladsen.textformatdemo.formatter.alignment;

public class RightAlignFormatter extends AbstractAlignFormatter implements AlignFormatter {

	public RightAlignFormatter(int outputWidth) {
		super(outputWidth);
	}

	public String alignText(String text) {
		int emptySpace = getOutputWidth() - text.length();

		if (emptySpace > 0) {
			return getEmptySpace(emptySpace) + text;
		}

		return text;
	}



}
