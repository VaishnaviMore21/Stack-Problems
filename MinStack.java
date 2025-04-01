import java.util.Stack;

class MinStack {

    Stack<Long> st = new Stack<>(); // Stack to store values (including modified values for min tracking)
    Long mini; // Variable to store the minimum element

    /** Initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE; // Initially, set mini to the maximum possible value
    }
    
    /** Pushes a value onto the stack */
    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val; // If stack is empty, set mini to the pushed value
            st.push(val); // Push the value as is
        } else {
            if (val < mini) {
                // Store a modified value that helps in tracking the previous min value
                st.push(2 * val - mini);
                mini = val; // Update mini to the new minimum value
            } else {
                st.push(val); // Otherwise, push the value normally
            }
        }
    }
    
    /** Removes the top element from the stack */
    public void pop() {
        if (st.isEmpty()) return; // If stack is empty, do nothing
        
        Long val = st.pop(); // Pop the top value
        if (val < mini) { 
            // If the popped value is a modified value, restore the previous minimum
            mini = 2 * mini - val;
        }
    }
    
    /** Gets the top element of the stack */
    public int top() {
        Long val = st.peek(); // Get the top element
        if (val < mini) {
            return mini.intValue(); // If it's a modified value, return the current mini
        }
        return val.intValue(); // Otherwise, return the normal value
    }

    /** Retrieves the minimum element in the stack */
    public int getMin() {
        return mini.intValue(); // Return the minimum element
    }
}
