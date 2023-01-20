package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public abstract class Pion extends Piece{
    protected ArrayList<Position> posAttaque = new ArrayList<>();
    public Pion(Position p){
        super(p);
        this.couleur = 'B';

    }
    public Pion(String position){
        super(position);
        this.couleur = 'B';
    }

    public Pion(){
        super('B', "a1");
    }

    public abstract ArrayList<Position> getPosPrise(Plateau plat);

    public abstract String getType();

    public abstract char getCouleur();
   
    public abstract ArrayList<Position> getDeplacementsPossibles(Plateau plat);
}
