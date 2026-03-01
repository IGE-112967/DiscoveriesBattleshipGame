package iscteiul.ista.battleship;

/**
 * Represents a Galleon ship in the Discoveries Battleship game.
 * <p>
 * The Galleon is a large ship with a fixed size of 5 units.
 * Unlike linear ships, the Galleon occupies a specific geometric structure
 * that extends across multiple rows and columns, depending on its orientation.
 * </p>
 *
 * @version 1.0
 */
public class Galleon extends Ship {

    /**
     * Fixed size of the Galleon (5 units).
     */
    private static final Integer SIZE = 5;

    /**
     * Identifier name of the ship type.
     */
    private static final String NAME = "Galeao";

    /**
     * Constructs a new Galleon with a specific orientation and initial position.
     * The method calculates the 5 positions occupied by the ship based on the
     * provided {@code bearing}.
     *
     * @param bearing The orientation of the ship (NORTH, SOUTH, EAST, WEST).
     * @param pos     The reference position (anchor) for placement.
     * @throws IllegalArgumentException If the bearing is invalid.
     * @throws NullPointerException     If the bearing is null.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the fixed size of the Galleon.
     *
     * @return The number of occupied cells (5).
     * @see Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills the ship positions when oriented towards North.
     *
     * @param pos Initial position.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills the ship positions when oriented towards South.
     *
     * @param pos Initial position.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills the ship positions when oriented towards East.
     *
     * @param pos Initial position.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills the ship positions when oriented towards West.
     *
     * @param pos Initial position.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}