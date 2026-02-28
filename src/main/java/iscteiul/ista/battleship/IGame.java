package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define as operações principais para a gestão de uma partida de BattleShip.
 * Esta interface serve como o núcleo da lógica do jogo, permitindo efetuar disparos,
 * consultar estatísticas de combate e visualizar o estado dos tabuleiros.
 * * @author fba
 * @version 1.0
 */
public interface IGame {

    /**
     * Efetua um disparo numa posição específica do tabuleiro.
     * O método deve validar se o tiro atinge algum navio da frota e atualizar
     * as estatísticas de acertos (hits) e afundamentos (sinks).
     * * @param pos A posição ({@link IPosition}) onde o jogador pretende disparar.
     * @return O objeto {@link IShip} que foi afundado como resultado deste tiro; 
     * {@code null} se o tiro falhou, apenas atingiu sem afundar, ou se foi inválido/repetido.
     */
    IShip fire(IPosition pos);

    /**
     * Devolve uma lista com todas as posições onde foram efetuados disparos válidos.
     * * @return Uma {@link List} de objetos {@link IPosition}.
     */
    List<IPosition> getShots();

    /**
     * Devolve o número total de disparos efetuados em coordenadas que já tinham sido alvo de tiros anteriormente.
     * * @return O contador de tiros repetidos.
     */
    int getRepeatedShots();

    /**
     * Devolve o número total de disparos efetuados para fora dos limites do tabuleiro de jogo.
     * * @return O contador de tiros inválidos.
     */
    int getInvalidShots();

    /**
     * Devolve o número total de disparos que atingiram com sucesso partes de navios.
     * * @return O contador de acertos (hits).
     */
    int getHits();

    /**
     * Devolve o número de navios da frota que já foram completamente afundados.
     * * @return O total de navios destruídos.
     */
    int getSunkShips();

    /**
     * Devolve o número de navios da frota que ainda têm pelo menos uma parte flutuante.
     * * @return O total de navios restantes no jogo.
     */
    int getRemainingShips();

    /**
     * Apresenta visualmente (normalmente via consola) o tabuleiro contendo apenas 
     * as posições onde foram efetuados disparos válidos.
     */
    void printValidShots();

    /**
     * Apresenta visualmente o tabuleiro com a localização atual de todos os navios da frota,
     * independentemente de terem sido atingidos ou não.
     */
    void printFleet();
}
