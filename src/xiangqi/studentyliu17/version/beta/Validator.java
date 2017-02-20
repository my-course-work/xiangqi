package xiangqi.studentyliu17.version.beta;

import xiangqi.studentyliu17.XiangqiGameState;
import xiangqi.common.XiangqiColor;

/**
 * Xiangqi validator
 * 
 * @version Jan 28, 2017
 */
@FunctionalInterface
public interface Validator {
    boolean validate(CoordinateImpl c1, CoordinateImpl c2, XiangqiGameState state, XiangqiColor
            currentPlayer);
}
