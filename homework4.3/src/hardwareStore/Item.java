
package hardwareStore;
/**
 * @author Farukh Khassan Khojayev.
 * @since12-04-2020
 * @vesion 1.0
 *  In this assignment I implemented a simulator for a hardware store.
This assignment required me to use the ArrayLists in addition to
the Queue interface and PriorityQueue. 
* 
* 
* An this Item class that models the name and price of something that is sold
* in a hardware store. For example, a hammer that costs $10.50. 
 **/

public class Item {
    
    private String name;
    private int price;
    
    public Item(String name, int price){
        this.name = name;
        this.price = price;
        
    }
    
    public String getName(){
        return name;
        
    }
    
    public int getPrice(){
        return price;
        
    }

    public String toString(){
        

        return name+"             $"+price;
    }
}
