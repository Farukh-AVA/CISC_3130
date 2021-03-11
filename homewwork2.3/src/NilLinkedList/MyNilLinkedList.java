/**
 * @author Farukh Khassan Khojayev.
 * @since 10-16-2020
 * @vesion 1.0
 * CISC 3130 
 * This program implements the LinkedList Class with nil node. 
 */ 
package NilLinkedList;

import java.util.NoSuchElementException;
import java.util.*;

public class MyNilLinkedList implements Iterable<String> {
    /*
    In this subclass I implement Iterator with next(), hasNext(), remove() methods.
    */
    private class DListIterator implements Iterator<String>{
        
        private DListNode pointer;
        
        public DListIterator(){
            pointer = nil.next;
            
        }
        
         public String next() {
            String element = pointer.data;
            pointer = pointer.next;
            return element;
        }
        public boolean hasNext() {
            return pointer!=nil;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
       
    }
    /*
    In this subclass I am instantiating fields for DListNode. 
    */
    private static class DListNode{
        public String data;
        public DListNode next;
        public DListNode previous;
        
    }
    
    
    public DListNode nil;
    private int numElements;
    /*
    In this constructer I instantiating nil node, which is pointing to yourself.
    */
    public  MyNilLinkedList(){
        nil= new DListNode();
        nil.previous = nil;
        nil.next =nil;
        nil.data = null;
        numElements = 0;
    }

    /*
    This method addds element to the front of the list. 
    */
    public void addFirst(String element){
        DListNode newNode = new DListNode();
        newNode.data = element;
        newNode.next = nil.next;
        newNode.previous = nil;
        nil.next.previous = newNode;
        nil.next = newNode;
        numElements++;
        
    }
    /*
    This method addds element to the end of the list. 
    */
    public void addLast(String element){
        DListNode newNode = new DListNode();
        newNode.data = element;
        newNode.next = nil;
        newNode.previous=nil.previous;
        nil.previous.next = newNode;
        nil.previous = newNode;
        numElements++;
    }
    /*
    This method returs the first element of the list. 
    */
    public String getFirst(){
        if(nil==nil.next)
            throw  new NoSuchElementException();
        return nil.next.data;
        
    }
    /*
    This method returs the last element of the list. 
    */
    public String getLast(){
        if(nil==nil.next)
            throw  new NoSuchElementException();
        return nil.previous.data;
    }
    /*
    This method removes the first element of the list. 
    */
    public String removeFirst(){
        String old = nil.next.data;
        nil.next = nil.next.next;
        nil.next.previous = nil;
        numElements--; 
        return old;
    }
    /*
    This method removes the last element of the list. 
    */
    public String removeLast(){
        String old = nil.previous.data;
        nil.previous = nil.previous.previous;
        nil.previous.next = nil;
        numElements--;
        return old;
        
    }
    /*
    This method returns the size of the lsit.  
    */
    public int size() {
        return numElements;
    }
    /*
    This private method returns false if index out of bounds and true otherwise. 
    */
     private boolean isOutOfBounds(int index) {
        return index<0 || index>=size();
    }
     /*
    This private method assigns the index for each element in the list.
    returns the element at particular index.
    */
     private DListNode marchToIndex(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        
        int count = 0;
        DListNode temp = nil.next;
        
        while(count<index) {
            count++;
            temp = temp.next;
        }
        return temp;
    }
     /*
    This method returns the value at position index. It also cheks whether the 
     index is out od bounds. 
    */
    public String get(int index){
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        
        return marchToIndex(index).data;
    }
    /*
    This method returns the value at position index. It also checks whether the 
     index is out od bounds. 
    */
    public String set(int index, String value) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        
        DListNode newNode = marchToIndex(index);
        newNode.data = value;
        return value;
    } 
    /*
    This method returns true if obj appears in the list and false otherwise. 
    */
    public boolean contains(Object obj){
         return indexOf(obj) != -1;
    }
     /*
    This method returns the index of obj if it is in the list and -1 otherwise.
    */
     public int indexOf(Object obj) {
        
        int index=0;
        DListNode newNode = nil.next;
        
        while(newNode!=nil) {
            if(newNode.data.equals(obj))
                return index;
            index++;
            newNode=newNode.next;
        }
        return -1;
            
    }
      public String  toString(){
       
       String output = "";
        for (String s: this) {
            output+= s.toString();
        }
       
       return output;
    }
     
    public Iterator<String> iterator(){
        return  new DListIterator();
    } 
     
    
    
    public static void main(String[] args){
         MyNilLinkedList alist = new MyNilLinkedList();
         
        
         alist.addFirst("Farukh");
         alist.addLast("Umida");
         alist.addLast("Diana");
        
         System.out.println(alist);
         System.out.println(alist.getFirst());
         System.out.println(alist.getLast());
         alist.removeFirst();
         System.out.println(alist);
         alist.removeLast();
         System.out.println(alist);
         System.out.println(alist.size());
         System.out.println(alist.get(0));
         System.out.println(alist.set(0,"Diana"));
         System.out.println(alist.contains("Diana"));
    }
    
}
