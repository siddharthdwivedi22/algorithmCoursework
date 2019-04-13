package rootfindingmethods;




public class SecantLog {
    
    public static void main(String[] args)
    {
       
        Stack s = new ArrayStack();  
        
        double xold1,xold2,xnew,fxold1,fxold2,fxnew,diff;
        int iteration;
        xold1=0.0;
        xold2=0.00005;
        iteration=0;
        do 
        {
            iteration = iteration + 1;
            fxold1 = Math.log(xold1+1) + 1;
            fxold2 = Math.log(xold2+1) + 1;
            xnew = xold1 - (fxold1*(xold1-xold2))/(fxold1-fxold2);
            fxnew = Math.log(xnew+1) + 1;
            s.push(xnew,fxnew);
            System.out.println("Approx for iteration"+iteration+ " is "+xnew);
            diff = Math.abs(xnew-xold1);
            xold2 = xold1;
            xold1 = xnew;
            
        }
        while (diff<0.000001);
        System.out.println("root to six decimal places is "+xnew);
    }
    
}

