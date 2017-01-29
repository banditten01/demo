package dk.pvilladsen.textformatdemo.formatter.linebreaker;

import dk.pvilladsen.textformatdemo.util.Pair;

@FunctionalInterface
public interface LineBreaker {
	Pair<String, String> breakLine(String text);
}
