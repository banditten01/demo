package dk.pvilladsen.textformatdemo.formatter.linebreaker;

import dk.pvilladsen.textformatdemo.util.Pair;

public abstract class AbstractLineBreaker implements LineBreaker {
	private int outputWidth=80;
	
	public AbstractLineBreaker(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public int getOutputWidth() {
		return outputWidth;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public abstract Pair<String, String> breakLine(String text);

}
