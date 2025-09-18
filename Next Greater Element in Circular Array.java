import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // default = -1
        Stack<Integer> st = new Stack<>();
        
        // Traverse 2n - 1 → 0 (circular)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;  // wrap around
            
            // Pop smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[idx]) {
                st.pop();
            }
            
            // Fill result only in first pass (i < n)
            if (i < n && !st.isEmpty()) {
                res[idx] = st.peek();
            }
            
            // Push current element
            st.push(arr[idx]);
        }
        
        // Convert int[] → ArrayList<Integer>
        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : res) {
            ans.add(val);
        }
        
        return ans;
    }
}
