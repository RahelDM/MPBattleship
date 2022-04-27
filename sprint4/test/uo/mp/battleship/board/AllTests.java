package uo.mp.battleship.board;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoordinateGoTest.class, GetNotFiredCoordinatesTest.class, IsFleetSunkTest.class, ShootAtTest.class })
public class AllTests {

}
