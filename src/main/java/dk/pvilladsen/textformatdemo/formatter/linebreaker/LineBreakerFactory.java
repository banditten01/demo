/**
 * 
 */
package dk.pvilladsen.textformatdemo.formatter.linebreaker;

/**
 * @author Peter Villadsen
 *
 */
public class LineBreakerFactory {
	
	// Hide constructor
	private LineBreakerFactory() {
	}
	
	public static LineBreaker getLineBreaker(String formatterStr, int outputWidth) {
		LineBreaker lineBreaker = null;
		
		if("wrap".equalsIgnoreCase(formatterStr)) {
			lineBreaker = new WrapLineBreaker(outputWidth);
		} else if("hard".equalsIgnoreCase(formatterStr)) {
			lineBreaker = new HardLineBreaker(outputWidth);
		}
		
		return lineBreaker;
		
	}

}
