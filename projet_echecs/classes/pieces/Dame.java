package classes.pieces;

import java.util.ArrayList;

import classes.*;
//voir la classe Piece pour les commentaires des fonctions
public class Dame extends Piece{
    public Dame(char couleur, Position p){
        super(couleur, p);
    }
    public Dame(char couleur, String position){
        super(couleur, position);
    }

    public Dame(){
        super('B', "a1");
    }

    public char getCouleur() {
        return this.couleur;
    }

    public boolean getRoque(){
        return false;
    }

    
    public void setRoque(boolean roque){}

    @Override
    public ArrayList<Position> getDeplacementsPossibles(Plateau plat){
        Position pos = new Position(this.p);
        ArrayList<Position> liste = new ArrayList<>();
        int i, j, fini= 0;
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




    public String getType() {
        return "dame";
    }
    
}
