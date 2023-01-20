package classes;
import java.util.ArrayList;

import classes.pieces.*;
import classes.pieces.pions.*;

public class Plateau {
//initialisation du plateau
    private ArrayList<Piece> plateau = new ArrayList<>();
    public Plateau(){
        Tour a1 = new Tour('B', "a1");
        Cavalier b1 = new Cavalier('B', "b1");
        Fou c1 = new Fou('B', "c1");
        Dame d1 = new Dame('B', "d1");
        Roi e1 = new Roi('B', "e1");
        Fou f1 = new Fou('B', "f1");
        Cavalier g1 = new Cavalier('B', "g1");
        Tour h1 = new Tour( 'B', "h1");

        PionBlanc a2 = new PionBlanc("a2");
        PionBlanc b2 = new PionBlanc("b2");
        PionBlanc c2 = new PionBlanc("c2");
        PionBlanc d2 = new PionBlanc("d2");
        PionBlanc e2 = new PionBlanc("e2");
        PionBlanc f2 = new PionBlanc("f2");
        PionBlanc g2 = new PionBlanc("g2");
        PionBlanc h2 = new PionBlanc("h2");



        Tour a8 = new Tour('N', "a8");
        Cavalier b8 = new Cavalier('N', "b8");
        Fou c8 = new Fou('N', "c8");
        Dame d8 = new Dame('N', "d8");
        Roi e8 = new Roi('N', "e8");
        Fou f8 = new Fou('N', "f8");
        Cavalier g8 = new Cavalier('N', "g8");
        Tour h8 = new Tour('N', "h8");

        PionNoir a7 = new PionNoir("a7");
        PionNoir b7 = new PionNoir("b7");
        PionNoir c7 = new PionNoir("c7");
        PionNoir d7 = new PionNoir("d7");
        PionNoir e7 = new PionNoir("e7");
        PionNoir f7 = new PionNoir("f7");
        PionNoir g7 = new PionNoir("g7");
        PionNoir h7 = new PionNoir("h7");

        this.plateau.add(a1);
        this.plateau.add(b1);
        this.plateau.add(c1);
        this.plateau.add(d1);
        this.plateau.add(e1);
        this.plateau.add(f1);
        this.plateau.add(g1);
        this.plateau.add(h1);

        this.plateau.add(a2);
        this.plateau.add(b2);
        this.plateau.add(c2);
        this.plateau.add(d2);
        this.plateau.add(e2);
        this.plateau.add(f2);
        this.plateau.add(g2);
        this.plateau.add(h2);

        
        this.plateau.add(a7);
        this.plateau.add(b7);
        this.plateau.add(c7);
        this.plateau.add(d7);
        this.plateau.add(e7);
        this.plateau.add(f7);
        this.plateau.add(g7);
        this.plateau.add(h7);

        this.plateau.add(a8);
        this.plateau.add(b8);
        this.plateau.add(c8);
        this.plateau.add(d8);
        this.plateau.add(e8);
        this.plateau.add(f8);
        this.plateau.add(g8);
        this.plateau.add(h8);
    }

//constructeur par copie
    public Plateau(Plateau plat){
        this.plateau = plat.plateau;
    }

    public Piece getCase(int x, int y) {
        int i;
        Position pos = new Position(x, y);
        for (i=0; i<this.plateau.size(); i++){
            if (this.plateau.get(i).getPosition().equals(pos)){
                return this.plateau.get(i);
            }
        }
        return null;
    }


//retourne une pièce à partir d'une position
    public Piece getCase(Position pos) {
        int i;
        for (i=0; i<this.plateau.size(); i++){
            if (this.plateau.get(i).getPosition().equals(pos)){
                return this.plateau.get(i);
            }
        }
        return null;
    }

//retourne une pièce à partir d'une chaine de caractères

    public Piece getCase(String str) {
        int i;
        Position pos = new Position(str);
        for (i=0; i<this.plateau.size(); i++){
            if (this.plateau.get(i).getPosition().equals(pos)){
                return this.plateau.get(i);
            }
        }
        return null;
        
    }


//retourne la liste des pièces blanches d'un plateau
    public ArrayList<Piece> getPiecesBlanches(){
        int i;
        ArrayList<Piece> liste = new ArrayList<>();
        for (i=0; i<this.plateau.size();i++){
            if (this.plateau.get(i).getCouleur() == 'B'){
                liste.add(this.plateau.get(i));
            }
        }
        return liste;
    }


//retourne la liste des pièces blanches d'un plateau
    public ArrayList<Piece> getPiecesNoires(){
        int i;
        ArrayList<Piece> liste = new ArrayList<>();
        for (i=0; i<this.plateau.size();i++){
            if (this.plateau.get(i).getCouleur() == 'N'){
                liste.add(this.plateau.get(i));
            }
        }
        return liste;
    }

//retourne la liste des pièces sur le plateau
    public ArrayList<Piece> getPieces() {
        ArrayList<Piece> liste = new ArrayList<>();
        liste = getPiecesBlanches();
        int i;
        for (i=0; i<getPiecesNoires().size();i++){
            liste.add(getPiecesNoires().get(i));
        }
        return liste;
        
    }

