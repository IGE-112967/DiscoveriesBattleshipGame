package iscteiul.ista.battleship;

/**
 * Represents a Carrack (Nau) ship in the Discoveries Battleship game.
 * <p>
 * The Carrack has a size of 3 squares on the game board.
 * </p>
 *
 * @see Ship
 */
public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Constructs a new Carrack instance with a specific bearing and initial position.
     * Automatically calculates all the grid positions occupied by the ship based on its size (3).
     *
     * @param bearing the orientation of the ship on the grid (e.g., NORTH, SOUTH for vertical; EAST, WEST for horizontal)
     * @param pos the initial position (bow/stern coordinates) of the ship on the board
     * @throws IllegalArgumentException if the provided bearing is invalid or unrecognized
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Obtém a dimensão (tamanho) da Nau.
     *
     * @return o número de quadrados que o navio ocupa no tabuleiro (neste caso, 3)
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}