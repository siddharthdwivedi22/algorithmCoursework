
package rootfindingmethods;

import java.util.LinkedList;
import java.util.ListIterator;


public class NewtonRaphsonLog {
LinkedList <Double> list = new LinkedList<>();

    public static void main(String[] args) {
        new NewtonRaphsonLog();
    } 
    public NewtonRaphsonLog() {
        
        double xold, xnew, fxold, fdashxold, diff;
        int iteration;
        xold = 0.50001;
        iteration = 0;
        do 
        {
          iteration = iteration + 1;
          fxold = Math.log(xold + 1)+1;
          fdashxold = 1.0/(xold+1);
          xnew = xold - (fxold/fdashxold);
          list.add(xnew);     
          
          diff = Math.abs(xnew-xold);
          xold = xnew;
        }
        while (diff > 0.000001);
        ListIterator<Double> listIterator = list.listIterator();
          while(listIterator.hasNext()) {
              double value = listIterator.next();
              
               System.out.println("Approx for iteration"  + list.indexOf(value) + " is " + value);
          }
       
        System.out.println("root to six decimal places is "+xnew);
    
    }
    
}

