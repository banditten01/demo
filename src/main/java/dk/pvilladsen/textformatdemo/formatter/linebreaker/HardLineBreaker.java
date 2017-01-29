package dk.pvilladsen.textformatdemo.formatter.linebreaker;

import dk.pvilladsen.textformatdemo.util.Pair;

public class HardLineBreaker extends AbstractLineBreaker implements LineBreaker {

	public HardLineBreaker(int outputWidth) {
		super(outputWidth);
	}

	@Override
	public Pair<String, String> breakLine(String text) {
		if(text != null && text.length() > getOutputWidth()) {
			return Pair.of(text.substring(0, getOutputWidth()).trim(), text.substring(getOutputWidth()).trim());
		} else {
			return Pair.of(text, null);
		}
	}

}
