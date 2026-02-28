package iscteiul.ista.battleship;

/**
 * Represents a Frigate (Fragata) ship in the Discoveries Battleship game.
 * <p>
 * The Frigate has a size of 4 squares on the game board.
 * </p>
 *
 * @see Ship
 */
public class Frigate extends Ship {
    private static final Integer SIZE = 4;
    private static final String NAME = "Fragata";

    /**
     * Constructs a new Frigate instance with a specific bearing and initial position.
     * Automatically calculates the 4 grid positions occupied by the ship based on its orientation.
     *
     * @param bearing the orientation of the ship (e.g., NORTH, SOUTH, EAST, WEST)
     * @param pos     the initial position (bow/stern coordinates) of the ship on the board
     * @throws IllegalArgumentException if the provided bearing is invalid or unrecognized
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the frigate");
        }
    }

    /**
     * Gets the dimension (size) of the Frigate.
     *
     * @return the number of squares the ship occupies on the board (in this case, 4)
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}