/**
 * @author Farukh Khassan Khojayev.
 * @since 10-06-2020
 * @vesion 1.0
 * 
 * This program implements a Contact List entry. 
 */ 
package contactBook;

import java.util.*;
import java.util.Collections;

public class ContactList implements Iterable<Contact>  {
    
   private ArrayList<Contact> list = new ArrayList<Contact>();
   

   
   public ContactList(){
        list = new ArrayList<>();
   }
   
   public ContactList(Contact[] contacts ){
       super();
       list = new ArrayList<>(Arrays.asList(contacts));
       
   }
   

   
   public Contact findByLastName(String last){
       
       int start=0;
       int end =list.size();
       while(start<end){
           int mid=(start+end)/2;
           if(last.equalsIgnoreCase(list.get(mid).getLastName()))
               return list.get(mid);
           else if(last.compareTo(list.get(mid).getLastName())<0)
                end=mid-1;
           else
             start=mid+1;           
       }
       
       return null;
   }
   
   public Contact findByPhoneNumber(String phone){
       for(Contact c: list){
           if(c.getPhonNum().equals(phone))
            return c;
            
       }
       return null;
   }
   
   public void addLocalList(Contact c){
       
       list.add(c);
   }
   
   public ContactList findAllByLastInitial(char ch){
       ContactList localList = new ContactList(); 
       for(Contact c: list){
           if(c.getLastName().charAt(0)==ch)
               localList.addLocalList(c);
       }
       return localList;
      
   }
   
   public ContactList findAllByCity(String city){
       ContactList localList = new ContactList(); 
       for(Contact c: list){
           if(c.getCity().equals(city)){
               localList.addLocalList(c);
           }
           
       }
       return localList;
   }
   
   public boolean add(Contact c){
       Contact another = c;
       int start=0;
       int end =list.size();
       while(start<end){
           int mid=(start+end)/2;
           if(another.getLastName().equalsIgnoreCase(list.get(mid).getLastName())&&
                   another.getFirstName().equalsIgnoreCase(list.get(mid).getFirstName())){
                return false;
           }   
           else if(another.getLastName().compareTo(list.get(mid).getLastName())<0&&
                   another.getFirstName().compareTo(list.get(mid).getFirstName())<0)
                end = mid-1;
           else
             start=mid+1;           
       }
       list.add(c);
       Collections.sort(list);// When I added new Contact to the list, 
       //Collection.sort will sort my ContactList 
       return true;
   }
      
   
   public int size(){
       
       return list.size();
   }
   
   public Contact remove(Object obj){
       
        boolean result = obj instanceof Contact;
       if(!result)
           return null;
       Contact another = (Contact)obj;
       list.remove(another);
       return another;
   }
   
   public Contact get(int index){
       
        if(index<0||index>=size())
            throw new IndexOutOfBoundsException();
        return list.get(index);
   }
   
   public boolean equals(Object obj){
        boolean result = obj instanceof ContactList;
       if(!result)
           return false;
       ContactList another = (ContactList)obj;
        return (list.equals(another.list));
        
          
   }
   
   public String toString(){
       
       String output = "";
       for(Contact c: list)
        output+= c.toString()+"\n";
       
       return output;
   }
   
   
   
    public Iterator<Contact> iterator(){
        
        return list.iterator();
    }
    public static void main(String [] args){
        
        Contact Farukh = new Contact("Farukh", "Ahassan", "(347) 583-2393", "3570 Bedford Ave", "Brooklyn", "NY" );
        Contact John = new Contact("John", "Khassan", "(347) 777-7777","3244 Knapp St", "Brooklyn","NY"); 
        Contact Sean = new Contact("Sean", "Smith","(777) 777-0298", "1234 5th Ave", "Manhattan", "NY");
        Contact Elon = new Contact("Elon","Dusk","(777) 222-7777","2323 Ocean Ave","Manhattan", "NY");
        Contact Tom = new Contact("Tom","Eivers","(917) 808-7777","2111 Ocean Ave","Bronx", "NY");
        Contact Eric = new Contact("Eric","Govrilov","(917) 800-2222","2323 ConeyIsland Ave","Brooklyn", "NY");
        Contact [] array = {Farukh,John,Sean,Elon,Tom}; 
        Contact [] array2= {Farukh,John,Sean,Elon,Tom};
        Arrays.sort(array);// I am sorting Array by using compareTo() method from 
        //Contact class 
        Arrays.sort(array2);
        ContactList list1 = new ContactList(array);
        ContactList list2 = new ContactList(array2);
       
        System.out.println(list1.size());
        System.out.println(list1.findByLastName("Smith"));
        System.out.println(list1.findByPhoneNumber("(917) 808-7777"));
        System.out.println(list1.findAllByLastInitial('E'));
        System.out.println(list1.findAllByCity("Manhattan"));
        System.out.println(list1.add(Eric));
        list1.remove(Eric);
        System.out.println(list1.get(3));
        System.out.println(list1.equals(list2));
        System.out.println(list1.toString());
       
    }

}
