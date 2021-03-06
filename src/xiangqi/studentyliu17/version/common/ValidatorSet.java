package xiangqi.studentyliu17.version.common;

import xiangqi.common.XiangqiPieceType;

import java.util.*;

/**
 * This class keep list of piece validators
 */
public abstract class ValidatorSet{
    private Hashtable<XiangqiPieceType, List<Validator>> validatorSet; // Keep set of validators
    // for xiangqi pieces
    
    /**
     * Initialize ValidatorSet
     */
    public void initialize() {
        validatorSet = new Hashtable<>();
        setupValidators();
    }
    
    /**
     * This method create and put pieces on the board
     */
    public abstract void setupValidators();
    
    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this map contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     *
     * @return <tt>true</tt> if this map contains a mapping for the specified
     * key
     */
    public boolean containsKey(Object key) {
        return validatorSet.containsKey(key);
    }
    
    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>If this map permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the map
     * contains no mapping for the key; it's also possible that the map
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param key the key whose associated value is to be returned
     *
     * @return the value to which the specified key is mapped, or
     * {@code null} if this map contains no mapping for the key
     */
    public List<Validator> get(Object key) {
        return validatorSet.get(key);
    }
    
    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A map
     * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     *
     * @return the previous value associated with <tt>key</tt>, or
     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * (A <tt>null</tt> return can also indicate that the map
     * previously associated <tt>null</tt> with <tt>key</tt>,
     * if the implementation supports <tt>null</tt> values.)
     */
    public List<Validator> put(XiangqiPieceType key, List<Validator> value) {
        return validatorSet.put(key, value);
    }
    
    /**
     * Add a collection of validators for a xiangqi piece type
     *
     * @param pieceType The piece validators belong to
     * @param validators The validators of the given xiangqi piece type
     */
    public void addValidators(XiangqiPieceType pieceType, List<Validator> validators) {
        put(pieceType, validators);
    }
}
