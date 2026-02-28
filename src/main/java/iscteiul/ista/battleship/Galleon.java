package iscteiul.ista.battleship;

/**
 * Representa um Galeão (Galleon) no jogo BattleShip.
 * O Galeão é um navio de grande porte com um tamanho fixo de 5 unidades.
 * Ao contrário de navios lineares, o Galeão ocupa uma estrutura geométrica específica 
 * que se estende por múltiplas linhas e colunas, dependendo da sua orientação.
 * * @author [O Teu Nome/Grupo]
 * @version 1.0
 */
public class Galleon extends Ship {
    
    /**
     * Tamanho fixo do Galeão (5 unidades).
     */
    private static final Integer SIZE = 5;
    
    /**
     * Nome identificador do tipo de navio.
     */
    private static final String NAME = "Galeao";

    /**
     * Constrói um novo Galeão com uma orientação e posição inicial específicas.
     * O método calcula as 5 posições ocupadas pelo navio com base no 
     * {@code bearing} fornecido.
     * * @param bearing A orientação do navio (NORTH, SOUTH, EAST, WEST).
     * @param pos A posição de referência (âncora) para o posicionamento.
     * @throws IllegalArgumentException Se a orientação for inválida.
     * @throws NullPointerException Se a orientação (bearing) for nula.
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
     * Devolve o tamanho fixo do Galeão.
     * * @return O número de células ocupadas (5).
     * @see iscteiul.ista.battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as posições do navio quando orientado para Norte.
     * @param pos Posição inicial.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as posições do navio quando orientado para Sul.
     * @param pos Posição inicial.
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
     * Preenche as posições do navio quando orientado para Este.
     * @param pos Posição inicial.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as posições do navio quando orientado para Oeste.
     * @param pos Posição inicial.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
