package xiangqi.studentyliu17.version.common;

import xiangqi.common.XiangqiCoordinate;

/**
 * This class implement XiangqiCoordinte interface and provide coordinate utilities
 *
 * @version Jan 28, 2017
 */
public class CoordinateImpl implements XiangqiCoordinate {
    private int rank; // The rank of coordinate
    private int file; // The file of coordinate
    
    /**
     * The constructor of CoordinateImpl
     *
     * @param rank The rank
     * @param file The file
     */
    private CoordinateImpl(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }
    
    /**
     * Creation method for coordinates
     *
     * @param rank The rank of the coordinate
     * @param file The file of the coordinate
     *
     * @return The CoordinateImpl instance
     */
    public static CoordinateImpl makeCoordinate(int rank, int file) {
        return new CoordinateImpl(rank, file);
    }
    
    /**
     * Check whether the coordinates from a rectangle with given width and height
     *
     * @param coordinate The other coordinate
     * @param width The width of expected rectangle
     * @param height The height of expected rectangle
     *
     * @return true if coordinates from a rectangle with given width and height, false otherwise
     */
    public boolean isVertexOfRectangle(CoordinateImpl coordinate, int width, int height) {
        int otherRank = coordinate.getRank();
        int otherFile = coordinate.getFile();
        int rankDiff = Math.abs(rank - otherRank);
        int fileDiff = Math.abs(file - otherFile);
        
        return (rankDiff == width && fileDiff == height) || (rankDiff == height && fileDiff ==
                                                                                   width);
    }
    
    /**
     * Get the orthogonal coordinate in front of source coordinate in direction of movement
     *
     * @param coordinate The destination coordinate
     *
     * @return the orthogonal coordinate in front of source coordinate in direction of movement
     */
    public CoordinateImpl getOrthogonalCoordinateInMoveDirection(CoordinateImpl coordinate) {
        int otherRank = coordinate.getRank();
        int otherFile = coordinate.getFile();
        int rankDiff = rank - otherRank;
        int fileDiff = file - otherFile;
        
        if (Math.abs(rankDiff) > Math.abs(fileDiff))
            return rankDiff > 0 ?
                   makeCoordinate(otherRank + 1, otherFile) :
                   makeCoordinate(otherRank - 1, otherFile);
        else return fileDiff > 0 ?
                    makeCoordinate(otherRank, otherFile + 1) :
                    makeCoordinate(otherRank, otherFile - 1);
    }
    
    /**
     * Check whether the other coordinate is orthogonal to this coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return true if the other coordinate is orthogonal to this coordinate, false otherwise
     */
    public boolean isOrthogonal(CoordinateImpl coordinate) {
        return isHorizontal(coordinate) || isVertical(coordinate);
    }
    
    /**
     * Check whether the other coordinate is diagonal to this coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return true if the other coordinate is diagonal to this coordinate, false otherwise
     */
    public boolean isDiagonal(CoordinateImpl coordinate) {
        return Math.abs(coordinate.rank - rank) == Math.abs(coordinate.file - file);
    }
    
    /**
     * Check whether the other coordinate is vertical to this coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return true if the other coordinate is vertical to this coordinate, false otherwise
     */
    public boolean isVertical(CoordinateImpl coordinate) {
        return coordinate.file == file;
    }
    
    /**
     * Check whether the other coordinate is horizontal to this coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return true is the other coordinate is horizontal to this coordinate, false otherwise
     */
    public boolean isHorizontal(CoordinateImpl coordinate) { return coordinate.rank == rank;}
    
    /**
     * Return distance between this and the other coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return distance between this and the other coordinate
     */
    public int distanceTo(CoordinateImpl coordinate) {
        return Math.abs(coordinate.rank - rank) + Math.abs(coordinate.file - file);
    }
    
    /**
     * Return true if this coordinate is in front of other coordinate
     *
     * @param coordinate The other coordinate
     *
     * @return true if this coordinate is in front of other coordinate, false otherwise
     */
    public boolean isInFrontOf(CoordinateImpl coordinate) {
        return rank > coordinate.getRank();
    }
    
    /**
     * Check whether rank and file is in the given range
     *
     * @param fromRank The lower bound of rank
     * @param toRank   The upper bound of rank
     * @param fromFile The lower bound of file
     * @param toFile   The upper bound of file
     *
     * @return
     */
    public boolean isInRange(int fromRank, int toRank, int fromFile, int toFile) {
        return fromRank <= rank && rank <= toRank && fromFile <= file && file <= toFile;
    }
    
    /**
     * The rank is the horizontal row number. It is an integer in the inclusive range of 1-10.
     * The rank is always from the specific player's point of view. So Red's rank 1 is
     * Black's rank 10.
     *
     * @return the rank of the location on the board
     */
    @Override
    public int getRank() {
        return rank;
    }
    
    /**
     * The file is the vertical column number. It is an integer in the inclusive range of 1-9.
     * The file is always from the specific player's point of view. So Red's left Cannon is on
     * Red's rank 2 and Black's rank 8.
     *
     * @return the file of the coordinate on the board
     */
    @Override
    public int getFile() {
        return file;
    }
    
    /**
     * Compare whether two coordinates are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof XiangqiCoordinate)) return false;
        XiangqiCoordinate coordinate = (XiangqiCoordinate) obj;
        return coordinate.getRank() == rank && coordinate.getFile() == file;
    }
    
    /**
     * Get the hash code of the coordinate
     */
    @Override
    public int hashCode() {
        return rank + file;
    }
}
