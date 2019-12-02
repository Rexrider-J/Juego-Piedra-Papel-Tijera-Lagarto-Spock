package JuegoSheldon;

public class MachinePlayer {
    private String name;
    
    public MachinePlayer(String name){
       this.name = name;
    }
    
    public Elemento machinePlay(){
        Elemento play = Elemento.Piedra;
        int num;
        for (int i = 0; i < 100; i++) {
            num = FuncionesUtiles.numRandomEntre(0,Elemento.values().length);
            play = Elemento.values()[num];
        }
        return play;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name + "";
    }
    
}
