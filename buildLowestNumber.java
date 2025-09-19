// User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int N) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            // pop larger digits if possible
            while (!st.isEmpty() && N > 0 && st.peek() > ch) {
                st.pop();
                N--;
            }
            st.push(ch);
        }

        // If still N digits left, remove from end
        while (N > 0 && !st.isEmpty()) {
            st.pop();
            N--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char d : st) {
            sb.append(d);
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If empty string → return "0"
        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}
