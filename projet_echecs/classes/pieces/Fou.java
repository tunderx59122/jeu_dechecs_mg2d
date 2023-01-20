package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public class Fou extends classes.Piece{
    public Fou(char couleur, Position p){
        super(couleur, p);
    }
    public Fou(char couleur, String position){
        super(couleur, position);
    }
    public Fou(){
        super('B', "a1");
    }

    public char getCouleur() {
        return this.couleur;
    }
    
    public String getType() {
        return "fou";
    }

    public boolean getRoque(){
        return false;
    }

    public void setRoque(boolean roque){}

    public ArrayList<Position> getDeplacementsPossibles(Plateau plat){
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        int i,j, fini = 0;
        Position pos2 = new Position(pos);
        for(i=-1;i<2;i+=2){
            for(j=-1;j<2;j+=2){
                pos2 = new Position(pos);
                fini = 0;
                if (((pos2.getX()+i<8)&&(pos2.getX()+i>=0))&&((pos2.getY()+j<8)&&(pos2.getY()+j>=0))){
                    pos2 = new Position(pos2.getX()+i, pos2.getY()+j);
                }
                else{
                    fini = 1;
                }
                while ((plat.getCase(pos2) == null)&&(fini == 0)){
                    
                    liste.add(pos2);
                    if (((pos2.getX()+i<8)&&(pos2.getX()+i>=0))&&((pos2.getY()+j<8)&&(pos2.getY()+j>=0))){
                    pos2 = new Position(pos2.getX()+i, pos2.getY()+j);
                    }
                    else{
                        fini = 1;
                    }
                }
                if ((plat.getCase(pos2) != null)&&(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                    liste.add(pos2);
                    
                }
            }
        }
        return liste;
    }

    
}
