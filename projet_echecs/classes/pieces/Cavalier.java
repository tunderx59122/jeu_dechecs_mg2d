package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public class Cavalier extends Piece {
    
    public Cavalier(char couleur, Position p){
        super(couleur, p);
    
    }
    
    
    public Cavalier(char couleur, String position){
        super(couleur, position);
        this.p = new Position(position);
    }


    public Cavalier(){
        super('B', "a1");
    }

    public char getCouleur() {
        return this.couleur;
    }

    public boolean getRoque(){
        return false;
    }

    
    public void setRoque(boolean roque){}

    public ArrayList<Position> getDeplacementsPossibles(Plateau plat) {
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        int x,y = 0;
        x = pos.getX();
        y = pos.getY();
        

        if (((x+2)<8)&&((y+1)<8)){
            Position pos2 = new Position(x+2, y+1);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }
        }
        
        if (((x+2)<8)&&((y-1)>=0)){
            Position pos2 = new Position(x+2, y-1);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }
        }        
        
        if (((x+1)<8)&&((y+2)<8)){
            Position pos2 = new Position(x+1, y+2);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }
        }

        if (((x+1)>=0)&&((y-2)>=0)){
            Position pos2 = new Position(x+1, y-2);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }
        }
        
        if (((x-1)>=0)&&((y+2)<8)){
            Position pos2 = new Position(x-1, y+2);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }
        }
        
        if (((x-1)>=0)&&((y-2)>=0)){
            Position pos2 = new Position(x-1, y-2);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }        
        }   

        if (((x-2)>=0)&&((y+1)<8)){
            Position pos2 = new Position(x-2, y+1);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }            
        }
        
        if (((x-2)>=0)&&((y-1)>=0)){
            Position pos2 = new Position(x-2, y-1);
            if ((plat.getCase(pos2) == null)||(plat.getCase(pos2).getCouleur() != this.getCouleur())){
                liste.add(pos2);
            }            
        }
    return liste;
    }


    public String getType() {
        return "cavalier";
    }


    
}
