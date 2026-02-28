package iscteiul.ista.battleship;

/**
 * Represents a Barge (Barca) ship in the Discoveries Battleship game.
 * <p>
 * The Barge is the smallest ship, occupying only 1 square on the game board.
 * </p>
 *
 * @see Ship
 */
public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

    /**
     * Constructs a new Barge instance.
     * Since the Barge size is 1, it occupies a single position defined by 'pos'.
     *
     * @param bearing the orientation of the ship (less relevant for size 1, but required by the hierarchy)
     * @param pos     the position (coordinate) of the barge on the board
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Gets the dimension (size) of the Barge.
     *
     * @return the number of squares the ship occupies on the board (in this case, 1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}