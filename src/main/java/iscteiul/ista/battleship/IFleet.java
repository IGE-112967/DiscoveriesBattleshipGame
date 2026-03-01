package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o comportamento de uma frota (Fleet) no jogo BattleShip.
 * Uma frota é responsável por gerir um conjunto de navios num tabuleiro de jogo,
 * permitindo a adição, consulta e verificação de estado dos navios.
 * * @author fba
 * @version 1.0
 */
public interface IFleet {
    
    /**
     * Tamanho padrão da lateral do tabuleiro (10x10).
     */
    Integer BOARD_SIZE = 10;
    
    /**
     * Número máximo de navios permitidos na frota.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Devolve a lista de todos os navios que compõem a frota.
     * * @return Uma {@link List} contendo todos os objetos {@link IShip} da frota.
     */
    List<IShip> getShips();

    /**
     * Tenta adicionar um novo navio à frota.
     * A implementação deve verificar se o navio pode ser colocado (ex: sem sobreposições
     * ou limites do tabuleiro).
     * * @param s O navio ({@link IShip}) a ser adicionado.
     * @return {@code true} se o navio foi adicionado com sucesso; 
     * {@code false} caso contrário (ex: frota cheia ou posição inválida).
     */
    boolean addShip(IShip s);

    /**
     * Filtra e devolve os navios da frota que pertencem a uma determinada categoria.
     * Exemplo de categorias: "Galeao", "Fragata", "Bergantim".
     * * @param category String com o nome da categoria pretendida.
     * @return Uma lista de navios que correspondem à categoria indicada.
     */
    List<IShip> getShipsLike(String category);

    /**
     * Devolve uma lista contendo apenas os navios que ainda não foram afundados.
     * * @return Lista de navios com estado "a flutuar".
     */
    List<IShip> getFloatingShips();

    /**
     * Verifica se existe algum navio a ocupar uma determinada posição no tabuleiro.
     * * @param pos A posição ({@link IPosition}) a verificar.
     * @return O objeto {@link IShip} que ocupa a posição, ou {@code null} se a posição estiver vazia.
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime na consola o estado atual da frota para fins de diagnóstico ou visualização,
     * listando os navios e se estes já foram ou não afundados.
     */
    void printStatus();
}
