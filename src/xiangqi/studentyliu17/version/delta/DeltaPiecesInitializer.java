package xiangqi.studentyliu17.version.delta;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentyliu17.version.common.CoordinateImpl;
import xiangqi.studentyliu17.version.common.PiecesInitializer;
import xiangqi.studentyliu17.version.common.XiangqiPieceImpl;

import java.util.HashMap;

import static xiangqi.common.XiangqiColor.BLACK;
import static xiangqi.common.XiangqiColor.RED;
import static xiangqi.common.XiangqiPieceType.*;

/**
 * Piece initializer for delta xiangqi game
 *
 * @version Feb 25, 2017
 */
public class DeltaPiecesInitializer implements PiecesInitializer {
    private static XiangqiCoordinate c11 = makeCoordinate(1, 1),
            c12 = makeCoordinate(1, 2), c13 = makeCoordinate(1, 3),
            c14 = makeCoordinate(1, 4), c15 = makeCoordinate(1, 5),
            c16 = makeCoordinate(1, 6), c17 = makeCoordinate(1, 7),
            c18 = makeCoordinate(1, 8), c19 = makeCoordinate(1, 9),
            c21 = makeCoordinate(2, 1), c22 = makeCoordinate(2, 2),
            c23 = makeCoordinate(2, 3), c24 = makeCoordinate(2, 4),
            c25 = makeCoordinate(2, 5), c26 = makeCoordinate(2, 6),
            c27 = makeCoordinate(2, 7), c28 = makeCoordinate(2, 8),
            c29 = makeCoordinate(2, 9), c31 = makeCoordinate(3, 1),
            c32 = makeCoordinate(3, 2), c33 = makeCoordinate(3, 3),
            c34 = makeCoordinate(3, 4), c35 = makeCoordinate(3, 5),
            c36 = makeCoordinate(3, 6), c37 = makeCoordinate(3, 7),
            c38 = makeCoordinate(3, 8), c39 = makeCoordinate(3, 9),
            c41 = makeCoordinate(4, 1), c42 = makeCoordinate(4, 2),
            c43 = makeCoordinate(4, 3), c44 = makeCoordinate(4, 4),
            c45 = makeCoordinate(4, 5), c46 = makeCoordinate(4, 6),
            c47 = makeCoordinate(4, 7), c48 = makeCoordinate(4, 8),
            c49 = makeCoordinate(4, 9), c51 = makeCoordinate(5, 1),
            c52 = makeCoordinate(5, 2), c53 = makeCoordinate(5, 3),
            c54 = makeCoordinate(5, 4), c55 = makeCoordinate(5, 5),
            c56 = makeCoordinate(5, 6), c57 = makeCoordinate(5, 7),
            c58 = makeCoordinate(5, 8), c59 = makeCoordinate(5, 9),
            c61 = makeCoordinate(6, 1), c62 = makeCoordinate(6, 2),
            c63 = makeCoordinate(6, 3), c64 = makeCoordinate(6, 4),
            c65 = makeCoordinate(6, 5), c66 = makeCoordinate(6, 6),
            c67 = makeCoordinate(6, 7), c68 = makeCoordinate(6, 8),
            c69 = makeCoordinate(6, 9), c71 = makeCoordinate(7, 1),
            c72 = makeCoordinate(7, 2), c73 = makeCoordinate(7, 3),
            c74 = makeCoordinate(7, 4), c75 = makeCoordinate(7, 5),
            c76 = makeCoordinate(7, 6), c77 = makeCoordinate(7, 7),
            c78 = makeCoordinate(7, 8), c79 = makeCoordinate(7, 9),
            c81 = makeCoordinate(8, 1), c82 = makeCoordinate(8, 2),
            c83 = makeCoordinate(8, 3), c84 = makeCoordinate(8, 4),
            c85 = makeCoordinate(8, 5), c86 = makeCoordinate(8, 6),
            c87 = makeCoordinate(8, 7), c88 = makeCoordinate(8, 8),
            c89 = makeCoordinate(8, 9), c91 = makeCoordinate(9, 1),
            c92 = makeCoordinate(9, 2), c93 = makeCoordinate(9, 3),
            c94 = makeCoordinate(9, 4), c95 = makeCoordinate(9, 5),
            c96 = makeCoordinate(9, 6), c97 = makeCoordinate(9, 7),
            c98 = makeCoordinate(9, 8), c99 = makeCoordinate(9, 9),
            c101 = makeCoordinate(10, 1), c102 = makeCoordinate(10, 2),
            c103 = makeCoordinate(10, 3), c104 = makeCoordinate(10, 4),
            c105 = makeCoordinate(10, 5), c106 = makeCoordinate(10, 6),
            c107 = makeCoordinate(10, 7), c108 = makeCoordinate(10, 8),
            c109 = makeCoordinate(10, 9);
    
