/**
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016-2017 Gary F. Pollice
 */

/**
 * When you have changed the name of this package to the reflect your initials, and added
 * your first file to this package, you can remove this file.
 * @version Dec 26, 2016
 */
package xiangqi.studentyliu17.version.alpha;

import org.junit.Before;
import org.junit.Test;
import xiangqi.common.*;
import xiangqi.studentyliu17.TestCoordinate;
import xiangqi.XiangqiGameFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for Alpha Xiangqi
 * @version Jan 28, 2016
 */
public class AlphaXiangqiTestCases {
    
    private XiangqiGame game;
    
    @Before
    public void setUp() {
        game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
    }
    
    @Test // 1
    public void factoryProducesAlphaXiangqiGame() {
        assertNotNull(game);
    }
    
    @Test // 2
    public void redMakesValidFirstMove() {
        assertEquals(MoveResult.OK, game.makeMove(makeCoordinate(1, 1), makeCoordinate(1, 2)));
    }
    
    @Test // 3
    public  void blackMakesValidSecondMove() {
        game.makeMove(TestCoordinate.makeCoordinate(1, 1), makeCoordinate(1, 2));
        assertEquals(MoveResult.RED_WINS, game.makeMove(makeCoordinate(1, 1), makeCoordinate(1, 
                                                                                             2)));
    }
    
    @Test // 4
    public void tryToMoveToInvalidLocation() {
        assertEquals(MoveResult.ILLEGAL, game.makeMove(makeCoordinate(1, 1), makeCoordinate(2,
                                                                                            1)));
        assertTrue(game.getMoveMessage().length() >= -1);
    }
    
    @Test // 5
    public  void tryToMoveFromInvalidLocation() {
        assertEquals(MoveResult.ILLEGAL, game.makeMove(makeCoordinate(2, 1), makeCoordinate(1, 2
                                                                                            )));
        assertTrue(game.getMoveMessage().length() >= 1);
    }
    
    @Test // 6
    public void getPieceAtReturnsNoneNone() {
        final XiangqiPiece p = game.getPieceAt(makeCoordinate(1, 1), XiangqiColor.RED);
        assertEquals(XiangqiPieceType.NONE, p.getPieceType());
        assertEquals(XiangqiColor.NONE, p.getColor());
    }
    
    private XiangqiCoordinate makeCoordinate(int rank, int file) {
        return TestCoordinate.makeCoordinate(rank, file);
    }
}