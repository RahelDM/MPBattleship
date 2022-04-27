/**
 * 
 */
package uo.mp2021.util.check;

/**
 * @author Raquel
 *
 */
public class StatesCheck {
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo IllegalStateException en la que se env�a el mensaje del 
	 * par�metro
	 * 
	 * @param condition
	 * @param msg
	 */
	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
			throw new IllegalStateException(msg);
		}
	}
	
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo IllegalStateException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new IllegalStateException();
		}
	}
}
