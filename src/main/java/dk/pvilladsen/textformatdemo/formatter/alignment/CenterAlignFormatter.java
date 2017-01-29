package dk.pvilladsen.textformatdemo.formatter.alignment;

public class CenterAlignFormatter extends AbstractAlignFormatter implements AlignFormatter {

	public CenterAlignFormatter(int outputWidth) {
		super(outputWidth);
	}

	/**
	 * Align text at center
	 */
	public String alignText(String text) {
		int emptySpace = getOutputWidth() - text.length();

		if (emptySpace > 1) {
			int leftSideEmptySpace = emptySpace / 2;
			return getEmptySpace(leftSideEmptySpace) + text + getEmptySpace(emptySpace - leftSideEmptySpace);
		}

		return text;
	}



}
