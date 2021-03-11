
package hardwareStore;
//This Shopper Class extends the ShoppingCart Class. also, it implements
//Comparator<Shopper>
import java.util.ArrayList;

public class Shopper extends ShoppingCart implements Comparable<Shopper>{
    
    private String firstName;
    private String lastName;
    
    //Constructor to assign name to the Shopper. 
    public Shopper(String firstName, String lastName){
        super();// to extend all methods from ShoppingCart
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    //This method will add Item to the cart n times. 
    public void addItemToCart(Item item, int numItems){
        for(int i=0; i<numItems; i++){
            cart.add(item);
            
        }
    }
    // This method calculates the tax percentege from Total. 
    public int tax(){
        return (int)(grandTotal()*0.08875);
    }
    //This method calculates Total + tax; 
    public int amountOwed(){
        
        double totalOwed = grandTotal()+grandTotal()*0.08875;
           return (int) Math.ceil(totalOwed);
         
    }
    //Prints the receipt for a shopper. 
    public String toString(){
        return "Thank you "+firstName+" "+lastName+
                "\nYou have next items in the Shopping cart: \n"+toString1()+
                "\nTAX 8.875%         $"+tax()+
                "\nTOTAL              $"+amountOwed()+"\n"+
                "------------------------------------------";
       
    }
    /*
    This will return a negative number if“this” has a bigger total to pay than 
    “shopper,” 0 if they owe the same amount, and a positive number if “shopper”
    has a bigger total than “this.” This is how the priority queue will know 
    which shopper to take next. 
    */
   public int compareTo(Shopper shopper){
       
       return  shopper.amountOwed()-this.amountOwed();
   }
 
}
