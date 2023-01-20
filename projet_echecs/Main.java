import classes.*;
public class Main {
    public static void main (String[] args){
        int i;
        Plateau plat = new Plateau();
        for (i=0; i<plat.getPieces().size(); i++){
            System.out.println(plat.getPieces().get(i).getChemin());
        }

    }
}