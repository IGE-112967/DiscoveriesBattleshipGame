package iscteiul.ista.battleship;

/**
 * Represents a Caravel ship in the Discoveries Battleship game.
 * <p>
 * A Caravel occupies two consecutive cells on the board and can be placed
 * either vertically (NORTH/SOUTH) or horizontally (EAST/WEST).
 * </p>
 * 
 * Size: 2 cells
 */
public class Caravel extends Ship {

    /** Size of the Caravel (number of occupied cells). */
    private static final Integer SIZE = 2;

    /** Display name of the ship. */
    private static final String NAME = "Caravela";

    /**
     * Constructs a Caravel ship with a given orientation and starting position.
     * <p>
     * The ship occupies two consecutive positions depending on its bearing:
     * <ul>
     *   <li>NORTH/SOUTH → vertical placement</li>
     *   <li>EAST/WEST → horizontal placement</li>
     * </ul>
     *
     * @param bearing the direction/orientation of the ship
     * @param pos the starting (upper-left) position of the ship
     * @throws NullPointerException if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos)
            throws NullPointerException, IllegalArgumentException {

        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }
    }

    /**
     * Returns the size of the Caravel.
     *
     * @return the number of board cells occupied by this ship (always 2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
