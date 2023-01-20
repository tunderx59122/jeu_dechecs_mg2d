package classes;

import MG2D.geometrie.Point;

public class Position {
    private int x;
    private int y;

    //constructeur 
    public Position(){
        this.x = 0;
        this.y = 0;
    }
    //constructeur par copie
    public Position(Position copie){
        this.x = copie.x;
        this.y = copie.y;
    }

    //constructeur a partir de 2 entiers
    public Position(int x, int y){
        if ((0<=x)&(x<8)){
            this.x = x;
        }
        if ((0<=x)&(x<8)){
            this.y = y;
        }
    }
    //constructeur à partir d'un String de position
    public Position(String s){
        int y = (int)s.charAt(1);
        y = y-49;
        
        if ((0<=y)&&(y<=7)){
            this.y = y;
            
            
            if (s.charAt(0) == 'a'){
                this.x = 0;
            }

            if (s.charAt(0) == 'b'){
                this.x = 1;
            }

            if (s.charAt(0) == 'c'){
                this.x = 2;
            }
            
            if (s.charAt(0) == 'd'){
                this.x = 3;
            }
            
            if (s.charAt(0) == 'e'){
                this.x = 4;
            }
            
            if (s.charAt(0) == 'f'){
                this.x = 5;
            }
            
            if (s.charAt(0) == 'g'){
                this.x = 6;
            }
            
            if (s.charAt(0) == 'h'){
                this.x = 7;
            }
            
        }
        else{
            System.out.println("position inexistante");
        }

    
    }
    //constructeur de position à partir d'un point MG2D
    public Position(Point p){
        this.x = (int)p.getX()/100;
        this.y = (int)p.getY()/100;
    }

    //retourne la position en X
    public int getX() {
        return this.x;
    }

    //retourne la position en Y
    public int getY(){
        return this.y;
    }

    //change la position en X
    public void setX(int x){
            this.x = x ;
        }

    //change la position en Y
    public void setY(int y){
        this.y = y ;
    }

    

    


    //retourne la position sous forme de String de façon échiquéenne
    @Override
    public String toString() {
        char ch = ' ';
        if (this.x == 7){
            ch = 'h';
        }

        if (this.x == 6){
            ch = 'g';
        }

        if (this.x == 5){
            ch = 'f';
        }

        if (this.x == 4){
            ch = 'e';
        }

        if (this.x == 3){
            ch = 'd';
        }

        if (this.x == 2){
            ch = 'c';
        }

        if (this.x == 1){
            ch = 'b';
        }

        if (this.x == 0){
            ch = 'a';
        }
        String y = String.valueOf(this.y + 1);
        return (ch + y);
    }




    //compare 2 positions afin de savoir si elles sont égales
    @Override
    public boolean equals(Object p) {
        if (p instanceof Position == false){
            return false;
        }
        else{
            Position p2 = (Position)p;
            String s = this.toString();
            String s2 = p2.toString();
            return s.equals(s2);
        }
    }


}
