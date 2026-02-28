package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma posição específica no tabuleiro do jogo de Batalha Naval.
 * Esta classe gere as coordenadas, o estado de ocupação por um navio
 * e o estado de ter sido atingida por um disparo.
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Construtor da classe Position.
     *
     * @param row    A linha da grelha (coordenada vertical).
     * @param column A coluna da grelha (coordenada horizontal).
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Retorna a linha da posição.
     *
     * @return O índice da linha.
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Retorna a coluna da posição.
     *
     * @return O índice da coluna.
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Calcula o código hash para a posição, baseando-se nas coordenadas e estados.
     *
     * @return O valor do hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Verifica se dois objetos Position são iguais com base nas coordenadas.
     *
     * @param otherPosition O objeto a comparar.
     * @return true se forem iguais, false caso contrário.
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
     * Verifica se esta posição é adjacente a outra posição (na horizontal, vertical ou diagonal).
     *
     * @param other A outra posição para comparação.
     * @return true se forem adjacentes, false caso contrário.
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
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
     * Verifica se a posição está ocupada por um navio.
     *
     * @return true se estiver ocupada, false caso contrário.
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se a posição já foi atingida por um disparo.
     *
     * @return true se já foi atingida, false caso contrário.
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Representação textual da posição.
     *
     * @return String formatada com a linha e coluna.
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}