/**
 * 
 */
package dk.pvilladsen.textformatdemo.formatter.alignment;

/**
 * Align Formatter factory.<br />
 * Use this class to instanciate a AlignFormattter matching paramter.
 * 
 * @author Peter Villadsen
 *
 */
public class AlignFormatterFactory {
	
	// Hide constructor
	private AlignFormatterFactory() {
	}
	
	/**
	 * 
	 * @param formatterStr, align formatter key word. <br />
	 * @param outputWidth, width of output line<br />
	 * @return A AlignFormatter of type formatterStr.<br />
	 */
	public static AlignFormatter getFormatter(String formatterStr, int outputWidth) {
		AlignFormatter formatter = null;
		
		if("left".equalsIgnoreCase(formatterStr)) {
			formatter = new LeftAlignFormatter(outputWidth);
		} else if("right".equalsIgnoreCase(formatterStr)) {
			formatter = new RightAlignFormatter(outputWidth);
		} else if("center".equalsIgnoreCase(formatterStr)) {
			formatter = new CenterAlignFormatter(outputWidth);
		} else if("justify".equalsIgnoreCase(formatterStr)) {
			formatter = new JustifyAlignFormatter(outputWidth);
		}
		
		return formatter;
		
	}

}
