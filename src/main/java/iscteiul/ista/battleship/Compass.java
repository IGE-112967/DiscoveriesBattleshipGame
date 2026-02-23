package iscteiul.ista.battleship;

/**
 * Representa os pontos cardeais usados para definir a orientação (direção) 
 * dos navios na grelha do jogo da Batalha Naval.
 * <p>
 * As direções são mapeadas internamente por caracteres, considerando as iniciais 
 * adaptadas para o contexto do jogo (ex: 'n' para Norte, 's' para Sul, 'e' para Este/East, 'o' para Oeste/West).
 * </p>
 * * @author fba
 */
public enum Compass {

    /** Aponta para o Norte (cima na grelha). Representado por 'n'. */
    NORTH('n'), 
    
    /** Aponta para o Sul (baixo na grelha). Representado por 's'. */
    SOUTH('s'), 
    
    /** Aponta para o Este (direita na grelha). Representado por 'e'. */
    EAST('e'), 
    
    /** Aponta para o Oeste (esquerda na grelha). Representado por 'o'. */
    WEST('o'), 
    
    /** Direção desconhecida ou inválida. Representado por 'u' (unknown). */
    UNKNOWN('u');

    private final char c;

    /**
     * Construtor do enumerado. Associa um caractere específico à direção.
     * * @param c o caractere que representa a direção correspondente
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Obtém o caractere identificador da direção.
     * * @return o caractere associado (ex: 'n', 's', 'e', 'o', 'u')
     */
    public char getDirection() {
        return c;
    }

    /**
     * Retorna a representação textual do caractere da direção.
     * * @return uma string contendo o caractere representativo
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um caractere na sua respetiva constante {@link Compass}.
     * * @param ch o caractere a converter (espera-se 'n', 's', 'e', ou 'o')
     * @return a constante {@link Compass} correspondente, ou {@link #UNKNOWN} se o caractere for inválido
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
