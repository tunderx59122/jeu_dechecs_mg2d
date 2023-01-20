package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public class Roi extends Piece{
    private boolean roque;
    public Roi(char couleur, Position p){
        super(couleur, p);
        this.roque = true;
    }
    public Roi(char couleur, String position){
        super(couleur, position);
        this.roque = true;
    }

    public Roi(){
        super('B', "a1");
        this.roque = true;
    }


    public char getCouleur() {
        return this.couleur;
    }

    public boolean getRoque() {
        return this.roque;
    }
    public void setRoque(boolean roque) {
        this.roque = roque;
    }


    @Override
    public ArrayList<Position> getDeplacementsPossibles(Plateau plat){
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        int i,j;
        Position pos2 = new Position(pos);
        for(i=-1;i<2;i++){
            for(j=-1;j<2;j++){
                if ((((pos.getX()+i<8)&&(pos.getX()+i>=0))&&((pos.getY()+j<8)&&(pos.getY()+j>=0)))&&((i!=0)||(j!=0))){
                    pos2 = new Position(pos.getX()+i, pos.getY()+j);
                    if (this.couleur == 'N'){
                        if (!plat.estAttaqueBlanc(pos2)){
                            if (plat.getCase(pos2) == null){
                            liste.add(pos2);
                            }
                            else{
                                if(plat.getCase(pos2).getCouleur() != this.couleur){
                                    liste.add(pos2);
                                }
                            }
                        }
                    }
                    else{
                        if (!plat.estAttaqueNoir(pos2)){
                            if (plat.getCase(pos2) == null){
                                liste.add(pos2);
                                }
                                else{
                                    if(plat.getCase(pos2).getCouleur() != this.couleur){
                                        liste.add(pos2);
                                    }
                            }
                        }
                    }
                    
                }
            }
        }
        
        if (plat.grandRoque(this.couleur)){
            pos2 = new Position(pos.getX() -2 , pos.getY());
            liste.add(pos2);
        }
        if (plat.petitRoque(this.couleur)){
            pos2 = new Position(pos.getX() +2 , pos.getY());
            liste.add(pos2);
        }
        
        return liste;
    }
    
    public String getType() {
        return "roi";
    }
    
}
