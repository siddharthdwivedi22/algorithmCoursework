
package rootfindingmethods;



 public class SecantQuad {

   public void getSecant()
    {
        
     Stack s = new ArrayStack();
        
       
        double xold1,xold2,xnew,fxnew,fxold1,fxold2,diff;
        int iteration;
        xold1=-1;
        xold2=0.5;
        iteration=0;    
        do 
        {
            
            iteration = iteration + 1;
            fxold1 = xold1 - Math.pow(xold1, 2);
            fxold2 = xold2 - Math.pow(xold2, 2);
            xnew = xold1 - (fxold1*(xold1-xold2))/(fxold1-fxold2);
            fxnew = xnew - Math.pow(xnew, 2);
            System.out.println("Approx for iteration"+iteration+ " is "+ xnew);
            diff = Math.abs(xnew-xold1);
            xold2 = xold1;
            xold1 = xnew;
            s.push(xnew, fxnew);
            
        }
        while (diff<0.000001);
        System.out.println("root to six decimal places is "+xnew);
    }
    
}
