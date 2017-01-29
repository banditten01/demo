package dk.pvilladsen.textformatdemo.formatter.linebreaker;

import dk.pvilladsen.textformatdemo.util.Pair;

public class WrapLineBreaker extends AbstractLineBreaker implements LineBreaker {

	public WrapLineBreaker(int outputWidth) {
		super(outputWidth);
	}

	@Override
	public Pair<String, String> breakLine(String text) {
		
		
		if(text != null && text.length() > getOutputWidth()) {
			int breakPoint = text.substring(0, getOutputWidth() + 1).trim().lastIndexOf(' ');
			return Pair.of(text.substring(0, breakPoint).trim(), text.substring(breakPoint).trim());
		} else {
			return Pair.of(text, null);
		}
	}

}