    private static XiangqiPiece redChariot = makePiece(CHARIOT, RED),
    redHorse = makePiece(HORSE, RED),
    redElephant = makePiece(ELEPHANT, RED),
    redAdvior = makePiece(ADVISOR, RED),
    redGeneral = makePiece(GENERAL, RED),
    redCannon = makePiece(CANNON, RED),
    redSoldier = makePiece(SOLDIER, RED),
    blackChariot = makePiece(CHARIOT, BLACK),
    blackHorse = makePiece(HORSE, BLACK),
    blackElephant = makePiece(ELEPHANT, BLACK),
    blackAdvior = makePiece(ADVISOR, BLACK),
    blackGeneral = makePiece(GENERAL, BLACK),
    blackCannon = makePiece(CANNON, BLACK),
    blackSoldier = makePiece(SOLDIER, BLACK);
    
    /**
     * This method create player red's pieces and put them on to board
     *
     * @param pieces The board
     */
    @Override
    public void setupRedPieces(HashMap<XiangqiCoordinate, XiangqiPiece> pieces) {
        pieces.put(c11, redChariot);
        pieces.put(c12, redHorse);
        pieces.put(c13, redElephant);
        pieces.put(c14, redAdvior);
        pieces.put(c15, redGeneral);
        pieces.put(c16, redAdvior);
        pieces.put(c17, redElephant);
        pieces.put(c18, redHorse);
        pieces.put(c19, redChariot);
        pieces.put(c32, redCannon);
        pieces.put(c38, redCannon);
        pieces.put(c41, redSoldier);
        pieces.put(c43, redSoldier);
        pieces.put(c45, redSoldier);
        pieces.put(c47, redSoldier);
        pieces.put(c49, redSoldier);
    }
    
    /**
     * This method create player black's pieces and put them on to board
     *
     * @param pieces The board
     */
    @Override
    public void setupBlackPieces(HashMap<XiangqiCoordinate, XiangqiPiece> pieces) {
        pieces.put(c101, blackChariot);
        pieces.put(c102, blackHorse);
        pieces.put(c103, blackElephant);
        pieces.put(c104, blackAdvior);
        pieces.put(c105, blackGeneral);
        pieces.put(c106, blackAdvior);
        pieces.put(c107, blackElephant);
        pieces.put(c108, blackHorse);
        pieces.put(c109, blackChariot);
        pieces.put(c82, blackCannon);
        pieces.put(c88, blackCannon);
        pieces.put(c71, blackSoldier);
        pieces.put(c73, blackSoldier);
        pieces.put(c75, blackSoldier);
        pieces.put(c77, blackSoldier);
        pieces.put(c79, blackSoldier);
    }
    
    private static XiangqiCoordinate makeCoordinate(int rank, int file) {
        return CoordinateImpl.makeCoordinate(rank, file);
    }
    
    private static XiangqiPiece makePiece(XiangqiPieceType pieceType, XiangqiColor color) {
        return XiangqiPieceImpl.makePiece(pieceType, color);
    }
}