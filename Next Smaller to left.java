
//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int rrr[])
    {
         List<Integer> ans = new ArrayList<>(); // Correct List instantiation
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from stack that are >= current element
            while (!stack.isEmpty() && stack.peek() >= rrr[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element exists → add -1
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            // Push current element into the stack
            stack.push(rrr[i]);
        }
        return ans;
    }
}
