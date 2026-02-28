package iscteiul.ista.battleship;

/**
 * Interface que define as operações de uma posição (célula) no tabuleiro de BattleShip.
 * Cada posição é definida por coordenadas (linha e coluna) e mantém o rasto do seu estado
 * (se está ocupada por um navio e se já foi alvo de um tiro).
 * * @author fba
 * @version 1.0
 */
public interface IPosition {

    /**
     * Devolve o índice da linha desta posição.
     * @return O número da linha.
     */
    int getRow();

    /**
     * Devolve o índice da coluna desta posição.
     * @return O número da coluna.
     */
    int getColumn();

    /**
     * Compara esta posição com outro objeto para verificar a igualdade de coordenadas.
     * @param other O objeto a comparar.
     * @return {@code true} se as coordenadas forem iguais; {@code false} caso contrário.
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente (vizinha) a outra posição fornecida.
     * @param other A outra posição para verificar a adjacência.
     * @return {@code true} se forem adjacentes; {@code false} caso contrário.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como ocupada por um navio.
     */
    void occupy();

    /**
     * Regista que esta posição foi alvo de um disparo.
     */
    void shoot();

    /**
     * Indica se a posição está ocupada por um navio.
     * @return {@code true} se houver um navio nesta posição; {@code false} caso contrário.
     */
    boolean isOccupied();

    /**
     * Indica se esta posição já foi atingida por um tiro.
     * @return {@code true} se já foi disparado sobre esta posição; {@code false} caso contrário.
     */
    boolean isHit();
}