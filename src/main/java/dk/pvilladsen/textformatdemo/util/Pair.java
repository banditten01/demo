package dk.pvilladsen.textformatdemo.util;

/**
 * Pair as Qube.<br />
 * Placeholder of two objects<br />
 * Usage typically when returning two object from method.<br />
 * Easy alternative to implement a new clas.<br />
 * 
 * @param <A>
 * @param <B>
 * 
 * @author Peter Villadsen<br />
 *
 */
public class Pair<A,B> {
	private A left;
	private B right;
	
	public Pair(A left, B right) {
		this.left=left;
		this.right=right;
	}
	
	public static <A, B> Pair<A, B> of(A left, B right) {
		return new Pair<A, B>(left, right);
	}

	public A getLeft() {
		return left;
	}

	public void setLeft(A left) {
		this.left = left;
	}

	public B getRight() {
		return right;
	}

	public void setRight(B right) {
		this.right = right;
	}
}