    //retourne si le grand roque est possible
    public boolean grandRoque(char couleur) {
        if (!this.estEchec(couleur)){
            if (couleur == 'B'){
                if ((this.getCase("a1") != null)&&(this.getCase("e1") != null)){
                    Position p1 = new Position("c1");
                    Position p2 = new Position("d1");
                    if ((((((this.getCase("a1").getType().equals("tour"))&&(this.getCase("e1").getType().equals("roi")))
                    &&(this.getCase("d1") == null))&&((this.getCase("c1") == null)&&(this.getCase("b1") == null)))
                    &&((this.getCase("a1").getRoque())&&(this.getCase("e1").getRoque())))
                    &&((!this.estAttaqueNoir(p1))&&(!this.estAttaqueNoir(p2))))
                    {
                        return true;
                    }
                }
            }
            else{
                if ((this.getCase("a8") != null)&&(this.getCase("e8") != null)){
                    Position p1 = new Position("c8");
                    Position p2 = new Position("d8");
                    if ((((((this.getCase("a8").getType().equals("tour"))&&(this.getCase("e8").getType().equals("roi")))
                    &&(this.getCase("d8") == null))&&((this.getCase("c8") == null)&&(this.getCase("b8") == null)))
                    &&((this.getCase("a8").getRoque())&&(this.getCase("e8").getRoque())))
                    &&((!this.estAttaqueNoir(p1))&&(!this.estAttaqueNoir(p2)))){
                        return true;
                    }
                }
            }
        }
        return false;   
    }
    //retourne si le petit roque est possible
    public boolean petitRoque(char couleur) {
        if (!this.estEchec(couleur)){
            if ((this.getCase("h1") != null)&&(this.getCase("e1") != null)){
                if (couleur == 'B'){
                    
                    Position p1 = new Position("f1");
                    Position p2 = new Position("g1");
                    if (((((((this.getCase("h1").getType().equals("tour"))&&(this.getCase("e1").getType().equals("roi")))

                    &&(this.getCase("f1") == null))&&(this.getCase("g1") == null))

                    &&((this.getCase("h1").getRoque())&&(this.getCase("e1").getRoque()))))
                    
                    &&((!this.estAttaqueNoir(p1))&&(!this.estAttaqueNoir(p2)))){

                    return true;
                    }
                }
            }
            if ((this.getCase("h8") != null)&&(this.getCase("e8") != null)){
                if (couleur == 'N'){
                    Position p1 = new Position("f8");
                    Position p2 = new Position("g8");
                    if ((((((this.getCase("h8").getType().equals("tour"))&&(this.getCase("e8").getType().equals("roi")))

                    &&(this.getCase("f8") == null))&&(this.getCase("g8") == null))

                    &&((this.getCase("h8").getRoque())&&(this.getCase("e8").getRoque())))
                    
                    &&((!this.estAttaqueBlanc(p1))&&(!this.estAttaqueBlanc(p2)))){

                        return true;
                    }
                }
            }
        }
        return false;   
    }


//méthode de déplacement de pièce dans un plateau
    public boolean deplacer(Position from, Position to){
        int i;
        Piece p = getCase(from);
        if ((this.getCase(from).getType().equals("roi"))&&((((to.toString().equals("c1")))||((to.toString().equals("c8"))))||(((to.toString().equals("g1")))||((to.toString().equals("g8")))))){
            if (this.grandRoque('B')){
                
                if(to.toString().equals("c1")){
                    p.setPosition(to); 
                    Piece p2 = getCase("a1");
                    Position posroque = new Position("d1");
                    p2.setPosition(posroque);
                    this.plateau.remove(getCase("e1"));
                    this.plateau.remove(getCase("a1"));
                    return true;
                }
            }
            if (this.grandRoque('N')){
                if(to.toString().equals("c8")){
                    p.setPosition(to); 
                    Piece p2 = getCase("a8");
                    Position posroque = new Position("d8");
                    p2.setPosition(posroque);
                    this.plateau.remove(getCase(from));
                    this.plateau.remove(getCase("a8"));
                    return true;
                }
            }
            if (this.petitRoque('B')){
                if(to.toString().equals("g1")){
                    p.setPosition(to); 
                    Piece p2 = getCase("h1");
                    Position posroque = new Position("f1");
                    p2.setPosition(posroque);
                    this.plateau.remove(getCase(from));
                    this.plateau.remove(getCase("h1"));
                    return true;
                }
            }
            if (this.petitRoque('N')){
                if(to.toString().equals("g8")){
                    p.setPosition(to); 
                    Piece p2 = getCase("h8");
                    Position posroque = new Position("f8");
                    p2.setPosition(posroque);
                    this.plateau.remove(getCase(from));
                    this.plateau.remove(getCase("h8"));
                    return true;
                }
            }
        }
        else{
            for (i=0; i<getCase(from).getDeplacementsPossibles(this).size();i++){
                if (to.equals(getCase(from).getDeplacementsPossibles(this).get(i))){
                    int index;
                    this.plateau.remove(p);
                    p.setPosition(to); 
                    if (getCase(to) != null){    
                        index = this.plateau.indexOf(getCase(to));
                        this.plateau.remove(index);
                        this.plateau.add(p);
                    }
                    else{
                        this.plateau.add(p);
                    }


                    if ((p instanceof Roi)||(p instanceof Tour)){
                        p.setRoque(false);
                    }
                    return true;
                }
            }
        }
        return false;
    }


//renvoit la pièce roi de la couleur donnée
    public Piece getRoi(char couleur) {
        int i;
        ArrayList<Piece> liste = new ArrayList<>();
        if (couleur == 'B'){
            liste = this.getPiecesBlanches();
        }
        else{
            liste = this.getPiecesNoires();
        }
        for (i=0; i<liste.size();i++){
            if (liste.get(i).getType().equals("roi")){
                return liste.get(i);
            }
        }
        return null;
    }

//vérifie si le roi de la couleur donnée est en echec
    public boolean estEchec(char couleur) {
        if (couleur == 'N'){
            return this.estAttaqueBlanc(this.getRoi(couleur).getPosition());    
        }
        else{
            return this.estAttaqueNoir(this.getRoi(couleur).getPosition());
            
        }   
    }
    //vérifie si une position est dans une liste de position
    public boolean estDansListe(Position p, ArrayList<Position> liste) {
        int i;
        for (i=0;i<liste.size();i++){
            if (p.equals(liste.get(i))){
                return true;
            }
        }
        return false;
    }
    
