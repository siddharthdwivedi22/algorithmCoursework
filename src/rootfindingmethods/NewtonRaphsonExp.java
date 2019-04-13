package rootfindingmethods;

import java.util.LinkedList;
import java.util.ListIterator;
import rootfindingmethods.NewtonRaphsonQuad;
import java.lang.*;

public class NewtonRaphsonExp {
LinkedList <Double> list = new LinkedList<>();

    public static void main(String[] args) {
        new NewtonRaphsonExp();
    } 
    public NewtonRaphsonExp() {
        
        double xold, xnew, fxold, fdashxold, diff;
        int iteration;
        xold = 0.50001;
        iteration = 0;
        do 
        {
          iteration = iteration + 1;
          fxold = Math.exp(xold) - 3*xold;
          fdashxold = Math.exp(xold) - 3;
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