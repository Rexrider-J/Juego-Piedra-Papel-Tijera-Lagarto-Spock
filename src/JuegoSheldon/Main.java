/*
Piedra, papel, tijera, lagarto, spock:
tijeras > papel (Cortan)
papel > piedra  (Tapa)
piedra > lagarto (Aplasta)
lagarto > spock (Envenena)
spock > tijeras (Rompe)
tijeras > lagarto (decapitan)
lagarto > papel (deboran)
papel > spock (Desautoriza)
spock > piedra (vaporiza)
piedra > tijeras (aplasta)
 */
package JuegoSheldon;

public class Main {

    public static void main(String[] args) {
        GameSheldon juego = new GameSheldon();
        juego.arrancar();
    }
    
}
