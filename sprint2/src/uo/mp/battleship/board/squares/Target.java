/**
 * 
 */
package uo.mp.battleship.board.squares;

/**
 * @author Raquel Suárez
 *
 */
public interface Target {

	int shootAt();

	boolean hasImpact();

	char toChar();

	char toFiredChar();

}
