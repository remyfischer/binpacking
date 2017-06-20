/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;
import java.util.*;

/**
 *
 * @author remy.fischer
 */
public class BinPacking {
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Scanner sc = new Scanner(System.in);

        int tailleX;
        int maxDimItem;
        int nbSousConteneur;
        double firstfit;
        double firstfitDecreasing;

        TabItem tabItem = new TabItem();

        // int tailleY, tailleZ;


        System.out.println("Veuillez saisir une taille X pour l'avion");
        tailleX = sc.nextInt();


        tabItem.initTabItem();
        tabItem.afficherContenu();

        Conteneur avion = new Conteneur(tailleX);

        avion.init();
        avion.afficherContenu();

        maxDimItem = tabItem.getPlusGrandeDimension();
        nbSousConteneur = avion.split(maxDimItem);
        avion.afficherContenu();
        
        Conteneur cFirstFit = new Conteneur();
        
        cFirstFit.clone(avion);
        
        Conteneur cFirstFitD = new Conteneur();
        
        cFirstFitD.clone(avion);
        
        firstfit = firstFit(tabItem, cFirstFit, nbSousConteneur);
        firstfitDecreasing = firstFitDecreasing(tabItem, cFirstFitD, nbSousConteneur);
        
        cFirstFit.afficherContenu();
        cFirstFitD.afficherContenu();
        
        System.out.println("Methode First Fit : "+firstfit+"% de remplissage");
        System.out.println("Methode First Fit Decreasing : "+firstfitDecreasing+"% de remplissage");
        
        if (firstfit >= firstfitDecreasing){
            
            System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
            avion.clone(cFirstFit);
            avion.afficherContenu();
            
        }
        
        if (firstfit < firstfitDecreasing){
            
            System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
            avion.clone(cFirstFitD);
            avion.afficherContenu();
        }
        
        
        //firstfit = firstFit(tabItem, avion, nbSousConteneur);
        
        //avion.afficherContenu();
    
    
    
        
    }
    
    public static double firstFit(TabItem _tabItem, Conteneur _conteneur, int _nbSousConteneur){
        
        int compteur;
        boolean sousConteneurLibre;
        int cptSousConteneur;
        int i;
        int numConteneur;
        double remplissage = 0;
       
        for(int k = 0 ; k < _tabItem.getNbItem() ; k++){
           
           sousConteneurLibre = false;
           cptSousConteneur = 1;
           numConteneur = 0;
           i = 0;
           
            do{

                compteur = 0;
                if ( i >= _conteneur.getTailleX()) break;
                
                do{
                    
                    //if ( i >= _conteneur.getTailleX()) break;
                    if(_conteneur.getX(i)== -1) compteur++;
                    i++;
                    if ( i >= _conteneur.getTailleX()) break;
                    
                } while (_conteneur.getID(i) == cptSousConteneur);

                if (compteur >= (_tabItem.getItem(k).getTailleX())){ 

                    sousConteneurLibre = true;
                    numConteneur = cptSousConteneur;

                }

                cptSousConteneur++;

            } while(sousConteneurLibre == false && cptSousConteneur <= _nbSousConteneur);

            if (sousConteneurLibre == true ){

                i=0;


                while (_conteneur.getID(i) != numConteneur || _conteneur.getX(i) != -1 ){
                    
                    i++;

                }

                for(int j = i ; j < _tabItem.getItem(k).getTailleX()+i ; j++){

                    _conteneur.setX(j, _tabItem.getItem(k).getID());

                }


            }
        }
        
        for (i = 0 ; i < _conteneur.getTailleX() ; i++){
            
            if (_conteneur.getX(i) != -1) remplissage++;
            
        }
        
        remplissage = (remplissage/_conteneur.getTailleX())*100;
        return remplissage;
        
    
    
    }
    
    public static double firstFitDecreasing(TabItem _tabItem, Conteneur _conteneur, int _nbSousConteneur){
        
        double remplissage;
        
        _tabItem.triSelectionDecroissant();
        remplissage = firstFit(_tabItem, _conteneur, _nbSousConteneur);
        
        return remplissage;
        
    }
    
}
