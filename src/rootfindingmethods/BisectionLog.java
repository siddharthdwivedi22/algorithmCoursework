package rootfindingmethods;



public class BisectionLog {
    
    Stack s = new ArrayStack();   
    int size = 0;
        
    public void getBisectionLog() {
       
        
        
        double xlower,xupper,xnew,fxlower,fxupper,fxnew,diff;
        int iteration;
        xlower=0.0;
        fxlower = Math.log(xlower+1) + 1;
        xupper=0.5;
        fxupper = Math.log(xupper+1) + 1;
        iteration=0;
        
        do
        {
            iteration = iteration + 1;
            xnew = (xlower+xupper)/2.0;
            fxnew = Math.log(xnew+1) + 1;
            s.push(xnew, fxnew);
            System.out.println("Approx for iteration"+iteration+"  is "+xnew);
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
    
     public Object[][] returnBisectionLogResults() {
        size = s.size();
        Object[][] data = new Object[size][2];
        int i = 0;
        while(!s.isEmpty()) {
            data[i][0] = s.popElement1();
            data[i][1] = s.popElement2();
            System.out.println("dataaa" + data[i][0]);
            i++;
        }
        
        return data;
    }
    public int getArraySize() {
        return size;
    }
}

