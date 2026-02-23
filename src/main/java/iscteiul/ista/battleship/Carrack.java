/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Nau (Carrack) no jogo da Batalha Naval dos Descobrimentos.
 * <p>
 * A Nau tem uma dimensão de 3 quadrados na grelha do jogo.
 * </p>
 * * @see Ship
 */
public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova instância de uma Nau (Carrack) com uma orientação e posição inicial específicas.
     * Calcula automaticamente todas as posições ocupadas pelo navio na grelha com base na sua dimensão (3).
     *
     * @param bearing a orientação do navio na grelha (ex: NORTH, SOUTH para vertical; EAST, WEST para horizontal)
     * @param pos a posição inicial (coordenadas de proa/popa) do navio no tabuleiro
     * @throws IllegalArgumentException se a orientação fornecida for inválida ou não reconhecida
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
