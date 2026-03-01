package iscteiul.ista.battleship;

/**
 * Represents the cardinal points (directions) used for ship orientation and navigation in the game.
 * <p>
 * This enum maps directions to specific characters:
 * <ul>
 * <li>NORTH -> 'n'</li>
 * <li>SOUTH -> 's'</li>
 * <li>EAST -> 'e'</li>
 * <li>WEST -> 'o' (derived from the Portuguese "Oeste")</li>
 * </ul>
 * </p>
 *
 * @author fba
 */
public enum Compass {
    /** Direction North ('n'). */
    NORTH('n'),
    /** Direction South ('s'). */
    SOUTH('s'),
    /** Direction East ('e'). */
    EAST('e'),
    /** Direction West ('o' - from "Oeste"). */
    WEST('o'),
    /** Unknown or invalid direction ('u'). */
    UNKNOWN('u');

    private final char c;

    /**
     * Constructor associating a character code with the direction.
     *
     * @param c the character representation of the direction
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Gets the character associated with this direction.
     *
     * @return the char code (e.g., 'n', 's', 'e', 'o')
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the string representation of the direction's character.
     *
     * @return a string containing the direction character
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character into the corresponding Compass enum constant.
     * <p>
     * Accepts 'n', 's', 'e', 'o'.
     * Returns {@link #UNKNOWN} if the character does not match any valid direction.
     * </p>
     *
     * @param ch the character to convert
     * @return the corresponding Compass constant, or UNKNOWN
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}