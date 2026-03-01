/**
 * Representa uma frota de navios no jogo Battleship.
 * <p>
 * A classe Fleet é responsável por armazenar os navios,
 * validar a sua colocação no tabuleiro e fornecer
 * operações de consulta sobre o seu estado.
 * </p>
 *
 * A frota garante que:
 * <ul>
 *     <li>Os navios são colocados dentro dos limites do tabuleiro</li>
 *     <li>Não existem colisões ou proximidade inválida entre navios</li>
 *     <li>Não é excedido o tamanho máximo permitido da frota</li>
 * </ul>
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

public class Fleet implements IFleet {

    /**
     * Imprime todos os navios presentes na lista fornecida.
     *
     * @param ships lista de navios a imprimir
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /**
     * Lista interna que contém todos os navios da frota.
     */
    private List<IShip> ships;

    /**
     * Construtor que cria uma frota vazia.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Devolve todos os navios atualmente existentes na frota.
     *
     * @return lista de navios da frota
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota caso:
     * <ul>
     *     <li>Não tenha sido atingido o tamanho máximo da frota</li>
     *     <li>O navio esteja dentro dos limites do tabuleiro</li>
     *     <li>Não exista risco de colisão ou proximidade inválida</li>
     * </ul>
     *
     * @param s navio a adicionar
     * @return {@code true} se o navio foi adicionado com sucesso,
     *         {@code false} caso contrário
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Devolve todos os navios pertencentes a uma determinada categoria.
     *
     * @param category categoria pretendida
     * @return lista de navios da categoria indicada
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Devolve todos os navios que ainda se encontram a flutuar
     * (ou seja, que não foram totalmente destruídos).
     *
     * @return lista de navios ainda ativos
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Devolve o navio que ocupa uma determinada posição do tabuleiro.
     *
     * @param pos posição a verificar
     * @return o navio que ocupa essa posição ou {@code null} se não existir
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está completamente dentro dos limites do tabuleiro.
     *
     * @param s navio a validar
     * @return {@code true} se o navio estiver dentro do tabuleiro,
     *         {@code false} caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 &&
                s.getRightMostPos() <= BOARD_SIZE - 1 &&
                s.getTopMostPos() >= 0 &&
                s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se existe risco de colisão ou proximidade inválida
     * entre o navio fornecido e os navios já existentes na frota.
     *
     * @param s navio a verificar
     * @return {@code true} se existir risco de colisão,
     *         {@code false} caso contrário
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Imprime o estado completo da frota, incluindo:
     * <ul>
     *     <li>Todos os navios</li>
     *     <li>Navios ainda a flutuar</li>
     *     <li>Navios agrupados por categorias predefinidas</li>
     * </ul>
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios pertencentes a uma determinada categoria.
     *
     * @param category categoria dos navios a imprimir (não deve ser nula)
     */
    public void printShipsByCategory(String category) {
        assert category != null;
        printShips(getShipsLike(category));
    }

    /**
     * Imprime todos os navios que ainda se encontram a flutuar.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios da frota.
     */
    void printAllShips() {
        printShips(ships);
    }
}
