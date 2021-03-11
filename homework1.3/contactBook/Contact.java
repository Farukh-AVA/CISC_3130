/**
 * @author Farukh Khassan Khojayev.
 * @since 10-06-2020
 * @vesion 1.0
 * 
 * This program implements a contact book entry. 
 */ 
package contactBook;


public class Contact implements Comparable<Contact> {
    
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String stAddress;
    private String city;
    private String state;
    
    
    public Contact(String firstName, String lastName, String phoneNum,
                   String stAddress, String city, String state ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.stAddress = stAddress;
        this.city = city;
        this.state = state;
       
    }
    
    public Contact(String firstName, String lastName, String stAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.stAddress = stAddress;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getStAddress(){
        return stAddress;
    }
    
    public String getPhonNum(){
        return phoneNum;   
    }
    
    public String getCity(){
        return city;
    } 
    
    public String getState(){
        return state;
    }
    
    public void update(String firstName, String lastName, String phoneNum,
                   String stAddress, String city, String state){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.stAddress = stAddress;
        this.city = city;
        this.state = state;
        
        
    }
    
    public boolean equals(Object obj){
         boolean result = obj instanceof Contact;
       if(!result)
           return false;
       Contact another = (Contact)obj;
       return firstName.equals(another.firstName)
                && lastName.equals(another.lastName);
        
    }
    
    public String toString(){
        return firstName+" "+lastName+"   Phone number: "+phoneNum+"\n"+
                stAddress+"\n"+city+", "+state;
                
    }
    
    public int compareTo(Contact another){
        if(another.lastName==lastName&&another.firstName==firstName){
            return 0;
            
        }else if(another.lastName==lastName&&another.firstName!=firstName){
            return another.firstName.compareTo(firstName);
        }
        
       //return another.lastName.compareTo(lastName);
       return lastName.compareTo(another.lastName);
    }
    
   
        
    }

    
