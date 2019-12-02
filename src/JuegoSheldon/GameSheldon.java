package JuegoSheldon;

public class GameSheldon {
        private MachinePlayer pc;
        private HumanPlayer jugador;
        
    public void arrancar(){
        bienvenida();
        juego();
    }
    
    private void juego(){
        int cant = FuncionesUtiles.readPositiveWhole("¿El mejor de?: ");
        int rondas = rondas(cant);
        System.out.println(elGanador(rondas));
    }
    
    private void bienvenida(){
        System.out.println("¡Bienvenido a piedra, papel, tijera, lagarto, spock!");
        jugador = new HumanPlayer (FuncionesUtiles.readString("Ingrese nombre del jugador: "));
        pc = new MachinePlayer(FuncionesUtiles.readString("Ingrese nombre de su oponente: "));
    }
    
    private Elemento jugada (){
        System.out.println("[1]Piedra\n[2]Papel\n[3]Tijera\n[4]Lagarto\n[5]Spock");
        int selection = FuncionesUtiles.readPositiveWholeBetween("Escoje tu elemento: ", 1, 5);
        return Elemento.values()[selection-1];
    }
    private int rondas(int cantidad){
        int rondas = 0;
        boolean yaSeGano = false;
        Elemento attack;
        Elemento counterAttack;
        while(rondas < cantidad && yaSeGano == false) {
            rondas += 1;
            attack = jugada();
            System.out.println("\n---Haz elegido " + attack.name() + "---\n");
            counterAttack = pc.machinePlay();
            System.out.println("---" + this.pc.toString() + " ha elegido " + counterAttack.name() + "---\n");
            if (attack.equals(counterAttack)){
                System.out.println("¡Empate!. La ronda se repite.");
                rondas -= 1;
            }else{
                System.out.println(peleaDeElementos(attack,counterAttack) + ".\tGanador de la ronda " + (rondas) +"°: " + ganadorDeRonda(attack,counterAttack) + "\n");
                recuento(ganadorDeRonda(attack,counterAttack));
            }
            yaSeGano = terminar(rondas,cantidad);
        }
        return rondas;
    }
    private void recuento(String jugador){
        if(jugador.equals(this.jugador.getName())){
                    this.jugador.sumarUnaVictoria();
                }else{
                    this.jugador.sumarUnaPerdida();
                }
    }
    private String peleaDeElementos(Elemento a,Elemento b){
        String player1 = a.name();
        String player2 = b.name();
        switch(player1){
            case "Piedra" : 
                if(player2.equals(Elemento.Papel.name())){
                    return "¡El papel tapa piedra!";
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return "¡La piedra rompe tijeras!";
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return "¡Piedra aplasta lagarto!";
                }
                if(player2.equals(Elemento.Spock.name())){
                    return "¡Spock vaporiza piedra!";
                }
            case "Papel": 
                if(player2.equals(Elemento.Piedra.name())){
                    return "¡El papel tapa piedra!";
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return "¡La tijera corta papel!";
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return "¡El lagarto debora papel!";
                }
                if(player2.equals(Elemento.Spock.name())){
                    return "¡Papel desautoriza Spock!";
                }
            case "Tijera": 
                if(player2.equals(Elemento.Piedra.name())){
                    return "¡La piedra rompe tijeras!";
                }
                if(player2.equals(Elemento.Papel.name())){
                    return "¡La tijera corta papel!";
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return "¡Tijeras decapitan lagarto!";
                }
                if(player2.equals(Elemento.Spock.name())){
                    return "¡Spock rompe tijeras!";
                }
            case "Lagarto": 
                if(player2.equals(Elemento.Piedra.name())){
                    return "¡Piedra aplasta lagarto!";
                }
                if(player2.equals(Elemento.Papel.name())){
                    return "¡El lagarto debora papel!";
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return "¡Tijeras decapitan lagarto!";
                }
                if(player2.equals(Elemento.Spock.name())){
                    return "!El lagarto envenena Spock!";
                }
            case "Spock": 
                if(player2.equals(Elemento.Piedra.name())){
                    return "¡Spock vaporiza piedra!";
                }
                if(player2.equals(Elemento.Papel.name())){
                    return "¡Papel desautoriza Spock!";
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return "¡Spock rompe tijeras!";
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return "!El lagarto envenena Spock!";
                }
        }
        return "";
    }
    
    private String ganadorDeRonda(Elemento a,Elemento b){
        String player1 = a.name();
        String player2 = b.name();
        switch(player1){
            case "Piedra": 
                if(player2.equals(Elemento.Papel.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Spock.name())){
                    return this.pc.toString();
                }
            case "Papel": 
                if(player2.equals(Elemento.Piedra.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Spock.name())){
                    return this.jugador.getName();
                }
            case "Tijera": 
                if(player2.equals(Elemento.Piedra.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Papel.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Spock.name())){
                    return this.pc.toString();
                }
            case "Lagarto":
                if(player2.equals(Elemento.Piedra.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Papel.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Spock.name())){
                    return this.jugador.getName();
                }
            case "Spock":  
                if(player2.equals(Elemento.Piedra.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Papel.name())){
                    return this.pc.toString();
                }
                if(player2.equals(Elemento.Tijera.name())){
                    return this.jugador.getName();
                }
                if(player2.equals(Elemento.Lagarto.name())){
                    return this.pc.toString();
                }
        }
        return "";
    }
    
    private String elGanador(int rondas){
        int perdidas = this.jugador.getPerdidas();
        int victorias = this.jugador.getVictorias();
        if(victorias > perdidas){
            return "***GANADOR DEL JUEGO: " + this.jugador.getName().toUpperCase() + "***";
        }else if (victorias == perdidas){
            return "***EMPATE***";
        }
        else{
            return "***GANADOR DEL JUEGO: " + this.pc.toString().toUpperCase() + "***";
        }
    }
    private boolean terminar(int rondas, int cantidad){
        double mitadDePartida = cantidad /2.0;
        int perdidas = this.jugador.getPerdidas();
        int victorias = this.jugador.getVictorias();
        int rondasRestantes = (cantidad - rondas);
        if( perdidas > victorias && rondas > mitadDePartida && perdidas > rondasRestantes + victorias){
            return true;
        }else if(victorias > perdidas && rondas > mitadDePartida && victorias > rondasRestantes + victorias){
            return true;
        }
        return false;
    }
}
