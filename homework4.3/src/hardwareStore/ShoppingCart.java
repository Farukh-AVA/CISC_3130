
package hardwareStore;
//A ShoppingCart class that contains a ArraiList of Items. 
import java.util.*;

public class ShoppingCart {
    
    public ArrayList<Item> cart = new ArrayList<>();
    
   //This creates an empty shopping cart. 
    public ShoppingCart(){
        this.cart = new ArrayList<>();
        
    }
    //I used this method to add Items from the Inventory file to the Arraylist. 
    public void addItem(Item item){
        cart.add(item);
       
    }
    //I used this method to match the item from Event file and assign price to 
    //Item. If Inventory file doesn't have the Item from event file it will 
    //return "NULL"
     public Item getItem(String str){
         
        for(Item it: cart){
           if(it.getName().equals(str))
            return it;
            
       }
       return null;
   }
     
    //This returns the total price of all of the items in the shopping cart in
    //cents. 
    public int grandTotal(){
        int total = 0;
        for(Item i: cart)
            total += i.getPrice();
        
        return total*100;
       
        
    }
    //This creates a String representation for a ShoppingCart. 
    public String toString1(){
        String output = "";
       for(Item i: cart)
        output+= i.toString()+"\n";
       
       return output+"\nPRICE              $"+grandTotal();
      
    }
   
        
    
    
        
    
    
    
}
