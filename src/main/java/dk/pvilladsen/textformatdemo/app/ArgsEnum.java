package dk.pvilladsen.textformatdemo.app;

public enum ArgsEnum {
	ALIGN('a'), LINE_BREAK('l'), LINE_WIDTH('w');
	
	private final char value;
	
	private ArgsEnum(char value) {
		this.value = value;
	}
	
	public static ArgsEnum fromValue(char value) {
		switch(value) {
		case 'a' :
			return ALIGN;
		case 'l' :
			return LINE_BREAK;
		case 'w' :
			return LINE_WIDTH;
		default :
			return null;
		}
		
	}
	
	public char getValue() {
		return value;
	}
}
