
package rootfindingmethods;

import java.util.LinkedList;
import java.util.ListIterator;
import static rootfindingmethods.SLinkedList.printList;


public class NewtonRaphsonQuad {
SLinkedList function1linkedList = new SLinkedList();

    public static void main(String[] args) {
        new NewtonRaphsonQuad();
    } 
    public NewtonRaphsonQuad() {
        
        double xold, xnew, fxold, fdashxold, diff;
        int iteration;
        xold = 0.50001;
        iteration = 0;
        do 
        {
          iteration = iteration + 1;
          fxold = xold - Math.pow(xold,2);
          fdashxold = 1.0 - 2*xold;
          xnew = xold - (fxold/fdashxold);
          function1linkedList.head.setElement(xnew);
          printList(function1linkedList,iteration);     
          
          diff = Math.abs(xnew-xold);
          xold = xnew;
        }
        while (diff > 0.000001);
        
              
               
          }
       
        
    
    }
   
