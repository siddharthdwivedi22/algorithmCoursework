package rootfindingmethods;





public class ArrayStack implements Stack {

    protected int capacity; 	// The actual capacity of the stack array
    public static final int CAPACITY = 2;	// default array capacity
    protected Object S[][];		// Generic array used to implement the stack 
    protected int top = -1;	// index for the top of the stack (-1 = empty stack)

    public ArrayStack() {
        this(CAPACITY); // default capacity 
    }

    public ArrayStack(int cap) {
        capacity = cap;
        S = new Object[2][capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(Object element1, Object element2) throws FullStackException {
        if (size() == capacity) {
      //throw new FullStackException("Stack is full. Stack size max is "+ capacity);
            // can replace previous line with code to double stack size
            doubleArray();
        }
        S[0][++top] = element1;
        S[1][top] = element2;
    }

    public Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        return S[0][top];
        
    }

    public Object popElement1() throws EmptyStackException {
        Object element1;
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        element1 = S[0][top];
        S[0][top] = null; // dereference S[top] for garbage collection.
        return element1;
    }
    
    public Object popElement2() throws EmptyStackException {
        Object element2;
        if(isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        element2 = S[1][top];
        S[1][top--] = null;
        return element2;
    }

    private void doubleArray() {
        Object[][] newArray;

        System.out.println("Stack is full (max size was " + capacity + "). Increasing to " + (2 * capacity));
        //double variable capacity
        capacity = 2 * capacity;
        newArray = new Object[2][capacity];
        for (int i = 0; i < S.length; i++) {
            newArray[0][i] = S[0][i];
            newArray[1][i] = S[1][i];
        }
        S = newArray;
    } 

}
