package classes;
import java.util.ArrayList;

public abstract class Piece {
    protected char couleur;
    protected Position p;
    // constructeur couleur + position
    public Piece(char couleur, Position p){
        this.p = p;
        
        if ((couleur == 'B')||(couleur == 'N')){
            this.couleur = couleur;
        }
        
        
    }
    // constructeur position
    public Piece(Position p){
        this.p = p;
    }
    // constructeur String de position -> "a1","a2", etc...
    public Piece(String s){
        this.p = new Position(s);
    }
    // constructeur
    public Piece(){
        this.couleur = 'B';
        this.p = new Position("a1");
    }
    // constructeur par copie
    public Piece(Piece piece){
        this.couleur = piece.couleur;
        this.p = new Position(piece.p);
    }

    // constructeur couleur + 2 entier de position 
    public Piece(char couleur, int x, int y){

        this.couleur = couleur;
        this.p = new Position(x, y);

    }

    // constructeur couleur + string de position
    public Piece(char couleur, String position){
        if ((couleur == 'B')||(couleur == 'N')){
            this.couleur = couleur;
        }
        this.p = new Position(position);

    }


    //retourne la position de la pièce
    public Position getPosition() {
        return this.p;
    }

    //retourne si la pièce peut roquer ou non --> pour tour et roi
    public abstract boolean getRoque();

    //change l'état de roque
    public abstract void setRoque(boolean roque);

    //retourne la couleur de la pièce
    public abstract char getCouleur();
    
    //retourne la couleur de la pièce
    public abstract String getType();

    //retourne les déplacements possibles de la pièce
    public abstract ArrayList<Position> getDeplacementsPossibles(Plateau plat);

    //retourne le chemin de l'image de la pièce
    public String getChemin() {
        return "image_pieces\\"+ this.getType()+"_"+this.couleur+".png";
        
    }

    //change la position de la pièce
    public void setPosition(Position p) {
        this.p = p;
    }

    //change la couleur de la pièce
    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    //retourne ce qu'est la pièce
    @Override
    public String toString() {
        String str = "blanc";
        if(this.couleur == 'N'){
            str = "noir";
        }
        return this.getType() + " " + str + " en " + this.p.toString();
    }

    //vérifie si 2 pièces sont égales
    @Override
    public boolean equals(Object p) {
        if (p instanceof Piece == false){
            return false;
        }
        else{
            Piece p2 = (Piece)p;
            return (this.toString().equals(p2.toString()));
        }
    }


}
