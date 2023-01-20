package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public class Tour extends Piece{
    private boolean roque;
    public Tour(char couleur, Position p){
        super(p);
        this.couleur = couleur;
        this.roque = true;
    }
    public Tour(char couleur, String position){
        super(position);
        this.couleur = couleur;
        this.roque = true;
    }

    public Tour(){
        super('B', "a1");
        this.roque = true;
    }

    @Override
    public char getCouleur() {
        return this.couleur;
    }

    public boolean getRoque() {
        return roque;
    }
    
    public void setRoque(boolean roque){
        this.roque = roque;
    }

    @Override
    public ArrayList<Position> getDeplacementsPossibles(Plateau plat){
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        int i, fini= 0;
        Position pos2 = new Position(pos);
        for(i=-1;i<2;i+=2){
                pos2 = new Position(pos);
                fini = 0;
                if ((pos2.getX()+i<8)&&(pos2.getX()+i>=0)){
                    pos2 = new Position(pos2.getX()+i, pos2.getY());
                }
                else{
                    fini = 1;
                }
                while ((plat.getCase(pos2) == null)&&(fini == 0)){
                    
                    liste.add(pos2);
                    if ((pos2.getX()+i<8)&&(pos2.getX()+i>=0)){
                    pos2 = new Position(pos2.getX()+i, pos2.getY());
                    }
                    else{
                        fini = 1;
                    }
                }
                if ((plat.getCase(pos2) != null)&&(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                    liste.add(pos2);
                    
            }
            pos2 = new Position(pos);
                fini = 0;
                if ((pos2.getY()+i<8)&&(pos2.getY()+i>=0)){
                    pos2 = new Position(pos2.getX(), pos2.getY()+i);
                }
                else{
                    fini = 1;
                }
                while ((plat.getCase(pos2) == null)&&(fini == 0)){
                    
                    liste.add(pos2);
                    if ((pos2.getY()+i<8)&&(pos2.getY()+i>=0)){
                    pos2 = new Position(pos2.getX(), pos2.getY()+i);
                    }
                    else{
                        fini = 1;
                    }
                }
                if ((plat.getCase(pos2) != null)&&(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                    liste.add(pos2);
                    
            }
        }
        return liste;
    }

    public String getType() {
        return "tour";
    }
}
