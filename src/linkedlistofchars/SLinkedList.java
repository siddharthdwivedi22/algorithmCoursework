/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlistofchars;

import java.util.*;



public class SLinkedList {

    
    protected StringNode head;
    public  SLinkedList() {
        head = new StringNode();
    }

//    public static void main(String[] args) {
//         //set up a linked list of 4 integers
//	  SLinkedList thelist = new SLinkedList();
//          thelist.head.setElement("Steve", 22);
//          thelist.addFirst("Jasmina", 22);
//          thelist.addMid("Phuong", 45, "Jasmina");
//          thelist.addMid("Felicia",63,"Jasmina");
//          thelist.addMid("Siddharth",98,"Jasmina");
//          thelist.addMid("Richard",100,"Phuong");
//          thelist.addLast("Patricia", 43);
//          printList(thelist);
//          thelist.removeFirst();
//          System.out.println("removed first...");
//          printList(thelist);
//          thelist.removeLast();
//          System.out.println("removed last...");
//          printList(thelist);
//          System.out.println("attempting to remove item Phuong from mid...");
//          thelist.removeMid("Phuong");
//          printList(thelist);
//          
//          
//    }

    //add a new node to the head of the list
    private void addFirst(String element, int age) {
        // make variable head point to new node
        head = new StringNode(element+age,head);
    }

    private void addLast(String element, int age) {
        StringNode tail;
        tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
            }
        //insert new node at end of list
        tail.setNext( new StringNode(element+age,null));
    }

    //add a new node after position of curnode
    private void addMid(String element, int age, String entryafter) {
        StringNode curnode;
        curnode = head;
        //go to last node and remember previous node at all times
        while (curnode != null && curnode.getElement() != entryafter) {
            curnode = curnode.getNext();
            }
        //if first occurrence of element entryafter was located then insert new node
        if (curnode != null) {
            StringNode newnode = new StringNode(element+age,curnode.getNext());
            curnode.setNext(newnode);
            }
    }

    private boolean isEmpty() {
        return  head == null;
    }

    private void removeFirst() {
        StringNode oldhead;
        oldhead = head;
        //remove first node from linked list
        if (head != null) {
           head = head.getNext();
           oldhead.setNext(null);
           }
        else {
           throw new NoSuchElementException();
           }
    }

    private void removeLast() {
        StringNode temp, previous;
        temp = head;
        previous = temp;
        //go to last node and remember previous node at all times
        while (temp != null && temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
            }
        if (previous != null) {
           //remove last node
           previous.setNext(null);
           }
        else {
           throw new NoSuchElementException();
           }
    }

    //very similar to removeLast except we are looking for element i
    private void removeMid(String element) {
        StringNode temp, previous;
        temp = head.getNext();
        previous = null;
        //go to node containing element and rermember previous node at all times
        while (temp.getElement() != element && temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
            }
        if (previous != null && temp.getNext() != null) {
           //not first or last node so we can remove node defined by temp. 
           // set the previous node to that after temp
           previous.setNext(temp.getNext());
           temp.setNext(null);
        }
        else {
           throw new NoSuchElementException();
           }
    }
    public static void printList(SLinkedList thelist) {
        StringNode temp;
        if(thelist.isEmpty())
            System.out.println("List is empty");
        else {
            temp = thelist.head;
            while (temp != null) {
               System.out.print(temp.getElement()+" ");
               temp = temp.getNext();
            }
            System.out.println();
        }
    }

}
