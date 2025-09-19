class SpecialStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    public SpecialStack() {
        // Define Stack
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        mainStack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek())
        {
            minStack.push(x);
            
        }
        else
        {
             // maintain previous min
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        // Remove the top element from the Stack
         if (mainStack.isEmpty()) {
            return;  // or throw exception depending on requirement
        }
        mainStack.pop();
        minStack.pop();
    }

    public int peek() {
        // Returns top element of the Stack
          if (mainStack.isEmpty()) {
            return -1;  // or some sentinel / exception
        }
        return mainStack.peek();
    }

    boolean isEmpty() {
        // Check if the stack is empty
          return mainStack.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
         if (minStack.isEmpty()) {
            return -1;  // or sentinel / exception
        }
        return minStack.peek();
    }
}
