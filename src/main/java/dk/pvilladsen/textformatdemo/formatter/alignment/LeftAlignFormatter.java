package dk.pvilladsen.textformatdemo.formatter.alignment;

public class LeftAlignFormatter extends AbstractAlignFormatter implements AlignFormatter {

	public LeftAlignFormatter(int outputWidth) {
		super(outputWidth);
	}

	public String alignText(String text) {
		int emptySpace = getOutputWidth() - text.length();

		if (emptySpace > 0) {
			return text.trim();
		}

		return text;
	}



}
