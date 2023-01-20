package classes.pieces.pions;

import java.util.ArrayList;

import classes.*;
import classes.pieces.*;

public class PionBlanc extends Pion {
    public PionBlanc(Position p){
        super(p);
        this.couleur = 'B';
    }
    
    public PionBlanc(String position){
        super(position);
        this.couleur = 'B';

    }

    public PionBlanc(){ 
        super();

    }
    public String getType() {
        return "pion";
    }

    public char getCouleur() {
        return 'B';
    }
    public boolean getRoque(){
        return false;
    }
    
    
    public void setRoque(boolean roque){}


    public ArrayList<Position> getPosPrise(Plateau plat) {
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        Position pos_prise = new Position(pos.getX()+1,pos.getY()+1);

        if ((pos.getX()+1<8)&&(pos.getY()+1<8)){
            liste.add(pos_prise);
        }
       

        pos_prise = new Position(pos.getX()-1,pos.getY()+1);
        if ((pos.getX()-1>=0)&&(pos.getY()+1<8)){
            liste.add(pos_prise);
        }
        return liste;
        
    }

    @Override
    public ArrayList<Position> getDeplacementsPossibles(Plateau plat){
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        Position pos2 = new Position(pos);
        if (pos.getY() == 1){
            pos2 = new Position(pos2.getX(), pos2.getY()+1);
            if (plat.getCase(pos2) == null){
                liste.add(pos2);
                pos2 = new Position(pos2.getX(), pos2.getY()+1);
                if (plat.getCase(pos2) == null){
                    liste.add(pos2);
                }
            }
        }
        
        else{
            pos2.setY(pos2.getY()+1);
            if ((plat.getCase(pos2) == null)&&(pos2.getY()<8)){
                liste.add(pos2);
            
            }
        }
        Position pos_prise = new Position(pos.getX()+1,pos.getY()+1);

        if (plat.getCase(pos_prise) != null){
            if ((plat.getCase(pos_prise).getCouleur() == 'N')&&((pos_prise.getY()>=0)&&(pos_prise.getX()<8))){
                liste.add(pos_prise);
            }
        }

        pos_prise = new Position(pos.getX()-1,pos.getY()+1);
        if (plat.getCase(pos_prise) != null){
            if ((plat.getCase(pos_prise).getCouleur() == 'N')&&((pos_prise.getY()>=0)&&(pos_prise.getX()>=0))){
                liste.add(pos_prise);
            }
        }
        return liste;
    }
}