package JuegoSheldon;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FuncionesUtiles {

    public static void main(String[] args) {
    }
    private static Scanner entrada = new Scanner(System.in);
    
    public static String readString(String text){
    System.out.print(text);
    String txt = entrada.nextLine();
    return txt;
    }
    
    public static int readPositiveWholeBetween(String message,int since, int until){    
        Scanner entrada = new Scanner(System.in);
        int whole;    
        System.out.print(message);
        whole = entrada.nextInt();
        while (whole < since && whole > until){
            System.out.print("ERROR." + message);
            whole = entrada.nextInt();    
        }
        return whole;
    }
    static int readPositiveWhole(String message){         
        Scanner entrada = new Scanner(System.in);
        int whole;    
        System.out.print(message);
        whole = entrada.nextInt();
        while (whole < 0){
            System.out.print("ERROR." + message);
            whole = entrada.nextInt();    
        }
        return whole;
    }
    static public int numRandomEntre(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