    //regarde toutes les positions attaquées par les pièces blanches
    public ArrayList<Position> positionsDAttaqueBlanc() {
        ArrayList<Position> liste  = new ArrayList<>();
        int i,j; 
        for (i=0; i<this.getPiecesBlanches().size();i++){
            if (!this.getPiecesBlanches().get(i).getType().equals("roi"))
                if (this.getPiecesBlanches().get(i).getType().equals("pion")){
                    Pion pion = (Pion)this.getPiecesBlanches().get(i);
                    for (j=0;j<pion.getPosPrise(this).size();j++){
                        if (!this.estDansListe(pion.getPosPrise(this).get(j), liste)){
                            liste.add(pion.getPosPrise(this).get(j));
                        }
                    }
                }
                else{
                    for (j=0;j<this.getPiecesBlanches().get(i).getDeplacementsPossibles(this).size();j++){
                        if (!this.estDansListe(this.getPiecesBlanches().get(i).getDeplacementsPossibles(this).get(j), liste)){
                            liste.add(this.getPiecesBlanches().get(i).getDeplacementsPossibles(this).get(j));
                        }
                    }
                }
        }     
        return liste;   
    }

    //regarde si la position est attaquée par les blancs
    public boolean estAttaqueBlanc(Position pos) {
        if (this.estDansListe(pos, this.positionsDAttaqueBlanc())){
            return true;
        }
        return false;
    }

    //regarde toutes les positions attaquées par les pièces noires
    public ArrayList<Position> positionsDAttaqueNoir() {
        ArrayList<Position> liste  = new ArrayList<>();
        int i,j; 
        for (i=0; i<this.getPiecesNoires().size();i++){
            if (this.getPiecesNoires().get(i).getType().equals("pion")){
                Pion pion = (Pion)this.getPiecesNoires().get(i);
                for (j=0;j<pion.getPosPrise(this).size();j++){
                    if (!this.estDansListe(pion.getPosPrise(this).get(j), liste)){
                        liste.add(pion.getPosPrise(this).get(j));
                    }
                }
            }
            else{
                for (j=0;j<this.getPiecesNoires().get(i).getDeplacementsPossibles(this).size();j++){
                    if (!this.estDansListe(this.getPiecesNoires().get(i).getDeplacementsPossibles(this).get(j), liste)){
                        liste.add(this.getPiecesNoires().get(i).getDeplacementsPossibles(this).get(j));
                    }
                }
            }
        }     
        return liste;   
    }

    //regarde si la position est attaquée par les noirs
    public boolean estAttaqueNoir(Position pos) {
        if (this.estDansListe(pos, this.positionsDAttaqueNoir())){
            return true;
        }
        return false;
    }
}
