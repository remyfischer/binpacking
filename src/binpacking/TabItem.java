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
public class TabItem {
    
    private int nbItem;
    private ArrayList<Item> tabItem;
    
    
    public TabItem(){
        
        nbItem = 0;
        tabItem = new ArrayList<Item>();
        
    }
    
    public void AjoutItem(Item _item){
        
        tabItem.add(_item);
        nbItem++;
        
    }
    
    public Item getItem(int i){
        
        return tabItem.get(i);
        
    }

    public void SupprItem(int indice){
        
        if (tabItem.get(indice) != null ){
            
            tabItem.remove(indice);
            nbItem--;           
            
        }
        
    }
    
    public void initTabItem(){
        
        Scanner sc = new Scanner(System.in);
        int nbItemAAjouter;
        int tailleXItem;
        
        System.out.println("Combien d'item souhaitez vous ajouter ?");
        nbItemAAjouter = sc.nextInt();
        
        for (int i = 0 ; i < nbItemAAjouter ; i++ ){
            
            System.out.println("Saisissez une taille pour votre item");
            tailleXItem = sc.nextInt();
            tabItem.add(new Item(tailleXItem));
            nbItem++;
        }
        
    }
    
    public void afficherContenu(){
        
        System.out.println("-------------------------------");
        
        for(int i = 0 ; i < nbItem ; i++){
            
            System.out.println("Taille item " + i + " : " + (tabItem.get(i)).getTailleX());
        
        }
        
        System.out.println("-------------------------------");
        
    }
            
            
         
    
    public int getNbItem(){
        
        return nbItem;
        
    }
    
    public int getPlusGrandeDimension(){
        
        int maxX = -1;
        
        for(int i=0 ; i < nbItem ; i++){
            
            if(tabItem.get(i).getTailleX() > maxX ){
                
                maxX = tabItem.get(i).getTailleX();
                
            }
            
        }
        
        return maxX;
        
    }
    
    public void triSelectionDecroissant(){
        
        int i, j, k, max;
        Item _max;
        i=0;
        while (i < this.getNbItem() - 1 ){
            
            k = i;
            max = this.getItem(k).getTailleX();
            _max = this.getItem(k);
            j=i+1;
            while(j <= this.getNbItem() -1){
                
                if(this.getItem(j).getTailleX() > max){
                    
                    k = j;
                    max = this.getItem(k).getTailleX();
                    _max = this.getItem(k);
                    
                }
                j++;
                
            }
            tabItem.set(k, this.getItem(i));
            tabItem.set(i, _max);
            i++;
            
        }
        
    }
    
    
    
    
}
