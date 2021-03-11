
package hardwareStore;

import java.io.File;
import java.util.Scanner;


public class Simulation {
    
    public static void main(String [] args) throws Exception{
       //I created the HardwareStore with 10 registers in it. 
       HardwareStore Costco = new HardwareStore(10);
       
       //This scanner will read inventory file.
       Scanner sc = new Scanner(new File("Inventory.txt"));
       
       //This scanner will read event file
       Scanner sc2 = new Scanner(new File("event.txt"));
       
       //This scanner will read the file with names of shoppers
       Scanner sc3 = new Scanner(new File("shopperNames.txt"));
       
       ShoppingCart shCart = new ShoppingCart();
       
       //This loop will read the inventory file, and add the items from the file 
       //to the shopping Cart. It also creates the object of items, with name
       //price of item. 
       while(sc.hasNext()){
           String itemName = sc.next();
           int price = sc.nextInt();
           Item item = new Item(itemName,price);
           shCart.addItem(item);
          
       }
       
       
      //This loop will read event file. If it's detect 'S', it will create new 
      //shopper with name from shoppersNames file. 
       while(sc2.hasNext()){
          if(sc2.next().charAt(0)=='S'){
              String firstName = sc3.next();
              String lastName = sc3.next();
              
            Shopper shopper = new Shopper(firstName,lastName);    
            //When Scanner detect next integer in the file, the forLoop will 
            //loops yhis integer times. 
            int totalItems = sc2.nextInt();
                for(int i=0; i<totalItems; i++){
                    String itemName = sc2.next();
                    //When the scanner reads an item it will call getItem method 
                    // to confirm that this item in the HardwareStore
                    Item foundItem = shCart.getItem(itemName);
                    //Then it reads the amount of items that shopper want.
                    int amount = sc2.nextInt();
                    //Place the item to the ShoppingCart
                    shopper.addItemToCart(foundItem, amount);
                    //Here3 it will add shopper to the shortest line
                    Costco.addShopperToLine(shopper);
            }
                //This line will print the receipt for Shopper
                System.out.println(shopper.toString());
             
            //Here if the scanner doesn't see 'S', it will process/checkout the shoppper 
            // from the longest line. 
          } else {//if(sc2.next().charAt(0)=='P'){
              Costco.processShopper();
           
            }
        
        }
       //This will process/checkout the rest of the shoppers.  
       Costco.checkoutAllShoppper();
       System.out.println("The TOTAL revenue of the COSCO store: "+Costco.totalRevenue());
     
   }
    
}
