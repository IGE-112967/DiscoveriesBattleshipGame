/**
 * Representa uma posição no tabuleiro do jogo Battleship.
 * <p>
 * Cada posição é identificada por uma linha e uma coluna,
 * podendo estar ocupada por um navio e/ou já ter sido atingida por um disparo.
 * </p>
 *
 * Implementa a interface {@link IPosition}.
 */
package iscteiul.ista.battleship;

import java.util.Objects;

public class Position implements IPosition {

    /** Linha da posição no tabuleiro. */
    private int row;

    /** Coluna da posição no tabuleiro. */
    private int column;

    /** Indica se a posição está ocupada por um navio. */
    private boolean isOccupied;

    /** Indica se a posição já foi atingida por um disparo. */
    private boolean isHit;

    /**
     * Constrói uma nova posição com a linha e coluna especificadas.
     * Inicialmente, a posição não está ocupada nem atingida.
     *
     * @param row    a linha da posição
     * @param column a coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Devolve a linha da posição.
     *
     * @return o número da linha
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Devolve a coluna da posição.
     *
     * @return o número da coluna
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Gera o código hash da posição.
     *
     * @return o valor de hash calculado com base nos atributos da posição
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outro objeto.
     * Duas posições são consideradas iguais se tiverem a mesma
     * linha e coluna.
     *
     * @param otherPosition o objeto a comparar
     * @return {@code true} se as posições tiverem a mesma linha e coluna,
     *         {@code false} caso contrário
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é adjacente a outra posição.
     * Considera adjacência horizontal, vertical e diagonal.
     *
     * @param other a outra posição
     * @return {@code true} se for adjacente, {@code false} caso contrário
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 &&
                Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca a posição como ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marca a posição como atingida por um disparo.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indica se a posição está ocupada por um navio.
     *
     * @return {@code true} se estiver ocupada, {@code false} caso contrário
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indica se a posição já foi atingida.
     *
     * @return {@code true} se já tiver sido atingida, {@code false} caso contrário
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Devolve uma representação textual da posição.
     *
     * @return string no formato "Linha = X Coluna = Y"
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}