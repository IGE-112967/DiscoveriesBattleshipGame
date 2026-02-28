package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação principal da interface {@link IGame} para o jogo BattleShip.
 * Esta classe gere o estado de uma partida, controlando a frota, os tiros efetuados,
 * e a contabilização de estatísticas como acertos, afundamentos e jogadas inválidas.
 * * @author fba
 * @version 1.0
 */
public class Game implements IGame {
    
    /**
     * A frota de navios associada a este jogo.
     */
    private IFleet fleet;
    
    /**
     * Lista de posições onde foram efetuados tiros válidos e não repetidos.
     */
    private List<IPosition> shots;

    /** Contadores de estatísticas do jogo. */
    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    /**
     * Construtor da classe Game. 
     * Inicializa as listas de tiros e os contadores de estatísticas.
     * * @param fleet A frota ({@link IFleet}) que será utilizada nesta partida.
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        countHits = 0; // Inicializado para evitar NullPointer em operações de incremento
        countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Processa um tiro numa determinada posição do tabuleiro.
     * Verifica se o tiro é válido, se é repetido e se atingiu algum navio.
     * Se um navio for atingido e afundado, o navio é retornado.
     * * @param pos A posição ({@link IPosition}) onde o jogador pretende disparar.
     * @return O objeto {@link IShip} se o tiro afundar um navio; {@code null} caso contrário 
     * (se falhar, apenas atingir sem afundar, ou for tiro inválido/repetido).
     * @see IGame#fire(IPosition)
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Devolve a lista de todas as posições onde foram efetuados disparos válidos.
     * * @return Uma lista de objetos {@link IPosition}.
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Devolve o número total de tiros efetuados em coordenadas onde já se tinha disparado anteriormente.
     * * @return O número de tiros repetidos.
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Devolve o número de tiros disparados para fora dos limites do tabuleiro.
     * * @return O número de tiros inválidos.
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Devolve o número total de tiros que atingiram navios.
     * * @return O número de acertos (hits).
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Devolve o número total de navios que já foram completamente afundados.
     * * @return O número de navios afundados.
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Calcula quantos navios da frota ainda permanecem a flutuar.
     * * @return O número de navios restantes.
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Valida se uma posição está dentro dos limites definidos para o tabuleiro.
     * * @param pos A posição a validar.
     * @return {@code true} se a posição estiver dentro do tabuleiro; {@code false} caso contrário.
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() < Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() < Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se já foi efetuado um disparo para a posição indicada.
     * * @param pos A posição a verificar.
     * @return {@code true} se a posição já constar na lista de tiros; {@code false} caso contrário.
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Método auxiliar para desenhar o tabuleiro na consola.
     * * @param positions Lista de posições a marcar no tabuleiro.
     * @param marker O carácter (char) que será usado para representar as posições indicadas.
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Imprime no terminal o tabuleiro mostrando todos os tiros válidos efetuados até ao momento (marcados com 'X').
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime no terminal o tabuleiro mostrando a localização atual de todos os navios da frota (marcados com '#').
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}
