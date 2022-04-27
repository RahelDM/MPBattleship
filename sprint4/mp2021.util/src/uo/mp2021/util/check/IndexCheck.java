/**
 * 
 */
package uo.mp2021.util.check;

/**
 * @author Raquel
 *
 */
public class IndexCheck {
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo IndexOutOfBoundsException en la que se envía el mensaje del 
	 * parámetro
	 * 
	 * @param condition
	 * @param msg
	 */
	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
			throw new IndexOutOfBoundsException(msg);
		}
	}
	
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo IndexOutOfBoundsException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new IndexOutOfBoundsException();
		}
	}
}
