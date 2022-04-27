/**
 * 
 */
package uo.mp.battleship.board.squares;

/**
 * @author Raquel Su�rez
 *
 */
public interface Target {

	int shootAt();

	boolean hasImpact();

	char toChar();

	char toFiredChar();

}
