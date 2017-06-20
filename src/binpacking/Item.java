/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author remy.fischer
 */
public class Item {
    
    private int tailleX;
    private static final AtomicInteger ID_FACTORY = new AtomicInteger();
    private final int id;
    
    public Item(){
        
        tailleX = 0;
        id = ID_FACTORY.getAndIncrement();
        
    }
    
    public Item(int _x){
        
        tailleX = _x;
        id = ID_FACTORY.getAndIncrement();
        
    }
    
    public int getTailleX(){
        
        return tailleX;
        
    }
    
    public int getID(){
        
        return id;
        
    }
    
    public void setTailleX(int _x){
        
        tailleX = _x;
        
    }
    
    
    
}
