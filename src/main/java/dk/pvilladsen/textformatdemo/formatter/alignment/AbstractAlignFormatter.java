package dk.pvilladsen.textformatdemo.formatter.alignment;

import java.util.Arrays;

public abstract class AbstractAlignFormatter implements AlignFormatter {
	private int outputWidth;

	public AbstractAlignFormatter(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public int getOutputWidth() {
		return outputWidth;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	protected String getEmptySpace(int size) {
		final char[] array = new char[size];
		Arrays.fill(array, ' ');
		return new String(array);
	}
	
	public abstract String alignText(String text);
	
}
