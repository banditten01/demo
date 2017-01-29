package dk.pvilladsen.textformatdemo.formatter.alignment;

public class JustifyAlignFormatter extends AbstractAlignFormatter implements AlignFormatter {

	public JustifyAlignFormatter(int outputWidth) {
		super(outputWidth);
	}

	/**
	 * Jutify text in the line
	 * Assumption: spaces are places between words and not letters
	 * 
	 * Possible enhancements:
	 * 	- Simplify algorithm
	 *	- Better n+1 implementation
	 * 
	 * @return String with justified text
	 */
	public String alignText(String text) {


		String[] words = text.split(" ");

		if (words.length > 1) {
			// Calculate text without spaces
			int tl = text.replace(" ", "").length();

			// Calculate spaces needed
			int emptySpace = getOutputWidth() - tl;
			
			// Calculate number of space sluts to put between words
			int slots = emptySpace / (words.length - 1);

			// There could be remaing spaces to add.
			// n+1 issue
			int slotsExtra = emptySpace % (words.length - 1);

			// Create a spacer to put between words
			String spacer = getEmptySpace(slots);

			StringBuilder sb = new StringBuilder();

			// Add spaces between words
			for (int i = 0; i < words.length; i++) {
				if(i < words.length - 1 ) {
					sb.append(words[i] + spacer + (slotsExtra-- > 0 ? " " : ""));
				} else {
					sb.append(words[i]);
				}
			}

			return sb.toString();
		}

		return text;
	}

}
