package xiangqi.studentyliu17.version.beta;

import xiangqi.studentyliu17.XiangqiGameState;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPieceType;

import java.util.LinkedList;
import java.util.List;

/**
 * Validator factory
 * 
 * @version Jan 28, 2017
 */
public class ValidatorFactory {
    private static Validator orthogonalValidator = (CoordinateImpl c1, CoordinateImpl c2,
                                                    XiangqiGameState state, XiangqiColor
                                                            currentPlayer) ->
            c2.isOrthogonal(c1);
    private static Validator diagonalValidator   = (CoordinateImpl c1, CoordinateImpl c2,
                                                    XiangqiGameState state, XiangqiColor
                                                            currentPlayer) -> c2.isDiagonal(c1);
    private static Validator adjacentValidator   = (CoordinateImpl c1, CoordinateImpl c2,
                                                    XiangqiGameState state, XiangqiColor
                                                            currentPlayer) -> c2.distanceTo(c1)
                                                                               == 1 ||
                                                                               (c2.isDiagonal(c1)
                                                                                && c2.distanceTo
                                                                                       (c1) == 2);
    
    private static Validator differentCoordinateValidator = (CoordinateImpl c1, CoordinateImpl
            c2, XiangqiGameState state, XiangqiColor
            currentPlayer) -> !c2.equals(c1);
    
    private static Validator differentColorValidator = (CoordinateImpl c1, CoordinateImpl c2,
                                                        XiangqiGameState state, XiangqiColor
                                                                currentPlayer) -> state.getPieceAt(c1, currentPlayer).getColor() != state.getPieceAt(c2, currentPlayer).getColor();
    
    private static Validator jumpOverNoPieceValidator = (CoordinateImpl c1, CoordinateImpl c2,
                                                         XiangqiGameState state, XiangqiColor
                                                                 currentPlayer) ->
            c2.isOrthogonal(c1) && state.numOrthogonalPiecesInBetween(c1, c2, currentPlayer) == 0;
    
    private static Validator verticalValidator = (CoordinateImpl c1, CoordinateImpl c2,
                                                  XiangqiGameState state, XiangqiColor
                                                          currentPlayer) -> c2.isVertical(c1);
    
    private static Validator moveForwardValidator = (CoordinateImpl c1, CoordinateImpl c2,
                                                     XiangqiGameState state, XiangqiColor
                                                             currentPlayer) -> c2.isInFrontOf(c1);
    /**
     * Creation method for validators
     * 
     * @param pieceType The XiangqiPieceType to generate validator for
     * @return list of validators for the given XiangqiPieceType
     */
    public static List<Validator> makeValidators(XiangqiPieceType pieceType) {
        
        List<Validator> validators = new LinkedList<>();
        switch (pieceType) {
            case CHARIOT:
                validators.add(differentColorValidator);
                validators.add(differentCoordinateValidator);
                validators.add(orthogonalValidator);
                validators.add(jumpOverNoPieceValidator);
                break;
            case ADVISOR:
                validators.add(differentColorValidator);
                validators.add(differentCoordinateValidator);
                validators.add(diagonalValidator);
                validators.add(adjacentValidator);
                break;
            case GENERAL:
                validators.add(differentColorValidator);
                validators.add(differentCoordinateValidator);
                validators.add(orthogonalValidator);
                validators.add(makeRangeValidator(1, 1, 2, 4));
                validators.add(adjacentValidator);
                break;
            case SOLDIER:
                validators.add(differentColorValidator);
                validators.add(differentCoordinateValidator);
                validators.add(verticalValidator);
                validators.add(adjacentValidator);
                validators.add(moveForwardValidator);
                break;
            default:
                System.out.println("Not yet implemented!");
        }
        return validators;
    }
    
    private static Validator makeRangeValidator(int fromRank, int toRank, int fromFile, int
            toFile) {
        return (CoordinateImpl c1, CoordinateImpl c2, XiangqiGameState state, XiangqiColor
                currentPlayer) -> c2.isInRange
                (fromRank, toRank, fromFile, toFile);
    }
}
