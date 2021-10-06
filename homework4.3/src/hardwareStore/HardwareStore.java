
package hardwareStore;
/**
 HardwareStore class, that models the actual store. I used ArrayList to 
 * represent the HardwareStore. The ArrayList has list of Queues, which
 * represents the registers or checkout lines. Each register/Queue holds shoppers.
 * Also, I used PriorityQueue of Shoppers to checkout shopper which has most of
 * amountOwed.(i.e money owns to the store). 
 **/
import java.util.*;
import java.io.File;
public class HardwareStore {
    
   private ArrayList<Queue<Shopper>> registers = new ArrayList<>();
   
   private int revenue=0;
  
   private PriorityQueue<Shopper> pQueue = new PriorityQueue<>(); 
   
   //This constructor will initialize the number of registers/sceckout lines. 
   public  HardwareStore(int numRegisters){ 
       
     for(int i=0; i<numRegisters; i++)
        registers.add(new LinkedList<Shopper>());
   }
 
   public void addShopperToPriorityQueue(Shopper shopper){
       
      pQueue.add(shopper);
      
   }
   
   //Adds a shopper to the line that currently has the least number of people 
   //waiting on it. 
   public void addShopperToLine(Shopper shopper){
      //I used private hepler method to find shortest register. 
      registers.get(shortestRegister()).add(shopper);
     // registers.get(shortestRegister()).add(pQueue.poll());
   }
   
   
   //Thise helper mothod will detect amount at specific register. 
   /*public int amountAtRegister(int i){
        int registerRevenue = 0;
     while(!registers.get(i).isEmpty()){
           Shopper shopper = registers.get(9).poll();
           registerRevenue += shopper.amountOwed();
           }
     return  registerRevenue;
   }
   */
   
   //Processes the shopper at the front of the longest line. Also, this method
   //add the register revenue to the total revenue of the store. 
   public void processShopper(){
       int registerRevenue = 0;
       //I used private hepler method to find longest register. 
       Shopper shopper = registers.get(longestRegister()).poll();
       registerRevenue += shopper.amountOwed();
       revenue += registerRevenue;
   }
   
  //Processes all Shoppers still on line for all of the lines. This method will
  // loop all registers and process each register while it's empty. Also, this 
  // method add the each register revenue to the total revenue of the store.
   public void checkoutAllShoppper(){
       int registerRevenue = 0;
       for (Queue<Shopper> register : registers) {
           while(!register.isEmpty()){
           Shopper shopper = register.poll();
           registerRevenue += shopper.amountOwed();
           }
       }
       revenue += registerRevenue;
   }
   
   //Returns the amount of money the HardwareStore has taken in so far
   public int totalRevenue(){
       return revenue ;
   }
   
   //This method compare register's size. Which means, number of shoppers in 
   //each registers. Then it will detect least number of shoppers in the
   //register and return the index of the register. 
   private int shortestRegister(){
       
      int shortest = registers.get(0).size();
      int index=0;
      
      for(int i=0; i<registers.size(); i++){
          if(registers.get(i).size()<shortest){
              shortest =registers.get(i).size();
              index = i; 
          }
      }
       return index;
   }
   //This method compare register's size. Which means, number of shoppers in 
   //each registers. Then it will detect most number of shoppers in the
   //register and return the index of the register.
   private int longestRegister(){
       
      int longest = registers.get(0).size();
      int index=0;
      
      for(int i=0; i<registers.size(); i++){
          if(registers.get(i).size()>longest){
              longest =registers.get(i).size();
              index = i; 
          }
      }
       return index;
  
   }
   
   //Thise helper mothod will detect amount of monry at specific register. 
   public int amountAtRegister(int i){
        int registerRevenue = 0;
     while(!registers.get(i).isEmpty()){
           Shopper shopper = registers.get(9).poll();
           registerRevenue += shopper.amountOwed();
           }
     return  registerRevenue;
   }
   
   
   
}
