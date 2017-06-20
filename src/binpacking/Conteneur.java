/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;

/**
 *
 * @author remy.fischer
 */
public class Conteneur {
    
    private int tailleX;
    private int[][] conteneur;
    
    public Conteneur(){
        
        tailleX = 1;
        conteneur = new int[tailleX][2];
        
    }
    
    public Conteneur(int _x){
        
        tailleX = _x;
        conteneur = new int[tailleX][2];
        
    }
    
    public int getTailleX(){
        
        return tailleX;
        
    }
    
    public int getX(int _x){
        
        return conteneur[_x][0];
        
    }
    
    public int getID(int _x){
        
        return conteneur[_x][1];
    }
      
    
    public void setTailleX(int _x){
        
        tailleX = _x;
        conteneur = new int[tailleX][2];
        
    }
    
    public void setX(int _x, int _val){
        
        conteneur[_x][0] = _val;
        
    }
    
    public void setID(int _x, int _ID){
        
        conteneur[_x][1] = _ID;
        
    }

    public void init(){
        
        for(int i = 0 ; i < tailleX ; i++){
            
            for(int j = 0 ; j < 2 ; j++)
                
                if(j==0) conteneur[i][j] = -1;
                else conteneur[i][j] = 0;
                
            }
        
    }
    
    public void clone(Conteneur _source){
        
        this.setTailleX(_source.getTailleX());
        for(int i = 0 ; i < this.getTailleX() ; i++){
            
            this.setX(i, _source.getX(i));
            this.setID(i, _source.getID(i));
            
        }
        
    }
    
    public void afficherContenu(){
        
        System.out.println("-------------------------------");
        
        for(int i = 0 ; i < tailleX ; i++){
            
            System.out.println("Conteneur[" + i + "][0] = " + conteneur[i][0] + "     [" + i + "][1] = " + conteneur[i][1]);
            
        }
        
        System.out.println("-------------------------------");
        
        
    }
    
    public int split(int maxSplit){
        
        int tailleXRestante = this.getTailleX();
        int i = 0;
        int start = 0;
        int id = 1;
        
        if (maxSplit > this.getTailleX()){
            
            System.out.println("Le plus grand objet de votre liste est plus grand que ce conteneur, veuillez réessayer.");
            return -1;
            
        } else {
        
            do{

                if (maxSplit <= tailleXRestante){

                    for (i = start ; i<maxSplit+start ; i++){

                        conteneur[i][1] = id;

                    }

                    id++;
                    start = i;

                } else {

                    for(i = start ; i<tailleXRestante+start ; i++){

                        conteneur[i][1] = id;

                    }

                }

                tailleXRestante = tailleXRestante - maxSplit;

            } while(tailleXRestante > 0);

            return id;

        }
        
    }
    
}




