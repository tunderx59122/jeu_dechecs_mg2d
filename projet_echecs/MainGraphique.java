import java.util.ArrayList;

import MG2D.*;
import MG2D.geometrie.*;
import classes.*;
public class MainGraphique {

    //permet en une méthode de charger le plateau et la condition d'échecs 
    public static void setCase(Plateau plat, Fenetre f,String chemin) {
        f.effacer();
        Texture t = new Texture(chemin, new Point(0, 0), 800, 800);
        f.ajouter(t);
        int i;
        for (i=0;i<plat.getPieces().size();i++){
            Piece piece = plat.getPieces().get(i);
            Point coin_piece = new Point((piece.getPosition().getX()*100), (piece.getPosition().getY()*100));
            
            t = new Texture (piece.getChemin(), coin_piece, 100, 100);
            f.ajouter(t);   
            
        }
        t = new Texture("echiquiers_png\\plateau_bois.PNG", new Point(900, 550), 200, 200);
        f.ajouter(t);
        t = new Texture("echiquiers_png\\plateau_marbre.PNG", new Point(900, 300), 200, 200);
        f.ajouter(t);
        t = new Texture("echiquiers_png\\plateau_normal.PNG", new Point(900, 50), 200, 200);
        f.ajouter(t);
        
        if (plat.estEchec('B')){
            Point coin_piece = new Point(plat.getRoi('B').getPosition());
            coin_piece = new Point(plat.getRoi('B').getPosition().getX()*100, plat.getRoi('B').getPosition().getY()*100);
            Carre carre = new Carre(Couleur.ROUGE, coin_piece, 100);
            f.ajouter(carre);
        }
        if (plat.estEchec('N')){
            Point coin_piece = new Point(plat.getRoi('N').getPosition());
            coin_piece = new Point(plat.getRoi('N').getPosition().getX()*100, plat.getRoi('N').getPosition().getY()*100);
            Carre carre = new Carre(Couleur.ROUGE, coin_piece, 100);
            f.ajouter(carre);
        }
    }
    
    public static void main ( String[] args ){
        Fenetre f = new Fenetre("Mon_appli_MG2D", 1200, 800);
        Souris s = f.getSouris();
        int i;
        ArrayList<Cercle> liste_temporaire = new ArrayList<>();
        boolean boucle = true;
        char joueur = 'B';
        Plateau plat = new Plateau();
        String chemin = "echiquiers_png\\plateau_bois.PNG";
        while(boucle){
            try{
            Thread.sleep(30);
            }
            catch(Exception e){
            } 
            //intialisation du plateau
            setCase(plat, f, chemin);
            f.rafraichir();   

            if (s.getClicGauche()){
                
                
                
                //vérifie que le clique est situé sur le plateau
                Position pos = new Position(s.getPosition());
                if (s.getPosition().getX()<=800){
                    //vérifie la présence d'une pièce de la couleur du joueur qui doit jouer à l'endroit cliqué
                    if (plat.getCase(pos)!=null){
                        if (plat.getCase(pos).getCouleur() == joueur){
                            Piece p = plat.getCase(pos);
                            ArrayList<Position> liste = p.getDeplacementsPossibles(plat);
                            //montre les déplacements possibles
                            for (i=0;i<liste.size();i++){
                                Point a = new Point(liste.get(i));
                                Carre carre = new Carre(a, 100);
                                Cercle cercle = new Cercle(Couleur.ROUGE, carre, false);
                                f.ajouter(cercle);
                                liste_temporaire.add(cercle);
                                f.rafraichir();
                            }
                            boolean clic = true;
                            while(clic){
                                try{
                                    Thread.sleep(10);
                                    }
                                    catch(Exception e){
                                    } 
                                
                                if (s.getClicGauche()){
                                    //vérifie si l'on peut déplacer la pièce selectionnée à l'endroit cliqué
                                    Position pos_finale = new Position(s.getPosition());
                                    for (i=0;i<liste.size();i++){   
                                        if (pos_finale.equals(liste.get(i))){
                                            //déplace la pièce et change le joueur qui doit jouer 
                                            plat.deplacer(pos, pos_finale);
                                            if (joueur == 'B'){
                                                joueur = 'N';
                                            }
                                            else{
                                                joueur = 'B';
                                            }
                                            
                                        }
                                    }
                                    clic = false;
                                    //enlève les position possibles de la pièce précédemment cliquée
                                    for (i=0;i<liste_temporaire.size();i++){
                                        f.supprimer(liste_temporaire.get(i));
                                    }
                                    
                                    
                                }
                                else if (s.getClicDroit()){
                                    //enlève les position possibles de la pièce précédemment cliquée
                                    for (i=0;i<liste_temporaire.size();i++){
                                        f.supprimer(liste_temporaire.get(i));
                                    }
                                clic = false;
                                }
                            }
                        }
                    }   
                }
                //gère le changement de type de plateau
                else {
                    if ((s.getPosition().getX()>=900)&&(s.getPosition().getX()<=1100)){
                        if ((s.getPosition().getY()>=550)&&(s.getPosition().getY()<=750)){
                            chemin = "echiquiers_png\\plateau_bois.PNG";
                        }
                        else if ((s.getPosition().getY()>=300)&&(s.getPosition().getY()<=500)){
                            chemin = "echiquiers_png\\plateau_marbre.PNG";
                        }
                        else if ((s.getPosition().getY()>=50)&&(s.getPosition().getY()<=250)){
                            chemin = "echiquiers_png\\plateau_normal.PNG";
                        }
                    }
                }    
            }
        }
    }
}
