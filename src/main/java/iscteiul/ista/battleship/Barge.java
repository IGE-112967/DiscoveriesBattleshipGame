package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Discoveries Battleship game.
 * <p>
 * A Barge is the smallest ship in the fleet and occupies a single
 * position on the board.
 * </p>
 * 
 * Size: 1 cell
 */
public class Barge extends Ship {

    /** Size of the Barge ship (number of occupied cells). */
    private static final Integer SIZE = 1;

    /** Display name of the ship. */
    private static final String NAME = "Barca";

    /**
     * Constructs a Barge ship.
     *
     * @param bearing the orientation of the ship (horizontal or vertical)
     * @param pos the initial (upper-left) position of the ship on the board
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the Barge.
     *
     * @return the number of board cells occupied by this ship (always 1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
