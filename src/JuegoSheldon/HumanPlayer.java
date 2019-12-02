package JuegoSheldon;

public class HumanPlayer {
    private String name;
    private int victorias;
    private int perdidas;
    
    public HumanPlayer(String name){
        this.name = name;
    }
    
    public void sumarUnaVictoria(){
        this.victorias += 1;
    }

    public void sumarUnaPerdida(){
        this.perdidas += 1;
    }
    
    public int getVictorias(){
        return this.victorias;
    }
    
    public int getPerdidas(){
        return this.perdidas;
    }
    
    public String getName(){
        return this.name;
    }
    
    
}
