package iscteiul.ista.battleship;

/**
 * Representa uma Fragata (Frigate) no jogo BattleShip.
 * A Fragata é um tipo de navio com um tamanho fixo de 4 unidades,
 * ocupando posições consecutivas no tabuleiro baseadas na sua orientação.
 * * @author [O Teu Nome/Grupo]
 * @version 1.0
 */
public class Frigate extends Ship {
    
    /**
     * Tamanho fixo da Fragata (4 unidades).
     */
    private static final Integer SIZE = 4;
    
    /**
     * Nome identificador do tipo de navio.
     */
    private static final String NAME = "Fragata";

    /**
     * Constrói uma nova Fragata com uma orientação e posição inicial específicas.
     * Dependendo da orientação (bearing), as posições ocupadas pelo navio são 
     * calculadas e adicionadas à lista de posições do navio.
     * * @param bearing A orientação do navio (NORTH, SOUTH, EAST, WEST).
     * @param pos A posição inicial (âncora) a partir da qual o navio se estende.
     * @throws IllegalArgumentException Se a orientação fornecida for inválida ou nula.
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        
        if (bearing == null) {
            throw new IllegalArgumentException("ERROR! bearing cannot be null");
        }

        switch (bearing) {
            case NORTH:
            case SOUTH:
                // Estende o navio verticalmente
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                // Estende o navio horizontalmente
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the frigate");
        }
    }

    /**
     * Devolve o tamanho fixo da Fragata.
     * * @return O número de células que o navio ocupa (4).
     * @see iscteiul.ista.battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
