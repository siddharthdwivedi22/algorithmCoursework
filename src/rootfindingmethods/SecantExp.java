package rootfindingmethods;




public class SecantExp {
    
    public static void main(String[] args)
    {
        Stack s = new ArrayStack();
            
        
        double xold1,xold2,xnew,fxold1,fxold2,fxnew,diff;
        int iteration;
        xold1=-1.0;
        xold2=3.0;
        iteration=0;
        do 
        {
            iteration = iteration + 1;
            fxold1 = Math.exp(xold1) - 3*xold1;
            fxold2 = Math.exp(xold2) - 3*xold2;
            xnew = xold1 - (fxold1*(xold1-xold2))/(fxold1-fxold2);
            fxnew = Math.exp(xnew) - 3*xnew;
            s.push(xnew,fxnew);
            System.out.println("Approx for iteration"+iteration+ " is "+xnew);
            diff = Math.abs(xnew-xold1);
            xold2 = xold1;
            xold1 = xnew;
            
        }
        while (diff>0.000001);
        System.out.println("root to six decimal places is "+xnew);
    }
    
}

