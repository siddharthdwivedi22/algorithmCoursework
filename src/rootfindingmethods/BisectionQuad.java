
package rootfindingmethods;



public class BisectionQuad {
    Stack s = new ArrayStack();
    int size = 0;
    
    public void getBisection() {
        //public static void main(String[] args) {
        
        
        
        double xlower,xupper,xnew,fxlower,fxupper,fxnew,diff;
        int iteration;
        xlower=0.0;
        fxlower = xlower - Math.pow(xlower, 2);
        xupper=0.5;
        fxupper = xupper - Math.pow(xupper, 2);
        iteration=0;
        do
        {
            iteration = iteration + 1;
            xnew = (xlower+xupper)/2.0;
            fxnew = xnew - Math.pow(xnew, 2);
            System.out.println("Approx for iteration"+iteration+"  is "+xnew);
            s.push(xnew,fxnew);
            diff = Math.abs(xupper-xlower)/2;
            if (fxlower*fxnew>0)
            {
                xlower = xnew;
                fxlower = fxnew;
            }
            else if (fxupper*fxnew>0)
            {
                xupper = xnew;
                fxupper = fxnew;
            }
            
        }
        while (diff>0.000001);
        System.out.println("root to six decimal places is "+xnew);
        
        }
    
    public Object[][] returnBisectionResults() {
        size = s.size();
        Object[][] data = new Object[size][2];
        int i = (size-1);
        while(!s.isEmpty()) {
            data[i][0] = s.popElement1();
            data[i][1] = s.popElement2();
            System.out.println("data" + data[i][0]);
            i--;
        }
        
        return data;
    }
    public int getArraySize() {
        return size;
    }

   
    
}
